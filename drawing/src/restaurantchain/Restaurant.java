/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantchain;

import java.util.ArrayList;

/**
 *
 * @author goswa9685
 */
public class Restaurant {

    String restaurant_name = "";
    String location = "";
    int capacity = 0;
    ArrayList<Customer>customers = new ArrayList<Customer>();



    public Restaurant(String name, String location, int capacity){
        this.restaurant_name = name;
        this.location = location;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }


    public void addCustomer(Customer c){
        //check if capacity has reached, reject the customer
        customers.add(c);
    }
    public void printCustomerList(){
        //print customer list
    }


}