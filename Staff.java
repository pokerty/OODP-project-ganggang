package oodpassignment;
/**
 * This is an entity class used to represent staff working in the restuarant. It
 * stores the staff data.
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

	public String getName() {
		return this.name;
	}

	public char getGender() {
		return this.gender;
	}

	public int getID() {
		return this.ID;
	}

	public Job getJob() {
		return this.job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}