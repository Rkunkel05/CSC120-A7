/**
   * Filename: Library.java
* Description: Creates a Library utilizing the parent class Building. Contains a name, address, number of floors,
as well as a hashtable containing books and their check-out status. 
     * Author: Rachel Kunkel
      *  Date: 31 March 2024  
*/

import java.util.Hashtable;
import java.util.Enumeration;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  String title;
  Boolean status;
  boolean hasElevator;

    /** Creates library building
     @param String name is a String of the name of the library
     @param String address is String of the address of the library
     @param int floor is the number of floors in the building
  */
    public Library(String name, String address, int floors, boolean hasElevator) {
      super(name, address, floors); 
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /** Adds a book to the collection
     @param String title is the title of the book
     @param boolean is the check-out status of the book
  */
    public void addTitle(String title, Boolean status) {
      collection.put(title, status);
    }

    /** Checks to see if the title is in the collection and removes it. Otherwise throws error
     @param String title is the title of the book
  */
    public String removeTitle(String title) { 
      System.out.println("Removing title from collection...");
      if (collection.containsKey(title)) {
          collection.remove(title);
          return title;
      }  else {
        throw new RuntimeException(title + "does not exist!");
      } }

      /** Takes in multiple titles and checks to see if they are in the collection and removes them. 
       * Otherwise throws error
     @param String title is the title of the first book
     @param String title2 is the title of the second book
     @param String title3 is the title of the third book
    */
      public void removeTitle(String title, String title2, String title3) {
        System.out.println("Removing titles from collection...");
        if (collection.containsKey(title)) {
          collection.remove(title);
        } else {
            throw new RuntimeException("One or more of these books is not in the collection!");
          }
         if(collection.containsKey(title2)) {
          collection.remove(title2);
        } else {
          throw new RuntimeException("One or more of these books is not in the collection!");
        }
        if(collection.containsKey(title3)) {
          collection.remove(title3);
        } else {
          throw new RuntimeException("One or more of these books is not in the collection!");
        }
      }

    /** Checks to see if the title is in the library. Updates to false or otherwise throws error.
     @param String name is the title of the book
  */
    public void checkOut(String title) {
      System.out.println("Checking out book...");
      if (collection.containsKey(title) && collection.get(title)) {
        collection.put(title, false);
      } else {
        throw new RuntimeException(title + " is already checked out!");
      }
    }

    public void checkOut(String title, String title2, String title3) {
      System.out.println("Checking out books...");
      if (collection.containsKey(title) && collection.get(title)) {
        collection.put(title,false);
      } else {
        throw new RuntimeException(title + " is already checked out!");
      }
      if (collection.containsKey(title2) && collection.get(title2)) {
        collection.put(title2,false);
      } else {
        throw new RuntimeException(title2 + " is already checked out!");  
      }
      if (collection.containsKey(title3) && collection.get(title3)) {
        collection.put(title3,false);
      } else {
        throw new RuntimeException(title3 + " is already checked out!");
      }
    }

    /** Checks to see if the title is out of the library. Updates to true or otherwise throws error.
     @param String name is the title of the book
  */
    public void returnBook(String title) {
      System.out.println("Returning book...");
      if (collection.containsKey(title) && !collection.get(title)) {
        collection.put(title, true);
      } else {
        throw new RuntimeException(title + "is already returned!");
      }
    }

    /** Checks if a book is in the collection
     @param String name is the title of the book
     @return boolean is whether or not the collection has the book.
  */
    public boolean containsTitle(String title) {
      if (collection.containsKey(title)) {
        return true;
      } else {
        return false;
      }
    }
    
    /** Checks if a book is available to be checked out.
     @param String name is the title of the book
     @return boolean is whether or not the book can be checked out. 
  */
    public boolean isAvailable(String title) {
      if (collection.containsKey(title) && collection.containsValue(true)) {
        return collection.get(title);
      } else {
        return collection.get(title);
      }
    }

    /**
     * Shows all available actions for the given building 
     */
    public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle(s)\n + removeTitle(s)\n + removeTitle(s,s,s)\n + checkOut(s)\n + returnBook(s)\n + containsTitle(s)\n + isAvailable(s) + printCollection()\n + printCollection(s)\n + hasElevator()\n + goToFloor(n).");
  }

  /**
   * Prints out the entire collection in an easy-to-read way (including check-out status)
   */
    public void printCollection() {
      System.out.println("------------");
      System.out.println("Neilson Library's Collection:");
      Enumeration<String> e = collection.keys(); // Get Enumeration of keys
      while (e.hasMoreElements()) {
          String title = e.nextElement();
          String availability;
          boolean status = collection.get(title);
          if (status == true) {
            availability = "Available";
          } else {
            availability = "Checked Out";
          }
          System.out.println(title + " - " + availability);
      }
        System.out.println("------------");
    }

    /**
     * Prints out all books by a specified author
     * @param author specifies the books that are shown
     */
    public void printCollection(String author) {
      System.out.println("------------");
      System.out.println("Collection of Books by " + author + ":");
      Enumeration<String> e = collection.keys();
      while (e.hasMoreElements()) {
        String title = e.nextElement();
        if (title.contains(author)) {
            System.out.println(title);
        } 
      }
    }

    /**
     * Gets boolean status of whether or not the building has an elevator 
     * @return whether or not the building has an elevator
     */
    public boolean hasElevator() {
      return hasElevator;
  }

  /** 
   * "Teleports" the user to the specified floor 
   * @param floorNum specifies the floor number the user is going to 
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
      Library Neilson = new Library("Neilson Library", "7 Neilson Drive", 5, true);
      System.out.println(Neilson);
      Neilson.showOptions();
      // Adding books to collection
      Neilson.addTitle("Animal Farm by George Orwell", true);
      Neilson.addTitle("Don Quixote by Miguel de Cervantes", true);
      Neilson.addTitle("Dune by Frank Herbert", true);
      Neilson.addTitle("Dune Messiah by Frank Herbert", true);
      Neilson.addTitle("La Galatea by Miguel de Cervantes", true);
      Neilson.addTitle("Fahrenheit 451 by Ray Bradburys", true);
      // Print collection
      System.out.println("\n");
      Neilson.printCollection();
      // Check if books are in collection & their availability 
      System.out.println("\n");
      System.out.println("Animal Farm is in the collection: " + Neilson.containsTitle("Animal Farm by George Orwell"));
      System.out.println("Don Quixote is available to check out: " + Neilson.isAvailable("Don Quixote by Miguel de Cervantes"));
      // Checking out a book
      System.out.println("\n");
      Neilson.checkOut("Don Quixote by Miguel de Cervantes");
      System.out.println("Don Quixote is available to check out: " + Neilson.isAvailable("Don Quixote by Miguel de Cervantes"));
      Neilson.printCollection();
      // Checking out multiple books
      System.out.println("\n");
      Neilson.checkOut("Animal Farm by George Orwell", "Fahrenheit 451 by Ray Bradburys","La Galatea by Miguel de Cervantes");
      Neilson.printCollection();
      // Returning a book
      System.out.println("\n");
      Neilson.returnBook("Don Quixote by Miguel de Cervantes");
      // Print collection
      Neilson.printCollection();
      // Print books by a certain author
      System.out.println("\n");
      Neilson.printCollection("Frank Herbert");
      // Removing a book from the collection
      System.out.println("\n");
      Neilson.removeTitle("Dune by Frank Herbert");
      Neilson.printCollection();
      // Removing an author from the collection
      System.out.println("\n");
      Neilson.removeTitle("Animal Farm by George Orwell", "La Galatea by Miguel de Cervantes", "Dune Messiah by Frank Herbert");
      Neilson.printCollection();
      // Entering, exiting, elevator...
      System.out.println("\n");
      Neilson.enter();
      Neilson.goToFloor(3);
      Neilson.goUp();
      Neilson.goDown();
      Neilson.goToFloor(1);
      Neilson.exit();
    }

  }