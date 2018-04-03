package com.neogrid.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.neogrid.model.Lecture;
import com.neogrid.model.Event;

public class ScheduleControllerTest {
	
	@Test
	public void sortSchedule001() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		
		Event schedule = EventController.sortSchedule(lectures, 540, 180, 60, 180, 240); 
		List<Lecture> sessions = schedule.getSessions();
		assertEquals("09:00", sessions.get(0).getStartTime());
		assertEquals("17:00", sessions.get(sessions.size() - 1).getStartTime());
	}
	
	@Test
	public void sortSchedule002() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		
		Event schedule = EventController.sortSchedule(lectures, 540, 180, 60, 180, 240);
		boolean hasLunchLecture = false;
		for (Lecture lecture : schedule.getSessions()) {
			if (lecture.getStartTime().equals("12:00")) {
				assertEquals("Lunch", lecture.getDescription());
			} 
			
			if ("Lunch".equals(lecture.getDescription())) {
				hasLunchLecture = true;
				assertEquals("12:00", lecture.getStartTime());
			}
		}
		
		assertTrue(hasLunchLecture);
	}
	
	@Test
	public void sortSchedule003() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		
		Event schedule = EventController.sortSchedule(lectures, 540, 180, 60, 180, 240);
		List<Lecture> sessions = schedule.getSessions();
		assertEquals("17:00", sessions.get(sessions.size() - 1).getStartTime());
		assertEquals("Networking Event", sessions.get(sessions.size() - 1).getDescription());
	}
}
