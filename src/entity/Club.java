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
public class Club 
{
    private int ClubID;
    private String ClubName;
    private String ClubRegularMeetingDays;
    private String ClubRegularMeetingTimes;
    private String ClubPresident;
    private int ClubMemberCount;
    
    public Club(int ClubID, String ClubName, String ClubRegularMeetingDays, String ClubRegularMeetingTimes, String ClubPresident, int ClubMemberCount)
    {
        this.ClubID = ClubID;
        this.ClubName = ClubName;
        this.ClubRegularMeetingDays = ClubRegularMeetingDays;
        this.ClubRegularMeetingTimes = ClubRegularMeetingTimes;
        this.ClubPresident = ClubPresident;
        this.ClubMemberCount = ClubMemberCount;
    }

    public int getClubID() {
        return ClubID;
    }

    public String getClubName() {
        return ClubName;
    }

    public String getClubRegularMeetingDays() {
        return ClubRegularMeetingDays;
    }

    public String getClubRegularMeetingTimes() {
        return ClubRegularMeetingTimes;
    }

    public String getClubPresident() {
        return ClubPresident;
    }

    public int getClubMemberCount() {
        return ClubMemberCount;
    }


 
    @Override
    public String toString() {
        return "Club{" + "ClubID=" + ClubID + ", ClubName=" + ClubName + ", ClubRegularMeetingDays=" + ClubRegularMeetingDays + ", ClubRegularMeetingTimes=" + ClubRegularMeetingTimes + ", ClubPresident=" + ClubPresident + ", ClubMemberCount=" + ClubMemberCount + '}';
    }
}
