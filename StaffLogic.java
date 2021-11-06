import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a control class where most of the logic concerning staff is.
 */

public class StaffLogic {

	/**
	 * A list of staff objects are stored in an arrayList. The arrayList will be
	 * populated with staff data read in from stafflist.txt.
	 */
	private ArrayList<Staff> staffs;
	BufferedWriter out;
	BufferedReader in;

	Scanner sc = new Scanner(System.in);

	public StaffLogic() {
		staffs = new ArrayList<Staff>();
		loadStaffs();
		System.out.println("StaffLogic start-up complete.");
	}

	/**
	 * This method creates a new staff object and add it to the staffs arrayList.
	 * The text file will also be updated with this new staff member.
	 */

	public void addStaff(String name, char gender, int ID, Job job) {
		Staff staffObject = new Staff(name, gender, ID, job);
		staffs.add(staffObject);
		// overwrite staffs list
		staffsOverwrite();
	}

	/**
	 * This method prints out the list of staffs and their details.
	 */
	public void displayStaff() {
		System.out.println("List of Staff: ");
		System.out.println();
		for (int i = 0; i < staffs.size(); i++) {
			System.out.println(staffs.get(i).getID());
			System.out.println(staffs.get(i).getName());
			System.out.println(staffs.get(i).getGender());
			System.out.println(staffs.get(i).getJob());
			System.out.println();
		}
	}

	/**
	 * This method prints out all the staff whose job title is waiter and allows the
	 * user to choose a staff member to handle the order. It will then return the
	 * object reference of the staff that is chosen.
	 * 
	 * @return staff object reference
	 */

	public Staff handler() {
		// display staff who are waiters: choose which staff object
		int index = 1;
		System.out.println("Please choose a waiter: ");
		for (int i = 0; i < staffs.size(); i++) {
			if (staffs.get(i).getJob() == Job.Waiter) {
				System.out.println("(" + index + ")" + staffs.get(i).getName());
				index++;
			}
		}
		int choice = sc.nextInt();
		sc.nextLine(); // flush
		// find the respective waiter in the arrayList and return that staff object
		int findWaiter = 0;
		if (choice < index && choice > 0) {
			for (int j = 0; j < staffs.size(); j++) {
				if (staffs.get(j).getJob() == Job.Waiter) {
					findWaiter++;
					if (findWaiter == choice) {
						System.out.println(staffs.get(j).getName() + " is assigned.");
						return staffs.get(j);
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
		} else {
			System.out.println("Please choose a valid waiter.");
			return null;
		}
		System.out.println("Please choose a valid waiter.");
		return null;
	}

	/**
	 * This method is used to update changes of the staff list into the text file.
	 */
	public void staffsOverwrite() { // updating changes into the text file
		try {
			out = new BufferedWriter(new FileWriter("stafflist.txt", false));
			for (int counter = 0; counter < staffs.size(); counter++) {
				out.write(staffs.get(counter).getID() + "\n" + staffs.get(counter).getName() + "\n"
						+ staffs.get(counter).getGender() + "\n" + staffs.get(counter).getJob() + "\n");
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			System.out.println("There was a problem:" + e);
		}

	}

	/**
	 * This method is used to read in the data from the text file, creates a new
	 * object for every staff and then add the staff object into the staffs
	 * arrayList.
	 */

	public void loadStaffs() {
		try {
			File file = new File("stafflist.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			List<String> lines = new ArrayList<String>();
			String line = br.readLine();
			String tempName;
			int tempID;
			char tempGender;
			String tempJob;
			while (line != null) {
				lines.add(line.replace(">", ""));
				line = br.readLine();
			}
			int i = 0;

			while (i < lines.size()) {

				tempID = Integer.parseInt(lines.get(i));
				tempName = lines.get(i + 1);
				tempGender = lines.get(i + 2).charAt(0);
				tempJob = lines.get(i + 3);
				if (tempJob.equals("Manager")) {
					Staff staffObject = new Staff(tempName, tempGender, tempID, Job.Manager);
					staffs.add(staffObject);
				} else if (tempJob.equals("Waiter")) {
					Staff staffObject = new Staff(tempName, tempGender, tempID, Job.Waiter);
					staffs.add(staffObject);
				} else {
					Staff staffObject = new Staff(tempName, tempGender, tempID, Job.Chef);
					staffs.add(staffObject);
				}

				i = i + 5;
			}

			br.close();
		}

		catch (IOException e) {
			System.out.println("There was a problem:" + e);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
