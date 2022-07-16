package Datagram;
import java.io.*;
import java.util.*;

/**
 * Class that treat a CSV file
 */
public class CSV implements Files {
    /**
     * Method that read the file and create and fill a datagram
     * @param path the path of the file
     * @return a datagram with all the info of the file
     */
    @Override
    public DatagramClass readFile(String path) {
        File fichero = new File(path);
        String line;
        int i;
        int j = path.lastIndexOf('.');
        DatagramClass datagram = new DatagramClass(new LinkedHashMap<>(),path.substring(0,j));
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            if ((line = br.readLine()) != null) {
                StringTokenizer strtok = new StringTokenizer(line, ",");

                while (strtok.hasMoreTokens())
                    datagram.addLabel(strtok.nextToken().strip().replace("\"", ""));

                while ((line = br.readLine()) != null) {
                    i=0;
                    strtok = new StringTokenizer(line, ",");
                    while (strtok.hasMoreTokens()) {
                        datagram.addInfo(i,strtok.nextToken().strip().replace("\"", ""));
                        i++;
                    }

                }
            }
        } catch
        (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return datagram;
    }
}
