/**
   * Filename: House.java
* Description: Creates a House utilizing the parent class Building. Contains a name, address, number of floors,
as well as booleans for whether or not the building has a dining room or an elevator.
     * Author: Rachel Kunkel
      *  Date: 10 March 2024  
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

  /** Checks if a name is in the list of residents. 
  // @param String name is the name of the resident being removed.
  // @return boolean is whether or not the person is a resident.
  */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  public static void main(String[] args) {
    House Lamont = new House("Lamont House", "17 Prospect St.", 5, true, true);
    System.out.println(Lamont);
    System.out.println("Lamont has a dining room: " + Lamont.hasDiningRoom());
    System.out.println("Lamont has an elevator: " + Lamont.hasElevator());
    System.out.println("Moving residents in...");
    Lamont.moveIn("Rachel");
    Lamont.moveIn("Leah");
    System.out.println("Lamont has: " + Lamont.nResidents() + " resident(s).");
    System.out.println("Rachel lives in Lamont: " + Lamont.isResident("Rachel"));
    System.out.println("Moving a resident out...");
    Lamont.moveOut("Leah");
    System.out.println("Lamont has: " + Lamont.nResidents() + " resident(s).");
    System.out.println("Leah lives in Lamont: " + Lamont.isResident("Leah"));
  }

}