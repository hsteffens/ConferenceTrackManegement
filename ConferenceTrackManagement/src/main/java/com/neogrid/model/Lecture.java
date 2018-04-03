package com.neogrid.model;

/**
 * Entity that represents a lecture.
 * 
 * @author Hélinton Steffens
 *
 */
public class Lecture implements Comparable<Lecture>{
	
	private String description;
	private String startTime;
	private int time;
	
	public Lecture(int time, String description) {
		this.description = description;
		this.time = time;
	}
	
	public Lecture() {
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTime() {
		return time;
	}
	
	public void setTime(String time) {
		if ("lightning".equals(time)) {
			this.time = 5;
		}else {
			this.time = Integer.parseInt(time.substring(0, time.indexOf("min")));
			
		}
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public int compareTo(Lecture lecture) {
		return this.getTime() < lecture.getTime() ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return this.getStartTime() + " " + this.getDescription();
	}
	
}
