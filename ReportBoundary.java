package oodpassignment;

public class ReportBoundary {
    public void reportTotal(ReportLogic reportLogic){

    }
    public void reportAlaCarte(ReportLogic reportLogic){
        Report report = reportLogic.showAlaCarte();
        System.out.println("Ala Carte Items Sold: ");
        for(int i = 0; i<report.getOrders().size(); i++){
            for(int j=0;j<report.getOrders().get(i).getOrderItems().size();j++) {
                System.out.println(report.getOrders().get(i).getOrderItems().get(j).getName());
            }
        }

    }
    public void reportSetPromo(ReportLogic reportLogic){
        Report report = reportLogic.showSetPromo();
        System.out.println("Promotional Set Items sold: ");
        for(int i = 0; i<report.getOrders().size(); i++){
            for(int j=0;j<report.getOrders().get(i).getPromoItems().size();j++) {
                System.out.println(report.getOrders().get(i).getPromoItems().get(j).getName());
            }
        }

    }

}
