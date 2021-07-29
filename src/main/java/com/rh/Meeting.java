package com.rh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meeting")
public class Meeting {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
 
    @Column(name = "title")
    private String title;
 
	@Column(name = "type")
    private String type;
 
    @Column(name = "meeting_day")
    private String meeting_day;
    
    @Column(name = "meeting_time")
    private String meeting_time ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getmeeting_day() {
		return meeting_day;
	}

	public void setmeeting_day(String meeting_day) {
		this.meeting_day = meeting_day;
	}

	public String getMeeting_time() {
		return meeting_time;
	}

	public void setMeeting_time(String meeting_time) {
		this.meeting_time = meeting_time;
	}
    
	
    
    
}
