import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sage Hall", "144 Green St, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "5 Chapin Way, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Alumnae House", "33 Elm St, Northampton, MA 01060", 3));
        myMap.addBuilding(new Building("Admission's Office", "7 College Ln, Northampton, MA 01060", 1));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Botanic Garden", "16 College Ln, Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Wright Hall", "5 Chapin Way, Northampton, MA 01063", 3));
        myMap.addBuilding(new Cafe("Woodstar Cafe", "60 Masonic St, Northampton, MA 01060", 1, 20, 50, 25, 15, false));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Lamont House", "17 Prospect St., Northampton, MA 01063", 4, true, true));

        System.out.println(myMap);
    }
    
}
