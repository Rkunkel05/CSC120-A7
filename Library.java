/**
   * Filename: Library.java
* Description: Creates a Library utilizing the parent class Building. Contains a name, address, number of floors,
as well as a hashtable containing books and their check-out status. 
     * Author: Rachel Kunkel
      *  Date: 10 March 2024  
*/

import java.util.Hashtable;
import java.util.Enumeration;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  String title;
  Boolean status;

    /** Creates library building
     @param String name is a String of the name of the library
     @param String address is String of the address of the library
     @param int floor is the number of floors in the building
  */
    public Library(String name, String address, int floors) {
      super(name, address, floors); 
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /** Adds a book to the collection
     @param String name is the title of the book
     @param boolean is the check-out status of the book
  */
    public void addTitle(String title, Boolean status) {
      collection.put(title, status);
    }

    /** Checks to see if the title is in the collection and removes it. Otherwise throws error
     @param String name is the title of the book
  */
    public String removeTitle(String title) { 
      if (collection.containsKey(title)) {
          collection.remove(title);
          return title;
      }  else {
        throw new RuntimeException(title + "does not exist!");
      } }

    /** Checks to see if the title is in the library. Updates to false or otherwise throws error.
     @param String name is the title of the book
  */
    public void checkOut(String title) {
      if (collection.containsKey(title) && collection.get(title)) {
        collection.put(title, false);
      } else {
        throw new RuntimeException(title + "is already checked out!");
      }
    }

    /** Checks to see if the title is out of the library. Updates to true or otherwise throws error.
     @param String name is the title of the book
  */
    public void returnBook(String title) {
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

    // prints out the entire collection in an easy-to-read way (including checkout status)
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

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "7 Neilson Drive", 5);
      System.out.println(Neilson);
      // Adding books to collection
      Neilson.addTitle("Animal Farm by George Orwell", true);
      Neilson.addTitle("Don Quixote by Miguel de Cervantes", true);
      Neilson.addTitle("Dune by Frank Herbert", true);
      // Print collection
      Neilson.printCollection();
      // Check if books are in collection & their availability 
      System.out.println("Animal Farm is in the collection: " + Neilson.containsTitle("Animal Farm by George Orwell"));
      System.out.println("Don Quixote is available to check out: " + Neilson.isAvailable("Don Quixote by Miguel de Cervantes"));
      // Checking out a book
      System.out.println("Checking out book...");
      Neilson.checkOut("Don Quixote by Miguel de Cervantes");
      System.out.println("Don Quixote is available to check out: " + Neilson.isAvailable("Don Quixote by Miguel de Cervantes"));
      Neilson.printCollection();
      // Returning a book
      System.out.println("Returning book...");
      Neilson.returnBook("Don Quixote by Miguel de Cervantes");
      // Print collection
      Neilson.printCollection();
      // Removing a book from the collection
      Neilson.removeTitle("Dune by Frank Herbert");
      System.out.println("Removing book...");
      Neilson.printCollection();
    }

  }