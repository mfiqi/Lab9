package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {

    /**
     * Load Census Data
     * @param fname
     * @return nameList
     */
    public static Surname[] loadCensusData(String fname) {
        int line = 0; // Keep track of lines of file we've read
        Surname[] namelist = new Surname[100];
        String name;
        int rank;
        int count;
        double proportion;

        //Reads next line, but skips first line
        File file = new File(fname);
        try (Scanner input = new Scanner(file)){
            input.nextLine();
            while (input.hasNext() && line <100) {
                String s = input.nextLine();
                //System.out.println(s);
                String[] parts = s.split(",");
                name = parts [0];
                rank = Integer.parseInt(parts[1]);
                count = Integer.parseInt(parts[2]);
                proportion = Double.parseDouble(parts[4]);
                namelist[line] = new Surname(name,rank,count,proportion);
                line++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot access file " +fname);
        }

        return namelist;
    }
}