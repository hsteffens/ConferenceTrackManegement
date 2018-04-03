package com.neogrid.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.neogrid.model.Lecture;

public class LectureControllerTest {

	@Test
	public void readLecturesTest001() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		assertNotNull(lectures);
		assertEquals(19, lectures.size());
	}
	
	@Test
	public void readLecturesTest002() {
		List<Lecture> lectures = LectureController.readLectureByLine();
		assertNotNull(lectures);
		assertEquals(60, lectures.get(0).getTime());
		assertEquals(60, lectures.get(1).getTime());
		assertEquals(60, lectures.get(2).getTime());
		assertEquals(60, lectures.get(3).getTime());
		assertEquals(60, lectures.get(4).getTime());
		
		assertEquals(45, lectures.get(5).getTime());
		assertEquals(45, lectures.get(6).getTime());
		assertEquals(45, lectures.get(8).getTime());
		assertEquals(45, lectures.get(9).getTime());
		assertEquals(45, lectures.get(10).getTime());
		
		assertEquals(30, lectures.get(11).getTime());
		assertEquals(30, lectures.get(12).getTime());
		assertEquals(30, lectures.get(13).getTime());
		assertEquals(30, lectures.get(14).getTime());
		assertEquals(30, lectures.get(15).getTime());
		assertEquals(30, lectures.get(16).getTime());
		assertEquals(30, lectures.get(17).getTime());
		
		assertEquals(5, lectures.get(18).getTime());
	}
}
