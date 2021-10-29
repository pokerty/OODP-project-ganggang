import java.util.*;
import MenuItems.courseType; 

public class PromotionalSet {
    private String setName;
    private String setDescription;
    private float setPrice;
    private ArrayList<MenuItems> setItems;

    public PromotionalSet(String setName, String setDescription, float setPrice){
        this.setName = setName;
        this.setDescription = setDescription;
        this.setPrice = setPrice;
        setItems = new ArrayList<MenuItems>();
    }
    public String GetName(){
        return this.setName;
    }
    public void SetName(String setName){
        this.setName = setName;
    }

    public String GetDescription(){
        return this.setDescription;
    }
    public void SetDescription(String setDescription){
        this.setDescription = setDescription;
    }

    public float GetPrice(){
        return this.setPrice;
    }
    public void SetPrice(float setPrice){
        this.setPrice = setPrice;
    }

    public void addItemsToSet(MenuItems item){
        setItems.add(item);
    }

    public void removeItemsFromSet(String name){
        for (int i=0; i<setItems.size(); i++){
            if (setItems.get(i).getName()==name){
                setItems.remove(i);
            }
        }
    }
    
}
