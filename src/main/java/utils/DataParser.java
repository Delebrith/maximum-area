package utils;

import model.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {

    public static ArrayList<Vector> parseInputToArrayList(InputStream is){
        ArrayList<Vector> vectors = new ArrayList<>();
        Scanner scanner = new Scanner(is);
        readData(scanner, vectors);
        return vectors;
    }

    public static ArrayList<Vector> parseFileToArrayList(String filename){
        ArrayList<Vector> vectors = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
            readData(scanner, vectors);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vectors;
    }

    private static void readData(Scanner scanner, ArrayList<Vector> vectors){
        int i = 0;
        while (scanner.hasNextLine()){
            Scanner scanner2 = new Scanner(scanner.nextLine());
            if (scanner2.hasNext()) {
                double xSteps = Double.parseDouble(scanner2.next());
                double ySteps = Double.parseDouble(scanner2.next());
                vectors.add(new Vector(xSteps, ySteps, String.valueOf(i)));
                i++;
            }
        }
    }

}
