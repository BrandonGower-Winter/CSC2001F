import java.lang.*;
/**
* The Person Data Model that implements the comparable interface.
* A Person object stores information on a person's name. address and telephoneNumber.
* @author Brandon Gower-Winter
*/
public class Person implements Comparable<Person>
{
    //private variables
    private String name;
    private String telephoneNumber;
    private String address;
    /**
    * Constructor of the person object
    * @param name The name of the person object you wish to create.
    * @param telephoneNumber The telephone number of the person object you wish to create.
    * @param address The address of the person ibject you wish to create
    */
    public Person(String name, String telephoneNumber, String address)
    {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
    /**
    * Constructor that only has one parameter.
    * telephoneNumber and address are set to blank string values.
    * @param name The name of the person object you wish to create.
    */
    public Person(String name)
    {
      this.name = name;
      telephoneNumber = "";
      address = "";
    }
    //Methods
    /**
    * Return the name of the person object
    * @return String
    */
    public String getName()
    {
        return name;
    }
    /**
    * A comparison function that compares that compares the two name values of the objects you are comparing.
    * Function is multiplied by -1 so that it considers A to be greater than Z
    * @param p The person object you wish to compare.
    * @return int
    */
    public int compareTo(Person p)
    {
        return  -1 * name.compareTo(p.getName());
    }
    /**
    * The toString function that returns the name, telephoneNumber and address seperated by tabs as one String.
    * @return String
    */
    public String toString()
    {
        return name+"\t"+ telephoneNumber+"\t"+address;
    }
}
