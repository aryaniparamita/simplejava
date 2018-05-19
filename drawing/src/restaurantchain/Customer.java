package restaurantchain;

/**
 * Created by Paramita on 5/5/2018.
 */
public class Customer {
    private int customerID;
    private String name;
    private String[] foodList;
    private String [] drinks = new String[10000];
    private int numberOfDrinks = 0;
    private Restaurant r;
    public Customer (int id, String name, int numberOfPeople){
        setCustomerID(id);
        setName(name);
        setNumberOfPeople(numberOfPeople);

    }
    public void setCustomerID(int id){

    }
    public void setName (String c){

    }
    public void setNumberOfPeople(int numberOfPeople){

    }

    public String orderDrink (String name){
        int set = 0;
        Menu m = new Menu();
        String[] drinkChoices = m.getDrinkChoices();
        for (int i=0; i<drinkChoices.length;i++){
            if (drinkChoices[i].equalsIgnoreCase(name)) {
                drinks[numberOfDrinks]= name;
                numberOfDrinks++;
                return "Successful";
            }
        }
        return "Drinks is not available";
    }
    public int bill(){
        //calculate bill with drinks ordered
        return 0;
    }

    public String orderFood (String foodName){
        //Fill this function
        return "";
    }
    public void printListOfOrder(){
        //print order for food and drink

    }
}
