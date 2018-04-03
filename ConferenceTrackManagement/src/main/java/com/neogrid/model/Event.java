package com.neogrid.model;

import java.util.List;

/**
 * Entity that represents a set of Lectures'.
 * 
 * @author H�linton Steffens
 *
 */
public class Event {

	private List<Lecture> sessions;
	
	public List<Lecture> getSessions() {
		return sessions;
	}
	public void setSessions(List<Lecture> sessions) {
		this.sessions = sessions;
	}
	
}
