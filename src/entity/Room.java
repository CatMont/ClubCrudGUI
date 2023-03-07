/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Room 
{
    private int RoomID;
    private String RoomName;
    private String RoomLocation;
    private int RoomCapacity;
    
    public Room(int RoomID, String RoomName, String RoomLocation, int RoomCapacity)
    {
        this.RoomID = RoomID;
        this.RoomName = RoomName;
        this.RoomLocation = RoomLocation;
        this.RoomCapacity = RoomCapacity;
       
    }

    public int getRoomID() {
        return RoomID;
    }

    public String getRoomName() {
        return RoomName;
    }

    public String getRoomLocation() {
        return RoomLocation;
    }

    public int getRoomCapacity() {
        return RoomCapacity;
    }


 
    @Override
    public String toString() {
        return "Room{" + "RoomID=" + RoomID + ", RoomName=" + RoomName + ", RoomLocation=" + RoomLocation + ", RoomCapacity=" + RoomCapacity + '}';
    }
}
