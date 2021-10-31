import java.util.*;
import java.lang.Math;

public class StaffLogic {

	private static ArrayList<Staff> staffs;
	// get from text file
	Scanner input = new Scanner(new File("Staff.txt"));

	public StaffLogic() {

	}

	public static void addStaff(String name, char gender, int ID, Job job) { // static
		staffs = new ArrayList<Staff>();
		Staff staffObject = new Staff(name, gender, ID, job);
		staffs.add(staffObject);
	}

	public static void displayStaff() {
		System.out.println("List of Staff: ");
		for (int i = 0; i < staffs.size(); i++) {
			System.out.println(staffs.get(i).getGender());
			System.out.println(staffs.get(i).getName());
			// id, job
			// System.out.println("");
		}
	}

	public static Staff handler() {
		// display staff who are waiters: choose which staff object
		// only waiter can take orders
		return staffs.get();
	}

}