import java.util.Scanner;

public class TableBoundary(TableLogic tableLogic){
    Scanner scanner = new Scanner(System.in);
    public void giveTable() {
        System.out.println("Enter the number of customers:");
        int customerPax =scanner.nextInt();
        System.out.println("Enter the time of reservation:");
        int hour =scanner.nextInt();
        int tablenumber = tableLogic.giveTable(customerPax,hour);
        if(tablenumber!=-1) {
            System.out.printf("Table %d allocated\n", tableLogic.giveTable(customerPax, hour));
            return;
        }
        System.out.printf("Table not allocated\n");
    }

    public void checkTableAvailability() {
        System.out.println("Enter the number of customers:");
        int customerPax =scanner.nextInt();
        System.out.println("Enter the time of reservation:");
        int hour =scanner.nextInt();
        System.out.println("");
        if(tableLogic.checkTableAvailability(customerPax,hour)) {
            System.out.printf("There are tables available\n");
            return; }
        System.out.printf("There are no tables available\n");
    }

    public void freeTable() {
        System.out.println("Enter the table number to free:");
        int tableNumber =scanner.nextInt();
        System.out.println("Enter the time of reservation:");
        int hour =scanner.nextInt();
        System.out.println("");
        tableLogic.freeTable(tableNumber,hour);
        System.out.println("Table is freed\n");
    }

}
