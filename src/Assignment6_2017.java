/**
 *
 * Student name: Ciaran Winnan		
 * Student number: 2940836
 */
 
import java.util.*;
public class Assignment6_2017{
	public static void main(String args[]){
	  //Q1 Testing ===================================
	 System.out.println("///////////////Question1//////////");
	 Car car1 = new Car("John","162G202","Kia",2000,240480.98);
	 Car car2 = new Car("Beth","12D402","BMW",8500,170480.98);
	 //Test for owner validation
	 String carOwner = car1.getOwner();
	 if(carOwner.equals("John")){
	 	System.out.println("Owner: True");
	 }
	 //Test for Reg validation
	 String carReg = car1.getReg();
	 if(carReg.equals("162G202")){
	 	System.out.println("Registration: True");
	 } 
	 //Test for make validation
	 String carMake = car1.getMake();
	 if(carMake.equals("Kia")){
	 	System.out.println("Make: True");
	 } 
	 //Test for Kilo validation
	 int carKilo = car1.getKilometres();
	 if(carKilo == 2000){
	 	System.out.println("Kilometres: True");
	 }
	 //Test for price validation
	 double carPrice = car1.getPrice();
	 if(carPrice == 240480.98){
	 	System.out.println("Price: True");
	 }
	  //==============================================
	  //Q2 Testing ===================================
	  System.out.println("\n///////////////Question1//////////");
	  MyGarage garage1 = new MyGarage(10);
	  //addCar method test
	  boolean carChecker1 = garage1.add(car1);
	  if(carChecker1 == true){
	  	System.out.println("Car was successfully added!");
	  }
	  else{
	  	System.out.println("Car already exists");
	  }
	  boolean carChecker2 = garage1.add(car2);
	  if(carChecker2 == true){
	  	System.out.println("Car was successfully added!");
	  }
	  else{
	  	System.out.println("Car already exists");
	  }
	  //getCar method Test
	  Car getCarChecker = garage1.getCar("162G202");
	  if(getCarChecker.equals(null)){
	  	System.out.println("\nThis car is not in the garage");
	  }
	  else{
	  	System.out.println("\nThis car is in the garage:" + getCarChecker.toString());
	  }
	  //getMake method Test
	  Car[] makeChecker = garage1.getMake("Kia");
	  if(makeChecker == null){
	  	System.out.println("There are no cars of that make");
	  }
	  else{
	  	System.out.println("\nCars that conform to search request:");
	  	for(int i = 0; i < makeChecker.length; i++){
	  		Car temp = makeChecker[i];
	  		System.out.print(temp.toString());
	  	}
	  }
	  //getTotal method test
	  double garageTotalValue = garage1.totalValue();
	  System.out.println("\nGarage Total price: " + garageTotalValue);
	  //changeOwner Method test
	  boolean changedOwner = garage1.changeOwner("162G202","Bob");
	  if(changedOwner == true){
	  	System.out.println("\nOwner change successful");
	  }
	  else{
	  	System.out.println("\nRegistration was not found");
	  }
	  //changePrice Method test
	  boolean changedPrice = garage1.changePrice("162G202",109982.77);
	  if(changedPrice == true){
	  	System.out.println("\nPrice change successful");
	  }
	  else{
	  	System.out.println("\nRegistration was not found");
	  }
	  //Percentage change test
	  boolean percentChange = garage1.reducePricesBy(20.5);
	  if(percentChange == true){
	  	System.out.println("\nPercentage price reductions complete");
	  }
	  else{
	  	System.out.println("\nPercentage price reductions was not completed");
	  }
	  //=============================================
	}
}
//Q1  =============================================
//edit Car class here =============================
final class Car{
	private final String owner;
	private final String reg;
	private final String make;
	private final int kilometres;
	private final double price;
	
	public Car(String ow, String r, String m, int k, double p){
	 owner = ow; reg = r; make = m; kilometres = k; price = p; 
	}
	
	public String getOwner(){
		return new String(owner);
	}
	public String getReg(){
		return new String(reg);
	}
	public String getMake(){
		return new String(make);
	}
	public int getKilometres(){
		return kilometres;
	}
	public double getPrice(){
		return price;	
	}
	public void setPrice(double p){
		double price2 = p;
	}
	public void setOwner(String ow){
		String owner2 = ow;
	}
	public void setKil(int k){
		int kilometres2 = k;
	}
	public void setMake(String m){
		String make2 = m;
	}
	public String toString(){
		return "\nName:" + owner + "\nReg: " + reg + "\nMake: " + make + "\nKilometres: " + kilometres + "\nPrice: " + price + "\n";
	}
}

interface Garage{
  public boolean add(Car c);
  public Car getCar(String reg);
  public Car[] getMake(String make);
  public double totalValue();
  public boolean changeOwner(String reg, String ow);
  public boolean changePrice(String reg, double p);
  public boolean reducePricesBy(double per);
}

class MyGarage implements Garage{
	private Car data[];
	private int size;
	
	public MyGarage(int n){
		data = new Car[n];
		size = 0;
	}
	
	public boolean add(Car c){
		boolean isFound = false;
		if(size == 0){
			data[size] = c;
			size++;
			return true;
		}
		for(int i = 0; i < size; i++){
			Car dataPointer = data[i];
			if(dataPointer.getReg().equals(c.getReg())){
				isFound = true;
				return false;
			}
		} 
		if(isFound == false){
			data[size] = c;
			size++;
		}
		return true;
	}
  	public Car getCar(String reg){
  		for(int i = 0; i < size; i++){
  			if(data[i].getReg().equals(reg)){
  				return data[i];
  			}
  		}
  		return null;
  	}
 	public Car[] getMake(String make){
 		int makeCount = 0; 
 		for(int i = 0; i < size; i++){
 			if(data[i].getMake().equals(make)){
 				makeCount++;
 			}
 		}
 		if(makeCount == 0){
 			return null;
 		}
 		Car makeFoundArray [] = new Car[makeCount];
 		int foundPointer = 0;
 		for(int i = 0; i < makeCount; i++){
 			if(data[i].getMake().equals(make)){
 				makeFoundArray[foundPointer] = data[i];
 				foundPointer++;
 			}
 		}
 		return makeFoundArray;
 	}
  	public double totalValue(){
  		double totalPrice = 0.0;
  		for(int i = 0; i < size; i++){
  			totalPrice = totalPrice + data[i].getPrice();
  		}
  		return totalPrice;
  	}
  	public boolean changeOwner(String reg, String ow){
  		for(int i = 0; i < size; i++){
  			if(data[i].getReg().equals(reg)){
  				data[i].setOwner(ow);
  				return true;
  			}
  		}
  		return false;
  	}
  	public boolean changePrice(String reg, double p){
  		for(int i = 0; i < size; i++){
  			if(data[i].getReg().equals(reg)){
  				data[i].setPrice(p);
  				return true;
  			}
  		}
  		return false;
  	}
  	public boolean reducePricesBy(double per){
  		for(int i = 0; i < size; i++){
  			double temp = ((data[i].getPrice())*(per/100));
  			double newPrice = data[i].getPrice() - temp;
 			data[i].setPrice(newPrice);
  		}
  		return true;
  	}
  	
  		
}
// =====================================================