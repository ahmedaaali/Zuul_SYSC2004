
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class creates an item, that can be added inside rooms.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 * @author Ahmed Ali
 * @version March 06, 2022
 */
public class Item
{
    private String description;
    private double weight; // used to keep the weight of the item

    /**
     * Creates an Item object with given description and weight.
     * 
     * @param description The item's description
     * @param weight The weight of the item
     */
    public Item(String description, double weight)
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Creates a string describing the item and it's weight.
     *
     * @return A string describing the item and it's weight
     */
    public String getDescription()
    {
        return ("a " + description + " that weighs " + weight + "kg.\n");
    }
}
