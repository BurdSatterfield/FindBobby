//This code was adapted from Lab12;

import java.util.HashMap;

public class AdventureMap
{
    HashMap<String, Room> map;

    public AdventureMap()
    {
        map = new HashMap<>();
    }

    /**
     * Adds a room to the AdventureMap
     * The name associated in the room must be lowercase
     * @param room Room to be added to the AdventureMap
     */
    public void addRoom(Room roomInput)
    {
        // This add names and strings to the hashmap of maps
        // We don't have the toString() method written yet
        // The toString() method with take the line of text in the room object and put it in the toString() method
        this.map.put(roomInput.getName().toLowerCase(), roomInput);
    }

    /**
     * Returns the Room assocaited with the string name given
     * @param roomName the name of the room to be returned, room name must be valid
     * @return the Room object assocaited with the name, the name will be in lowercase
     */
    public Room getRoom(String roomName)
    {
        return this.map.get(roomName.toLowerCase());
    }
}