package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl  implements MeetingService {

	
	@Autowired
	private MeetingRepository rep ;
	
	
	@Override
	public List<Meeting> getAllMeetings() {
		return this.rep.findAll();
	}

	@Override
	public void saveMeeting(Meeting meeting) {
		this.rep.save(meeting) ;
		
	}

	@Override
	public Meeting getMeetinById(long id) {
		
		Optional<Meeting> optional = this.rep.findById(id);
		
		Meeting meet = null ;
		
		if(optional.isPresent()) {
			
			meet = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " meet d'id =  " + id + " is not found !! " ) ;
		}
		
		return meet ;
	}

	@Override
	public void deleteMeetingById(long id) {

		this.rep.deleteById(id);
		
	}

	
	@Override
	public List<Meeting> getMeetingByTitle(String title){
		return this.rep.getMeetingByTitle(title);
	}
	
	@Override
	public Meeting update_meeting(long id , Meeting meeting) {
		
		
	Meeting old_meeting = this.getMeetinById(id) ;
		
		// delete the old meeting
		
		this.rep.deleteById(id);
		
		old_meeting.setTitle(  meeting.getTitle() );
		
		old_meeting.setType( meeting.getType() );
		
		old_meeting.setmeeting_day( meeting.getmeeting_day() );
		
		old_meeting.setMeeting_time( meeting.getMeeting_time() );
		
		// save the new meeting 
		
		this.rep.save(old_meeting) ;
		
		return old_meeting ;
		
		
	}
}
