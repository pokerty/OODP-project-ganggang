package oodpassignment;
/**
 * This is an entity class used to represent staff working in the restuarant. It
 * stores the staff data.
 * @author mei qi 
 * @since 08/11/2021
 *  @version 1.0 
 * 
 */

public class Staff {

	private String name;
	private char gender;
	private int ID;
	Job job;

	public Staff() {
	}

	/**
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
	 * @return name of staff 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter method for gender of staff 
	 * @return gender of staff 
	 */
	public char getGender() {
		return this.gender;
	}

	/**
	 * getter method for ID of staff 
	 * @return ID of staff 
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * getter method for job of staff
	 * @return enum of staff's job 
	 */
	public Job getJob() {
		return this.job;
	}

	/**
	 * setter method for name of staff 
	 * @param name sets the name of the staff 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * setter method for gender of staff 
	 * @param gender sets gender of staff 
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * setter method for ID of staff 
	 * @param ID  sets ID of staff 
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * setter method for job of staff 
	 * @param job  job of staff 
	 */
	public void setJob(Job job) {
		this.job = job;
	}
}