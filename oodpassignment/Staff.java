package oodpassignment;

import oodpassignment.Job;

/**
 * This is an entity class used to represent staff working in the restuarant. It
 * stores the staff attributes like staff members' name, gender, ID and job
 * title.
 * 
 * @author Mei Qi
 * @since 08/11/2021
 * @version 1.0
 * 
 */

public class Staff {

	/**
	 * Name of staff member
	 */
	private String name;
	/**
	 * Staff member's gender
	 */
	private char gender;
	/**
	 * Staff member's unique ID
	 */
	private int ID;
	/**
	 * Staff member's job title
	 */
	Job job;

	/**
	 * Default staff constructor
	 */

	public Staff() {
	}

	/**
	 * Staff constructor which takes in the name, gender, ID and job title of the
	 * staff
	 * 
	 * @param name   staff's name
	 * @param gender staff's gender
	 * @param ID     staff's unique ID
	 * @param job    staff's job title
	 */
	public Staff(String name, char gender, int ID, Job job) {
		this.name = name;
		this.gender = gender;
		this.ID = ID;
		this.job = job;
	}

	/**
	 * getter method for name of staff
	 * 
	 * @return returns the staff's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter method for gender of staff
	 * 
	 * @return returns the staff's gender
	 */
	public char getGender() {
		return this.gender;
	}

	/**
	 * getter method for ID of staff
	 * 
	 * @return returns the staff's ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * getter method for job of staff
	 * 
	 * @return returns the job title of the staff which is an enumeration value
	 */
	public Job getJob() {
		return this.job;
	}

	/**
	 * setter method for name of staff
	 * 
	 * @param name staff's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * setter method for gender of staff
	 * 
	 * @param gender staff's gender
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * setter method for ID of staff
	 * 
	 * @param ID staff's ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * setter method for job of staff
	 * 
	 * @param job staff's job title
	 */
	public void setJob(Job job) {
		this.job = job;
	}
}