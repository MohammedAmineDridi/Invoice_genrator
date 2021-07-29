package com.rh;

import java.util.List;

public interface MeetingService {


	List<Meeting> getAllMeetings() ;
	
	 void saveMeeting(Meeting meeting) ;
	 
	 Meeting getMeetinById(long id);
		
	 void deleteMeetingById(long id) ;
	 
	 List<Meeting> getMeetingByTitle(String title);
	 
	 Meeting update_meeting(long id , Meeting meeting);
	
}
