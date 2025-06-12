package com.day3;


class FoodOrder2{
String CustomerName;
String FoodItem;
int quantity;
double price;

public FoodOrder2(String customerName, String foodItem, int quantity, double price) {
	this.CustomerName = customerName;
	this.FoodItem = foodItem;
	this.quantity = quantity;
	this.price = price;
}
void showOrderDetails() {
	
	double total=quantity*price;
	System.out.println("Customer Name:"+CustomerName);
	System.out.println("FoodItem:"+FoodItem);
	System.out.println("quantity:"+quantity);
	System.out.println("Price:"+price);
	System.out.println("total amount:"+total);



}

}
public class FoodOrder {
	public static void main(String[]args) {
		FoodOrder2 order1=new FoodOrder2("ramya","biryani",1,200.00);
	    FoodOrder2 order2=new FoodOrder2("raj","pizza",2,210.00);
        order1.showOrderDetails();
		order2.showOrderDetails(); 
    
	 
				  
	}
}
