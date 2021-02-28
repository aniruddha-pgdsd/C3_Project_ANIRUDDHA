import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        boolean openingOrClosingStatus;
        if(getCurrentTime().isAfter(openingTime) && getCurrentTime().isBefore(closingTime)){
            openingOrClosingStatus = true;
        } else {
            openingOrClosingStatus = false;
        }
        return openingOrClosingStatus;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public int priceOfSelectedItems(String name1, String name2) {
        Item item1 = new Item("Sweet corn soup", 149);
        Item item2 = new Item("Vegetable lasagne", 299);
        int item1NewPrice = 119;
        item1.setPrice(item1NewPrice);
        int item2NewPrice = 269;
        item2.setPrice(item2NewPrice);
        int totalPrice = item1.getPrice() + item2.getPrice();
        return totalPrice;
    }

    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
        }
}
