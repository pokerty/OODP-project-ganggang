import java.util.Scanner;

public class TableBoundary{
    private TableLogic tableLogic = new TableLogic();
    Scanner scanner = new Scanner(System.in);
    public void giveTable() {
        System.out.println("Enter the number of customers:");
        int customerPax =scanner.nextInt();
        System.out.println("");

        System.out.printf("Table %d allocated",tableLogic.giveTable(customerPax));
    }

    public void checkTableAvailability() {
        System.out.println("Enter the number of customers:");
        int customerPax =scanner.nextInt();
        System.out.println("");
        if(tableLogic.checkTableAvailability(customerPax)) {
            System.out.printf("There are tables available");
            return; }
        System.out.printf("There are no tables available");
    }

    public void freeTable() {
        System.out.println("Enter the table number to free:");
        int tableNumber =scanner.nextInt();
        System.out.println("");
        tableLogic.freeTable(tableNumber);
        System.out.println("Table is freed\n");
    }

}
