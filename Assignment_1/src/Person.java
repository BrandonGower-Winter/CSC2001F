/*
Brandon Gower-Winter
Person Data Model implements comparable
*/

import java.lang.*;

public class Person implements Comparable<Person>
{
    //private variables
    private String name;
    private String telephoneNumber;
    private String address;
    //Constructor
    public Person(String name, String telephoneNumber, String address)
    {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }
    //Methods
    public String getName()
    {
        return name;
    }
    
    public int compareTo(Person p)
    {
        return name.compareTo(p.getName());
    }
    
    public String toString()
    {
        return name+"\t"+ telephoneNumber+"\t"+address;
    }
}