package com.neogrid.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventViewTest {

	@Test
	public void getDefaultScheduleEvent001() {
		StringBuilder lectures = new StringBuilder();
		lectures.append("09:00 Ruby on Rails Legacy App Maintenance\n");
		lectures.append("10:00 Ruby on Rails: Why We Should Move On\n");
		lectures.append("11:00 Rails Magic\n");
		lectures.append("12:00 Lunch\n");
		lectures.append("13:00 Communicating Over Distance\n");
		lectures.append("14:00 Writing Fast Tests Against Enterprise Rails\n");
		lectures.append("15:00 Clojure Ate Scala (on my project)\n");
		lectures.append("15:45 Pair Programming vs Noise\n");
		lectures.append("16:30 User Interface CSS in Rails Apps\n");
		lectures.append("17:00 Networking Event");
		EventView scheduleView = new EventView();
		assertEquals(lectures.toString(), scheduleView.getScheduleEvent());
	}
	
	@Test
	public void getDefaultScheduleEvent002() {
		StringBuilder lectures = new StringBuilder();
		lectures.append("09:00 Ruby on Rails Legacy App Maintenance\n");
		lectures.append("10:00 Ruby on Rails: Why We Should Move On\n");
		lectures.append("11:00 Rails Magic\n");
		lectures.append("12:00 Lunch\n");
		lectures.append("13:00 Communicating Over Distance\n");
		lectures.append("14:00 Writing Fast Tests Against Enterprise Rails\n");
		lectures.append("15:00 Clojure Ate Scala (on my project)\n");
		lectures.append("15:45 Pair Programming vs Noise\n");
		lectures.append("16:30 User Interface CSS in Rails Apps\n");
		lectures.append("17:00 Networking Event");
		EventView scheduleView = new EventView("09:00", "12:00", "1:00", "16:00", "17:00");
		assertEquals(lectures.toString(), scheduleView.getScheduleEvent());
	}
	
	@Test
	public void getDefaultScheduleEvent003() {
		StringBuilder lectures = new StringBuilder();
		lectures.append("08:00 Ruby on Rails Legacy App Maintenance\n");
		lectures.append("09:00 Ruby on Rails: Why We Should Move On\n");
		lectures.append("10:00 Rails Magic\n");
		lectures.append("11:00 Communicating Over Distance\n");
		lectures.append("12:00 Lunch\n");
		lectures.append("13:00 Writing Fast Tests Against Enterprise Rails\n");
		lectures.append("14:00 Clojure Ate Scala (on my project)\n");
		lectures.append("14:45 Pair Programming vs Noise\n");
		lectures.append("15:30 Accounting-Driven Development\n"); 
		lectures.append("16:15 Common Ruby Errors\n");
		lectures.append("17:00 Networking Event");
		EventView scheduleView = new EventView("08:00", "12:00", "1:00", "16:00", "17:00");
		assertEquals(lectures.toString(), scheduleView.getScheduleEvent());
	}
	
	@Test
	public void getDefaultScheduleEvent004() {
		StringBuilder lectures = new StringBuilder();
		lectures.append("09:00 Ruby on Rails Legacy App Maintenance\n");
		lectures.append("10:00 Ruby on Rails: Why We Should Move On\n");
		lectures.append("11:00 Rails Magic\n");
		lectures.append("12:00 Lunch\n");
		lectures.append("13:00 Rails for Python Developers\n");
		lectures.append("13:05 Writing Fast Tests Against Enterprise Rails\n");
		lectures.append("14:05 Clojure Ate Scala (on my project)\n");
		lectures.append("14:50 Pair Programming vs Noise\n");
		lectures.append("15:35 User Interface CSS in Rails Apps\n");
		lectures.append("16:05 Networking Event");
		EventView scheduleView = new EventView("09:00", "12:00", "1:00", "16:00", "16:05");
		assertEquals(lectures.toString(), scheduleView.getScheduleEvent());
	}
	
	@Test
	public void getDefaultScheduleEvent005() {
		StringBuilder lectures = new StringBuilder();
		lectures.append("09:00 Ruby on Rails Legacy App Maintenance\n");
		lectures.append("10:00 Ruby on Rails: Why We Should Move On\n");
		lectures.append("11:00 User Interface CSS in Rails Apps\n");
		lectures.append("11:30 Lunch\n");
		lectures.append("12:20 Rails Magic\n");
		lectures.append("13:20 Communicating Over Distance\n");
		lectures.append("14:20 Writing Fast Tests Against Enterprise Rails\n");
		lectures.append("15:20 Clojure Ate Scala (on my project)\n");
		lectures.append("16:05 Pair Programming vs Noise\n");
		lectures.append("16:50 Rails for Python Developers\n");
		lectures.append("16:55 Networking Event");
		EventView scheduleView = new EventView("09:00", "11:30", "0:50", "16:00", "17:00");
		assertEquals(lectures.toString(), scheduleView.getScheduleEvent());
	}
	
}
