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
public class RoomDAO implements DAO<Room>
{   
    public RoomDAO() {
        
    }
    List<Room> rooms;
    /**
     * Get a single club entity as a club object
     * @param id
     * @return 
     */
    @Override
    public Optional<Room> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Room WHERE RoomID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Room room = null;
            while (rs.next()) {
                room = new Room(rs.getInt("RoomID"), rs.getString("RoomName"), rs.getString("RoomLocation"), rs.getInt("RoomCapacity"));
            }
            return Optional.ofNullable(room);
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
    public List<Room> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        rooms = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Room";
            rs = db.executeQuery(sql);
            Room room = null;
            while (rs.next()) {
                room = new Room(rs.getInt("RoomID"), rs.getString("RoomName"), rs.getString("RoomLocation"), rs.getInt("RoomCapacity"));
                rooms.add(room);
            }
            return rooms;
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
    public void insert(Room room)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Room(RoomID, RoomName, RoomLocation, RoomCapacity) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, room.getRoomID());
            stmt.setString(2, room.getRoomName());
            stmt.setString(3, room.getRoomLocation());
            stmt.setInt(4, room.getRoomCapacity());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new room was inserted successfully!");
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
    public void update(Room room) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Room SET RoomName=?, RoomLocation=?, RoomCapacity=? WHERE RoomID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, room.getRoomName());
            stmt.setString(2, room.getRoomLocation());
            stmt.setInt(3, room.getRoomCapacity());
            stmt.setInt(4, room.getRoomID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing room was updated successfully!");
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
    public void delete(Room room) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Room WHERE RoomID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, room.getRoomID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A room was deleted successfully!");
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
            String sql = "SELECT * FROM Room WHERE RoomID = -1";//We just need this sql query to get the column headers
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
