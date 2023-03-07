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
public class ClubDAO implements DAO<Club>
{   
    public ClubDAO() {
        
    }
    List<Club> clubs;
    /**
     * Get a single club entity as a club object
     * @param id
     * @return 
     */
    @Override
    public Optional<Club> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Club WHERE ClubID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Club club = null;
            while (rs.next()) {
                club = new Club(rs.getInt("ClubID"), rs.getString("ClubName"), rs.getString("ClubRegularMeetingDays"), rs.getString("ClubRegularMeetingTimes"), rs.getString("ClubPresident"), rs.getInt("ClubMemberCount"));
            }
            return Optional.ofNullable(club);
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
    public List<Club> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        clubs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Club";
            rs = db.executeQuery(sql);
            Club club = null;
            while (rs.next()) {
                club = new Club(rs.getInt("ClubID"), rs.getString("ClubName"), rs.getString("ClubRegularMeetingDays"), rs.getString("ClubRegularMeetingTimes"), rs.getString("ClubPresident"), rs.getInt("ClubMemberCount"));
                clubs.add(club);
            }
            return clubs;
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
    public void insert(Club club)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Club(ClubID, ClubName, ClubRegularMeetingDays, ClubRegularMeetingTimes, ClubPresident, ClubMemberCount) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, club.getClubID());
            stmt.setString(2, club.getClubName());
            stmt.setString(3, club.getClubRegularMeetingDays());
            stmt.setString(4, club.getClubRegularMeetingTimes());
            stmt.setString(5, club.getClubPresident());
            stmt.setInt(6, club.getClubMemberCount());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new club was inserted successfully!");
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
    public void update(Club club) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Club SET ClubName=?, ClubRegularMeetingDays=?, ClubRegularMeetingTimes=?, ClubPresident=?, ClubMemberCount=? WHERE ClubID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, club.getClubName());
            stmt.setString(2, club.getClubRegularMeetingDays());
            stmt.setString(3, club.getClubRegularMeetingTimes());
            stmt.setString(4, club.getClubPresident());
            stmt.setInt(5, club.getClubMemberCount());
            stmt.setInt(6, club.getClubID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing club was updated successfully!");
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
    public void delete(Club club) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Club WHERE ClubID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, club.getClubID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A club was deleted successfully!");
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
            String sql = "SELECT * FROM Club WHERE ClubID = -1";//We just need this sql query to get the column headers
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
