package Composite;

import Datagram.DatagramClass;
import Visitor.Visitor;

public class File extends DatagramClass implements Composite{
    private Composite parent;

    /**
     * File constructor
     * @param data datagram reference
     */
    public File(DatagramClass data){
        super(data);
        parent=null;
    }

    /**
     * set the parent directory to this file
     * @param dad parent directory
     */
    @Override
    public void setParent(Composite dad) {
        parent = dad;
    }

    /**
     * call size function of datagram class
     * @return datagram size
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * call columns function of datagram class
     * @return key datagram number
     */
    @Override
    public int columns() {
        return super.columns();
    }

    /**
     * select the name of this file
     * @return file's name
     */
    @Override
    public String getName(){
        return super.getName();
    }

    /**
     * method that takes the specific position according to a key of a file
     * @param row row=position of the key array
     * @param label key name
     * @return string that satisfy the conditions
     */
    @Override
    public String at(int row, String label){
        return super.at(row,label);
    }

    /**
     * Method that accepts a visitor and performs the type of visitor to the datagram associated to the file
     * @param visitor type of visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
