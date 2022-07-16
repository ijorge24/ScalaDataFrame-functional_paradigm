package Datagram;
import java.util.*;
/**
 * Class that implements iterator
 */
public class IteratorClass implements Iterator<String> {

    int index;
    List<String> info;
    /**
     * ask if there is another value after
     */
    public boolean hasNext() {

        return index < info.size();
    }
    /**
     * get the next info value if exists
     * @return the next value or null
     */
    @Override
    public String next() {

        if(this.hasNext()){
            return info.get(index);
        }
        return null;
    }
}
