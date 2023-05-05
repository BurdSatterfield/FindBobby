import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class BackPack{

    private String torch;
    
    public BackPack(){                          //empty constructor to create backpack object in main
    }
 
    public void addTorch(int index, String torch) {         //adds item to backpack
        this.torch = "torch";
    }

    public void printInfo() {                                   //prints the info to of the backpack contents to a text file
        String fileName = String.format("BackPack.txt");
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
        }
        PrintWriter outFS = new PrintWriter(fileStream);
        outFS.println("BackPack: " + this.torch);
        outFS.println();
        outFS.close();
    }

}