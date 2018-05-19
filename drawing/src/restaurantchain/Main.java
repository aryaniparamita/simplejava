/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantchain;

/**
 *
 * @author goswa9685
 */
public class Main {

    public static void main(String[] args) {

            Restaurant r = new Restaurant("Colony", "Orchard",10);
            Restaurant r2 = new Restaurant("Colony","Marina Avenue",3);
            Customer [] customerList = new Customer[1000];
            customerList[0]= new Customer(100012,"Terry",3);
            customerList[1]= new Customer(100013,"John",5);
            customerList[2]= new Customer(100014,"Bill",2);
            customerList[3]= new Customer(100015,"Marry",2);
            customerList[4]= new Customer(200016,"Susan",2);
            customerList[5]= new Customer(123019,"Peter",2);
            r.addCustomer(customerList[0]);
            r.addCustomer(customerList[2]);
            r.addCustomer(customerList[3]);
            r.addCustomer(customerList[4]);
            r2.addCustomer(customerList[1]);
            r2.addCustomer(customerList[5]);
            System.out.print(r.getRestaurant_name());
            customerList[0].orderDrink("Beer");
            customerList[0].printListOfOrder();
//            customerList[0].orderFood("sushi");
            customerList[0].bill();

    }
}
