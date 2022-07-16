package Datagram;

import java.util.*;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Class that contains the variables and functions of the datagram
 */
public class DatagramClass implements Iterable<String>{


    int longLabel;
    int longInfo;
    String name;
    LinkedHashMap<String, ArrayList<String>> info;

    /**
     * applied an iterable Class
     * @return iterator Class
     */
    public java.util.Iterator<String> iterator() {
        return new IteratorClass();
    }

    /**
     * Constructor of the object Datagram
     */
    public DatagramClass(LinkedHashMap<String, ArrayList<String>> info, String nom) {
        name=nom;
        this.info= info;
        longLabel=0;
        longInfo=0;
    }

    /**
     * Constructor needed for the class observer
     * @param data the datagram with the info
     */
    public DatagramClass (DatagramClass data)
    {
        this.info=data.info;
        this.longLabel=data.columns();
        this.longInfo=data.size();
        this.name=data.name;
    }

    /**
     * Set the name of the datagram
     * @param name the new name of the datagram
     */
    public void setName(String name){this.name=name;}

    /**
     * Get the name of the datagram
     * @return the name of the datagram
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Method that writes the labels and content of the datagram
     */
    public void Write(){
        System.out.println(info.keySet());
        for (int i=0;i<longInfo;i++)
        {
            for (int j=0;j<longLabel;j++)
                System.out.print(this.iat(i,j)+" ");
            System.out.println();
        }

    }

    /**
     * Add a new key to the hashmap
     * @param value the new label to be added
     */
    public void addLabel(String value){
        info.putIfAbsent(value,new ArrayList<>());
        longLabel++;
    }

    /**
     * Add a value to the specific key of the hashmap
     * @param pos position of the key
     * @param value a string to add at the selected row
     */
    public void addInfo(int pos,String value){
        if (pos==0)
            longInfo++;
        Object key=info.keySet().toArray()[pos];
        info.get(key).add(value);
    }

    /**
     * Obtaining the value of a specific key (col) of a specific row
     * @param row number with the row selected
     * @param col key name
     * @return specific value
     */
    public String at(int row, String col)
    {
        String devuelve=null;
        if(row<longInfo){
            if (info.containsKey(col))
                devuelve=info.get(col).get(row);
        }
        return devuelve;
    }


    /**
     * Obtaining the value of a specific key (col by a position) of a specific row
     * @param row number with the row selected
     * @param col key position
     * @return specific value
     */
    public String iat(int row, int col){
        if ((row<longInfo)&&(col<longLabel))
            return info.get((String)info.keySet().toArray()[col]).get(row);
        else
            return null;
    }

    /**
     * Select a key and return a list ordered
     * @param col  key name
     * @param comp comparator instruction applied to the list
     * @return the values of a key selected from the datagram in a certain order
     */
    public ArrayList<String> sort(String col,Comparator<String> comp) {
        return (ArrayList<String>) info.get(col).stream().sorted(comp).collect(Collectors.toList());
    }

    /**
     * The user provides a Boolean expression or condition and create a new filtered list
     * @param col column label name
     * @param selec condition applied to filter
     * @return all elements where a label value fulfills a certain condition
     */
    public ArrayList<String> query(String col,Predicate<String> selec) {
        return (ArrayList<String>) info.get(col).stream().filter(selec).collect(Collectors.toList());
    }


    /**
     * Get the content of the hashmap
     * @return info (the content of the hashmap)
     */
    public LinkedHashMap<String, ArrayList<String>> getInfo() {
        return info;
    }

    /**
     * Get the number of keys
     * @return longLabel (number of keys of the dataframe)
     */
    public int columns() {
        return longLabel;
    }

    /**
     * Get the number of items (rows)
     * @return longInfo (number of rows of the dataframe)
     */
    public int size() {
        return longInfo;
    }


}

