package com.neogrid.controller;

import java.util.ArrayList;
import java.util.List;

import com.neogrid.model.Lecture;
import com.neogrid.model.Event;

/**
 * Class with the controllers of a {@link Event}.
 * 
 * @author Hélinton Steffens
 *
 */
public final class EventController {

	private static List<Lecture> lecturesAux;
	
	private EventController() {
		
	}
	
	/**
	 * This method is responsible to format a schedule according a lecture list.
	 * 
	 * @param lectures
	 * @return a schedule according with the filters and lectures input.
	 */
	public static Event sortSchedule(List<Lecture> lectures, int initialTime, 
			int qtdMinutesMorning, int luchTime, int qtdMinMinutesAft, int qtdMaxMinutesAft) {
		Event schedule = new Event();
		List<Lecture> morningSession = sortMorningSession(lectures, qtdMinutesMorning);
		
		lectures.removeAll(morningSession);
		
		List<Lecture> afternoonSession = sortAfternoonSession(lectures, qtdMinMinutesAft, qtdMaxMinutesAft);
		
		schedule.setSessions(morningSession);
		schedule.getSessions().add(getLunchLecture(luchTime));
		schedule.getSessions().addAll(afternoonSession);
		schedule.getSessions().add(getNetworkingLecture());
		
		for (Lecture lecture : schedule.getSessions()) {
			lecture.setStartTime(getHours(initialTime));
			initialTime += lecture.getTime();
		}
		
		return schedule;
	}

	private static Lecture getNetworkingLecture() {
		return new Lecture(0, "Networking Event");
	}

	private static Lecture getLunchLecture(int luchTime) {
		return new Lecture(luchTime, "Lunch");
	}
	
	private static List<Lecture> sortMorningSession(List<Lecture> lectures, int qtdMinutosMorning) {
		sort(lectures.toArray(new Lecture[lectures.size()]), qtdMinutosMorning, qtdMinutosMorning);
		
		return lecturesAux;
	}
	
	private static List<Lecture> sortAfternoonSession(List<Lecture> lectures, int qtdMinMinutesAft, int qtdMaxMinutesAft) { 
		sort(lectures.toArray(new Lecture[lectures.size()]), qtdMinMinutesAft, qtdMaxMinutesAft);

		return lecturesAux;
	}
		
	private static void sort(Lecture[] lectures, int qtdMinutesMin, int qtdMinutesMax) {
		lecturesAux = new ArrayList<>();
		
		int qtdMinutes = 0; 

		for (int i = 0; i < lectures.length; i++) {
			if (qtdMinutes == qtdMinutesMax) {
				break;
			} else  if (qtdMinutes < qtdMinutesMax) {
				qtdMinutes += lectures[i].getTime();
				lecturesAux.add(lectures[i]);
			}
			
			if (qtdMinutes > qtdMinutesMax) {
				Lecture lastLecture = lecturesAux.get(lecturesAux.size() - 1);
				qtdMinutes -= lastLecture.getTime();
				lecturesAux.remove(lastLecture);
			}
		}
		
		if (qtdMinutes < qtdMinutesMin ||  qtdMinutes > qtdMinutesMax) {
			
			Lecture lastLecture = lectures[lectures.length - 1];
			Lecture firstLecture = lectures[0];
			lectures[lectures.length - 1] = firstLecture;
			lectures[0] = lastLecture;
			
			sort(lectures, qtdMinutesMin, qtdMinutesMax);
		}
	}
	
	private static String getHours(int timeOnMinutes) {
		int hours =  timeOnMinutes / 60;
		int minutes = timeOnMinutes % 60;
		return  String.format("%02d:%02d", hours, minutes);
	}
	
	
}
