public class TableBoundary {
    private TableLogic tableLogic = new TableLogic();

    public void addTable(int tableNumber,int sizeOfTable) {
        tableLogic.addTable(tableNumber,sizeOfTable);

    }

    public int giveTable(int customerPax) {
        return tableLogic.giveTable(customerPax);
    }

    public Boolean checkTableAvailability(int customerPax) {
        return tableLogic.checkTableAvailability(customerPax);
    }

    public Boolean freeTable(int tableNumber) {
        return tableLogic.freeTable(tableNumber);
    }

}
