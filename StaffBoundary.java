import java.util.Scanner;

public class StaffBoundary {

	Scanner sc = new Scanner(System.in);

	private StaffLogic staffLogic = new StaffLogic();

	public StaffBoundary(StaffLogic staffLogic) {
		this.staffLogic = staffLogic;
	}

	public void addStaff() {
		System.out.println("Input staff name: ");
		String name = sc.next();
		System.out.println("Input staff gender: F/M ");
		char gender = sc.next().charAt(0);
		System.out.println("Input staff ID: ");
		int ID = sc.nextInt();
		System.out.println("Input staff job: (0) for Manager, (1) for Waiter, (2) for Chef");
		int job = sc.nextInt();
		if (job == 0) {
			staffLogic.addStaff(name, gender, ID, Job.Manager);
		} else if (job == 1) {
			staffLogic.addStaff(name, gender, ID, Job.Waiter);
		} else {
			staffLogic.addStaff(name, gender, ID, Job.Chef);
		}
	}

	public void displayStaff() {
		staffLogic.displayStaff();
	}

	public void handler() {
		staffLogic.handler();
	}

}