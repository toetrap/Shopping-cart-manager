package domain;

import java.util.ArrayList;



public class ShoppingCart {
    //following private fields are declared
    private String customerName;
    private String currentDate;
    private ArrayList <ItemToPurchase>cartItems = new ArrayList<>();
    //define 2 constructors
    public ShoppingCart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2022";
    }

    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getCurrentDate(){
        return currentDate;
    }

    public void addItem(ItemToPurchase anItem) {
        //Adds an item to cartItems arrayList
        this.cartItems.add(anItem);
    }
    public void removeItem(String anItem) {
        //Removes item from cartItems arrayList

        int flag = 0;

        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getItemName().equals(anItem)) {
                cartItems.remove(i);
                flag=1;
            }
        }
        if (flag == 0) {
            System.out.println("Item not found in cart nothing removed");
        }
    }
    public void modifyItem(ItemToPurchase anItem){
        //Modifies an item's quantity if no items then displays a message
        boolean itemFound = false;
        int i = 0;
        while (!itemFound && i < cartItems.size()) {
            if (cartItems.get(i).getItemName().equalsIgnoreCase(anItem.getItemName())) {
                cartItems.get(i).setItemQuantity(anItem.getItemQuantity());
                itemFound = true;
            }
            i++;
        }
        if (itemFound){
            System.out.println("Item not found in cart. Nothing modified.");
        }

    }
    public int getNumItemsInCart(){
        //determines the items in cart
        int numItems = 0;

        if (cartItems == null) {
            return numItems;
        }
        for (int i = 0; i< cartItems.size(); i++) {
            numItems = numItems+ cartItems.get(i).getItemQuantity();
        }
        return numItems;
    }
    public double getCostCart(){
        //determines total cost of what is in the cart
        double totalCost = 0;
        double cost = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            cost = cartItems.get(i).getItemQuantity() * cartItems.get(i).getItemPrice();
            totalCost += cost;
        }
        return totalCost;
    }
    public void printTotal(){
        //Outputs total of objects in cart.
        //If cart is empty, outputs message
        double totalCost = getCostCart();

        if (totalCost == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
        }
        else {
            System.out.println(customerName + "'s Shopping Cart - " + currentDate);
            System.out.println();
            System.out.println("Item Descriptions");
            System.out.println();
            for (int i = 0; i < cartItems.size(); i++) {
                if (i ==0) {
                    System.out.println();
                }
                System.out.println(cartItems.get(i).getItemName() + " " + cartItems.get(i).getItemQuantity()
                        + " @ $" + cartItems.get(i).getItemPrice() + " = $" + (cartItems.get(i).getItemPrice()
                * cartItems.get(i).getItemQuantity()));
            }
            System.out.println();
            System.out.println(totalCost);

        }

    }
    public void printDescriptions(){
        //Outputs each item's description
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart());
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println(cartItems.get(i).getItemName() + ": " + cartItems.get(i).getItemDescription());
        }

    }
}
