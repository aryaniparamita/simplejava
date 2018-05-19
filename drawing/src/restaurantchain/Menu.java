package restaurantchain;

/**
 * Created by Paramita on 5/5/2018.
 */
public class Menu {
    private String[] drinkChoices = new String[] {"Cocktail","Beer","Coffee","Juice"};
    private String[] foodChoices = new String[]{"Sushi","Fried Rice","Sirloin Steak","Wagyu Steak"};

    public String[] getDrinkChoices(){
        return drinkChoices;
    }
    public String[] getFoodChoices(){
        return foodChoices;
    }
    public int getDrinkPrice (String name){
        if (name.equals("Cocktail")){
            return 20;
        }
        else if (name.equals("Soft drinks")){
            return 10;
        }
        else if (name.equals("Coffee")){
            return 8;
        }
        else if (name.equals("Juice")){
            return 15;
        }
        else{
            return 0;
        }
    }

    public int getFoodPrice (String name){
        if (name.equals("Sushi")){
            return 20;
        }
        else if (name.equals("Fried Rice")){
            return 10;
        }
        else if (name.equals("Sirloin Steak")){
            return 8;
        }
        else if (name.equals("Wagyu Steak")){
            return 15;
        }
        else{
            return 0;
        }
    }

}
