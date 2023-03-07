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
public class RoomReservation 
{
    private int RoomReservationID;
    private int ClubID; 
    private int RoomID;
    private String ReservationStartDateTime;
    private String ReservationEndDateTime;
    private int NumberOfGuests;
    
    public RoomReservation(int RoomReservationID, int ClubID, int RoomID, String ReservationStartDateTime, String ReservationEndDateTime, int NumberOfGuests)
    {
        this.RoomReservationID = RoomReservationID;
        this.ClubID = ClubID;
        this.RoomID = RoomID;
        this.ReservationStartDateTime = ReservationStartDateTime;
        this.ReservationEndDateTime = ReservationEndDateTime;
        this.NumberOfGuests = NumberOfGuests;
       
    }

    public int getRoomReservationID() {
        return RoomReservationID;
    }

    public int getClubID() {
        return ClubID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public String getReservationStartDateTime() {
        return ReservationStartDateTime;
    }

    public String getReservationEndDateTime() {
        return ReservationEndDateTime;
    }

    public int getNumberOfGuests() {
        return NumberOfGuests;
    }



 
    @Override
    public String toString() {
        return "RoomReservation{" + "RoomReservationID=" + RoomReservationID + ",ClubID=" + ClubID + ",RoomID=" + RoomID + ",ReservationStartDateTime=" + ReservationStartDateTime +",ReservationStartDateTime=" + ReservationStartDateTime + ",ReservationEndDateTime=" + ReservationEndDateTime + ",NumberOfGuests=" + NumberOfGuests + '}' ;
    }
}
