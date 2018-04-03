package com.neogrid.view;

import java.util.List;

import com.neogrid.controller.LectureController;
import com.neogrid.controller.EventController;
import com.neogrid.model.Lecture;
import com.neogrid.model.Event;

public class EventView {
	
	private static final int START_TIME = 540;
	private static final int QTD_MINUTES_MORNING = 180;
	private static final int QTD_MINUTES_LUCH = 60;
	private static final int QTD_MIN_MINUTES_AFTERNOON = 180;
	private static final int QTD_MAX_MINUTES_AFTERNOON = 240;

	private int startTimeEvent;
	private int startTimeLunch;
	private int lunchTimeEvent;
	private int startTimeNetwork;
	private int maxTimeToStartNetwork;
	
	public EventView() {
		this.startTimeEvent = START_TIME;
		this.startTimeLunch = QTD_MINUTES_MORNING;
		this.lunchTimeEvent = QTD_MINUTES_LUCH;
		this.startTimeNetwork = QTD_MIN_MINUTES_AFTERNOON;
		this.maxTimeToStartNetwork = QTD_MAX_MINUTES_AFTERNOON;
	}
	
	public EventView(String startTimeEvent, String startTimeLuch, String lunchTimeEvent, 
			String startTimeNetwork, String maxTimeToStartNetwork) {
		this.startTimeEvent = convertHoursToMinutes(startTimeEvent);
		this.startTimeLunch = convertHoursToMinutes(startTimeLuch) - this.startTimeEvent;
		this.lunchTimeEvent = convertHoursToMinutes(lunchTimeEvent);
		this.startTimeNetwork = convertHoursToMinutes(startTimeNetwork) - (convertHoursToMinutes(startTimeLuch) + this.lunchTimeEvent);
		this.maxTimeToStartNetwork = convertHoursToMinutes(maxTimeToStartNetwork) - (convertHoursToMinutes(startTimeLuch) + this.lunchTimeEvent);
	}
	
	public String getScheduleEvent() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		Event sortSchedule = EventController.sortSchedule(lectures, getStartTimeEvent(), getStartTimeLunch(), 
				getLunchTimeEvent(), getStartTimeNetwork(), getMaxTimeToStartNetwork());
		StringBuilder lecturesSorted = new StringBuilder();
		for (Lecture lecture : sortSchedule.getSessions()) {
			lecturesSorted.append(lecture.toString() + "\n");
		}
		
		return lecturesSorted.toString().trim();
	}
	
	public int getStartTimeEvent() {
		return startTimeEvent;
	}

	public int getStartTimeLunch() {
		return startTimeLunch;
	}

	public int getLunchTimeEvent() {
		return lunchTimeEvent;
	}

	public int getStartTimeNetwork() {
		return startTimeNetwork;
	}

	public int getMaxTimeToStartNetwork() {
		return maxTimeToStartNetwork;
	}

	private int convertHoursToMinutes(String time) {
		 int minutes=0;
	     String[] arr= time.split(":");
	    if(arr.length==2){
	        minutes=Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
	    }
	    
	    
	    return minutes;
	}
}
