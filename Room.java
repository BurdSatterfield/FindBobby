//This code has been adpapted from Lab12

import java.util.ArrayList;

public class Room
{
    String name;
    String description;
    ArrayList<String> exits;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getExits() {
		return this.exits;
	}

	public void setExits(String exit) {
		this.exits.add(exit);
	}
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new ArrayList<>();
    }
    /* Generate getters and setters for the naems and descriptions */
    
    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit) {
        // Probably have to use this.exits
        exits.add(exit);
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    
    public String listExits() {                     //build a string???
        String exitString = "";
        for(String exit : this.exits){
            exitString += "\n" + exit + " ";            
        }
        // System.out.println(exitString);
        return exitString;
    }
    
    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    
    // Take all of the info in this room object and make it return all of the strings together
    public String toString() {
        String roomInfo1;
        roomInfo1 = (this.name + ": " + this.description +"\n" + "Exits:\n");
        String roomInfo2 = "";
        for (String e : exits) {
            roomInfo2 += exits + " ";
        }
        return roomInfo1;
    }
}