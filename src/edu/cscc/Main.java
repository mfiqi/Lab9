package edu.cscc;

/**
 * @author musab fiqi
 * @version 1.0
 * 2019-29-10
 * Arrange First 100 Surnames
 */
public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";

    public static void main(String[] args) {

        Surname[] namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) {
            System.out.println("Rank\tName");
            for (Surname name : namelist) {
                System.out.println(name.getRank() + "\t\t" + name.getName());
            }
        }
    }
}