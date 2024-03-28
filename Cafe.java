/**
   * Filename: Cafe.java
* Description: Creates a Cafe utilizing the parent class Building. Contains a name, address, number of floors,
as well as the number of coffee ounces, sugar packets, cups, and creams. Reduces this amount when coffee is 
made and restocks/resets numbers if it is too low to make coffee.
     * Author: Rachel Kunkel
      *  Date: 10 March 2024  
*/
public class Cafe extends Building {
    /**
      Extension of Building class to create a Cafe
    **/
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    public boolean hasElevator;

    /**
      "Builds" cafe
      @param String name is a String of the name of the cafe
      @param String address is String of the address of the cafe
      @param int floor is an int with the number of floors in the cafe
      @param int nCoffeeOunces is an int with the number of coffee ounces in the cafe
      @param int nSugarPackets is an int with the number of sugar packets in the cafe
      @param int nCups is an int with the number of cups in the cafe
      @param int nCreams is an int with the number of 'splashes' of coffee in the cafe
      @param boolean hasElevator indicates whether or not the cafe has an elevator 
    **/
    public Cafe(String name, String address, int floors, int nCoffeeOunces, int nSugarPackets, int nCups, int nCreams, boolean hasElevator) {
        super(name, address, floors); 
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCups = nCups;
        this.nCreams = nCreams;
        System.out.println("You have built a cafe: ☕");
    }

    /**
      Adds stock
      @param int nCoffeeOunces is an int with the number of coffee ounces in the cafe
      @param int nSugarPackets is an int with the number of sugar packets in the cafe
      @param int nCups is an int with the number of cups in the cafe
      @param int nCreams is an int with the number of 'splashes' of coffee in the cafe
    **/
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
      "Makes" coffee by subtracting the amount requested from stock. If there is not enough, it calls on
      the restock method.
      @param int nCoffeeOunces is an int with the number of coffee ounces in the cafe
      @param int nSugarPackets is an int with the number of sugar packets in the cafe
      @param int nCups is an int with the number of cups in the cafe
      @param int nCreams is an int with the number of 'splashes' of coffee in the cafe
    **/
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size <= nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams) {
            System.out.println("Selling coffee...");
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
        }
        else {
            System.out.println("Not enough in stock... \nRestocking...");
            restock(20,50,25,15);
        }
    }

    public void showOptions() {
      super.showOptions();
      System.out.println(" + restock(n)\n + sellCoffee(n)");
  }

  public boolean hasElevator() {
    return hasElevator;
}

  public void goToFloor(int floorNum) {
    hasElevator = hasElevator();
    if (hasElevator = true) {
      super.goToFloor(floorNum);
      System.out.println("Now on floor: " + floorNum);
    } else {
      throw new RuntimeException(this.name + " does not have an elevator! You must take the stairs."); }
  }
    
    public static void main(String[] args) {
        Cafe Woodstar = new Cafe("Woodstar Cafe", "60 Masonic St", 1, 20, 50, 25, 15, false);
        System.out.println(Woodstar);
        Woodstar.showOptions();
        // Printing the stock
        System.out.println("-----------");
        System.out.println("Wood star has " + Woodstar.nCoffeeOunces + " ounces of coffee, " + Woodstar.nSugarPackets + " packets of sugar, " + Woodstar.nCreams + " 'splashes' of cream, " + "and " + Woodstar.nCups + " cups of coffee.");
        System.out.println("-----------");
        // Sell coffee
        Woodstar.sellCoffee(10, 5, 13);
        System.out.println("-----------");
        System.out.println("Wood star has " + Woodstar.nCoffeeOunces + " ounces of coffee, " + Woodstar.nSugarPackets + " packets of sugar, " + Woodstar.nCreams + " 'splashes' of cream, " + "and " + Woodstar.nCups + " cups of coffee.");
        System.out.println("Wood star has " + Woodstar.nCups + " cups of coffee.");
        System.out.println("-----------");
        // Trying to sell too much coffee -> Restock
        Woodstar.sellCoffee(10, 5, 13);
        System.out.println("-----------");
        System.out.println("Wood star has " + Woodstar.nCoffeeOunces + " ounces of coffee, " + Woodstar.nSugarPackets + " packets of sugar, " + Woodstar.nCreams + " 'splashes' of cream, " + "and " + Woodstar.nCups + " cups of coffee.");
        System.out.println("-----------");
        // Entering, exiting, elevator...
        Woodstar.enter();
        Woodstar.goToFloor(3);
        Woodstar.exit();
    }
    
}
