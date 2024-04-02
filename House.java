/**
   * Filename: House.java
* Description: Creates a House utilizing the parent class Building. Contains a name, address, number of floors,
as well as booleans for whether or not the building has a dining room or an elevator.
     * Author: Rachel Kunkel
      *  Date: 31 March 2024  
*/

import java.util.ArrayList;

public class House extends Building {

  ArrayList<String> residents;
  boolean hasElevator; 
  boolean hasDiningRoom;

  /**
      "Builds" a house
      @param String name is a String of the name of the house
      @param String address is String of the address of the house
      @param int number of floors the house has
      @param boolean is whether or not the house has a dining room
      @param boolean is whether or not the house has an elevator
    **/
  public House(String name, String address, int floors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, floors); 
    this.hasElevator = hasElevator;
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  } 

  /**
      "Builds" a house with a default address
      @param String name is a String of the name of the house
      @param int number of floors the house has
      @param boolean is whether or not the house has a dining room
      @param boolean is whether or not the house has an elevator
    **/
  public House(String name, int floors, boolean hasDiningRoom, boolean hasElevator) {
    House(name, "Northampton MA, 01063", floors, hasDiningRoom, hasElevator);
  }

  /** Checks if the house has a dining room
  // @return boolean that confirms whether or not the house has a dining room
  */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /** Checks if the house has an elevator
  // @return boolean that confirms whether or not the house has an elevator
  */
  public boolean hasElevator() {
    return hasElevator;
  }
  
  /** Checks the number of residents in the house
  // @return int with the size of the residents list 
  */
  public int nResidents() {
    return residents.size();
  }

  /** Adds a resident to the house. Throws error if they already live there. 
  // @param String name is the name of the resident being added.
  */
  public void moveIn(String name) {
    if (!residents.contains(name)) {
      residents.add(name);
      System.out.println(name + " has moved in!");
    } else {
      throw new RuntimeException(name + " already lives here!");
    }
  }

  /** If no name is specified, moves a ghost into the house. Throws error if a ghost already lives there. 
   */
  public void moveIn() {
    if (!residents.contains("House Ghost 👻")) {
      residents.add("House Ghost 👻");
    }
    else {
      throw new RuntimeException("A House Ghost 👻 is already haunting here!");
    }
  }

  /** Moves a resident out of the house. Throws an error if they don't live there.
  // @param String name is the name of the resident being removed.
  */
  public String moveOut(String name){
    if (residents.contains(name)) {
      residents.remove(name);
      return name + " has move out.";
    } else {
      throw new RuntimeException(name + " doesn't live in this house.");
    }
  }
  /**
   * If no specific names are given, moves out ALL residents (including ghosts!)
   */
  public void moveOut() {
    residents.clear();
      System.out.println("All residents (including ghosts!) moved out!"); 
  } 

  /** Checks if a name is in the list of residents. 
  // @param String name is the name of the resident being removed.
  // @return boolean is whether or not the person is a resident.
  */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * Displays all available actions for the given building 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + House(s,s,n,b,b)\n + House (s,n,b,b)\n + hasDiningRoom()\n + nResidents()\n + moveIn(s)\n + moveIn(s)\n + moveOut(s)\n + moveOut()\n + isResident(s)\n + hasElevator()\n + goToFloor(n)");
}

/**
 * "Teleports" the user to the specified floor if the building has an elevator. Otherwise throws error
   @param int floorNum floor that the user wishses to go to
 */
  public void goToFloor(int floorNum) {
    hasElevator = hasElevator();
    if (hasElevator = true) {
      super.goToFloor(floorNum);
      System.out.println("Now on floor: " + floorNum);
    } else {
      throw new RuntimeException(this.name + " does not have an elevator! You must take the stairs."); }
  }
  public static void main(String[] args) {
    // Create a house w/out address specified
    House Chase = new House("Chase House", 3, true, true);
    System.out.println(Chase);
    System.out.println("\n");

    // Create a house with all parameters
    House Lamont = new House("Lamont House", "17 Prospect St.", 5, true, true);
    System.out.println(Lamont);
    Lamont.showOptions();

    // Showing info about house with all parameters
    System.out.println("\n" + Lamont.name + " has a dining room: "  + Lamont.hasDiningRoom());
    System.out.println(Lamont.name + " has an elevator: " + Lamont.hasElevator());

    // Moving residents in
    System.out.println("\nMoving residents in...");
    Lamont.moveIn("Rachel");
    Lamont.moveIn("Leah");
    Lamont.moveIn();
    System.out.println(Lamont.name + " has: " + Lamont.nResidents() + " resident(s).");
    System.out.println("Rachel lives in " + Lamont.name + ": " + Lamont.isResident("Rachel"));

    // Moving a resident out
    System.out.println("\nMoving a resident out...");
    Lamont.moveOut("Leah");
    System.out.println(Lamont.name + " has: " + Lamont.nResidents() + " resident(s).");
    System.out.println("Leah lives in " + Lamont.name + ": " + Lamont.isResident("Leah"));
   
    // Entering, exiting, elevator...
    System.out.println("\n");
    Lamont.enter();
    Lamont.goToFloor(2);
    Lamont.goUp();
    Lamont.goDown();
    Lamont.goToFloor(1);
    Lamont.exit();
    
    System.out.println("\n");
    Lamont.moveOut();
    System.out.println(Lamont.name + " has: " + Lamont.nResidents() + " resident(s).");
    
  }

}