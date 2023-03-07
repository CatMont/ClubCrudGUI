/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Gokhan
 */
public class RoomReservationDAO implements DAO<RoomReservation>
{   
    public RoomReservationDAO() {
        
    }
    List<RoomReservation> roomreservations;
    /**
     * Get a single club entity as a club object
     * @param id
     * @return 
     */
    @Override
    public Optional<RoomReservation> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM RoomReservation WHERE RoomReservationID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            RoomReservation roomreservation = null;
            while (rs.next()) {
                 roomreservation = new RoomReservation(rs.getInt("RoomReservationID"), rs.getInt("RoomID"), rs.getInt("ClubID"), rs.getString("ReservationStartDateTime"), rs.getString("ReservationEndDateTime"), rs.getInt("NumberofGuests"));
            }
            return Optional.ofNullable(roomreservation);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all club entities as a List
     * @return 
     */
    @Override
    public List<RoomReservation> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        roomreservations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM RoomReservation";
            rs = db.executeQuery(sql);
            RoomReservation roomreservation = null;
            while (rs.next()) {
                roomreservation = new RoomReservation(rs.getInt("RoomReservationID"), rs.getInt("RoomID"), rs.getInt("ClubID"), rs.getString("ReservationStartDateTime"), rs.getString("ReservationEndDateTime"), rs.getInt("NumberofGuests"));
                roomreservations.add(roomreservation);
            }
            return roomreservations;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a club object into club table
     * @param club 
     */
    @Override
    public void insert(RoomReservation roomreservation)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO RoomReservation(RoomReservationID, RoomID, ClubID, ReservationStartDateTime, ReservationEndDateTime, NumberOfGuests) VALUES (?, ?, ?, ?, ?, ? )";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, roomreservation.getRoomReservationID());
            stmt.setInt(2, roomreservation.getClubID());
            stmt.setInt(3, roomreservation.getRoomID());
            stmt.setString(4, roomreservation.getReservationStartDateTime());
            stmt.setString(5, roomreservation.getReservationEndDateTime());
            stmt.setInt(6, roomreservation.getNumberOfGuests());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new room reservation was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a club entity in database if it exists using a club object
     * @param club
     */
    @Override
    public void update(RoomReservation roomreservation) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Room SET ClubID=?, RoomID=?, ReservationStartDateTime=?, ReservationEndDateTime=?, NumberOfGuests=? WHERE RoomReservationID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, roomreservation.getClubID());
            stmt.setInt(2, roomreservation.getRoomID());
            stmt.setString(3, roomreservation.getReservationStartDateTime());
            stmt.setString(4, roomreservation.getReservationEndDateTime());
            stmt.setInt(5, roomreservation.getNumberOfGuests());
            stmt.setInt(6, roomreservation.getRoomReservationID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing room reservation was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a club from club table if the entity exists
     * @param club 
     */
    @Override
    public void delete(RoomReservation roomreservation) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM RoomReservation WHERE RoomID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, roomreservation.getRoomReservationID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A room reservation was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM RoomReservation WHERE RoomID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
