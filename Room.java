import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList; // import the ArrayList class

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * 
 * @author Lynn Marshall
 * @version October 21, 2012
 * 
 * @author Ahmed Ali
 * @version March 06, 2022
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    ArrayList<Item> items; // where items inside a room are stored

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>(); // a list to store items inside a room
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit
     * @param neighbour The room to which the exit leads
     */
    public void setExit(String direction, Room neighbour) 
    {
        exits.put(direction, neighbour);
    }

    /**
     * Returns a short description of the room, i.e. the one that
     * was defined in the constructor
     * 
     * @return The short description of the room
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + getItemsString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString + "\n";
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction
     * @return The room in the given direction
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Adds an item to the list of items inside a room.
     * 
     * @param description The item's description
     * @param weight The weight of the item
     */
    public void addItem(String description, double weight) 
    {
        items.add(new Item(description, weight));
    }

    /**
     * Adds an item to the list of items inside a room.
     * 
     * @param item The item to be added
     */
    public void addItem(Item item) 
    {
        items.add(item);
    }
    
    /**
     * Creates a string of all the items inside the room.
     * 
     * @return Details of the room's items
     */
    public String getItemsString() 
    {
        String returnString = "";
        if (items.size() > 0) {
            returnString += "Items:\n"; // making sure to have a new line for correct format
            for(Item item : items) { // for each loop to go through all the items
                returnString += "    " + item.getDescription(); // couldn't use "\t", not same format
            }
        }
        return returnString;
    }
}

