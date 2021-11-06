{
    private Report report;
    private ReportLogic reportLogic;
    private MenuLogic menuLogic; 
    private ArrayList<Order> orderList; 
    private FreeTable table; 
    private StaffLogic staffLogic; 
    
        Scanner sc = new Scanner(System.in);

        public OrderLogic(Report report, ReportLogic reportLogic, MenuLogic menuLogic, FreeTable table,StaffLogic staffLogic){
                //txt implementation
        		this.report = report; 
        		this.reportLogic = reportLogic; 
        		this.menuLogic = menuLogic;
        		ArrayList<Order> orderList = new ArrayList<Order>(); 
        		this.orderList = orderList; 
        		this.table = table; 
        		this.staffLogic = staffLogic; 
                reportLogic.loadReport();
                System.out.println("OrderLogic start-up complete.");
        }

        public int newOrder(int tableNumber,String memberStatus){
                boolean isMember = false;
                if (memberStatus == "y" || memberStatus == "Y") isMember = true;
 
                Staff staff = staffLogic.handler();

                Order order = new Order(tableNumber, isMember, staff);
                orderList.add(order); //addition of order to order list (collection)
                return (orderList.size()-1);
                
        }

        public void addItemToOrder(int ordernumber, MenuLogic menuLogic,int categoryChoice,int orderIDChoice){
        		Order order = orderList.get(ordernumber);

                if(categoryChoice == 1) order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice, categoryChoice));
                if(categoryChoice == 2) order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice, categoryChoice));
                if(categoryChoice == 3) order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice,categoryChoice));
                if(categoryChoice == 4) order.getPromoItems().add(menuLogic.addPromoToOrder(orderIDChoice));//adding promo set returned
        }

        public void removeItemFromOrder(int ordernumber) {
        	Order order = orderList.get(ordernumber); 
            //need to add remove for promo item
            System.out.println("CHOOSE AN ITEM TO REMOVE:");
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                System.out.println(order.getOrderItems().get(i).getID() + "\t" + order.getOrderItems().get(i).getName());
            }
            int removeChoice = sc.nextInt();
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                if (removeChoice == order.getOrderItems().get(i).getID())
                    order.removeOrderItems(order.getOrderItems(), order.getOrderItems().get(i));
            }
        }

        public Order viewOrder(int ordernumber){
        				return orderList.get(ordernumber);
                        /*System.out.println("TABLE NO.: " + order.getTableNumber());
                        System.out.println(order.getTimeStamp());
                        System.out.println("ORDER: ");
                        float subTotal = 0;
                        for (int i = 0; i < order.getOrderItems().size(); i++) {
                                System.out.println(order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
                                subTotal += order.getOrderItems().get(i).getPrice();
                        }*/
        }

        public void printOrderInvoice(Order order){
                        System.out.println("\t\tCZ2002 RESTAURANT");
                        System.out.println("Server: " + order.getStaff() + "\tTable: " + order.getTableNumber());
                        System.out.println("Date: " + order.getTimeStamp());
                        System.out.println("________________________");
                        for (int i=0; i<order.getOrderItems().size(); i++){
                                System.out.println(order.getOrderItems().get(i).getID() + " " + order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
                        }
                        System.out.println("________________________");
                        float subTotal = 0;
                        for (int i=0; i<order.getOrderItems().size(); i++){
                                subTotal += order.getOrderItems().get(i).getPrice();
                        }
                        System.out.println("\t\t\tSUB-TOTAL: " + subTotal);
                        System.out.println("\t\t\tGST: " + subTotal*0.07);
                        System.out.println("\n\t\t\tTOTAL: " + subTotal*1.07);
                        System.out.println("Thank you for dining with us!");
                        
                        table.freeTable(order.getTableNumber(), order.getTimeStamp().getHours());
                        report.getOrders().add(order); 
            
                }
        


}
