package com.neogrid.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.neogrid.model.Lecture;

/**
 * Class with the controllers of a {@link Lecture}.
 * 
 * @author Hélinton Steffens
 *
 */
public final class LectureController {

	private static final String RESOURCES_INPUT = "src/main/resources/input.txt";

	private LectureController() {
		
	}
	
	/**
	 * This method is responsible to get the lectures by the input file and converter them to lecture list.
	 * 
	 * @return a sorted list of lecture.
	 */
	public static List<Lecture> readLectureByLine(){
		List<Lecture> lectures = new ArrayList<>();
		
		try {
			File file = new File(RESOURCES_INPUT);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				lectures.add(convertToLecture(input.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Collections.sort(lectures);
		
		return lectures;
	}
	
	private static Lecture convertToLecture(String lectureStr) {
		Lecture lecture = new Lecture();
		String title = lectureStr.substring(0, lectureStr.lastIndexOf(" "));
		String time = lectureStr.substring(lectureStr.lastIndexOf(" ") + 1, lectureStr.length());
		
		lecture.setDescription(title);
		lecture.setTime(time);
		
		return lecture;
	}
	
}
