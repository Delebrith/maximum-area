import model.Vector;
import solutions.PermutationAlgorithm;
import solutions.SortByAngleAlgorithm;
import utils.DataParser;
import utils.TimeMeasurement;

import java.util.ArrayList;

public class Main {

    /**
     * @param args
     * arg[0] - mode. m1 for reading data from file. m2 for reading data from input stream. m3 for generating
     * data inside the programme and time measurment
     *
     * <p>Extra params: <br>
     * For m1:
     * <ul>
     *     <li>name of file</li>
     * </ul>
     * For m3:
     * <ul>
     *     <li>start amount of vectors (min 2)</li>
     *     <li>maximum amount of vectors (best less than 11)</li>
     *     <li>number of tests for each amount</li>
     * </ul>
     * </p>
     */
    public static void main(String[] args) {

        if (args.length < 1){
            System.out.println("Missing arguments!");
            return;
        }

        if (args[0].equals("m1")){
            if (args.length < 2){
                System.out.println("Missing arguments!");
                return;
            }
            ArrayList<Vector>  vectors = DataParser.parseFileToArrayList(args[1]);

            PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(vectors);
            permutationAlgorithm.findBestPermutation(true);
            permutationAlgorithm.printAcceptablePermutations();

            SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors);
            sortByAngleAlgorithm.findBestOrder();
            sortByAngleAlgorithm.printBestOrder();

            return;
        }

        if (args[0].equals("m2")){
            ArrayList<Vector>  vectors = DataParser.parseInputToArrayList(System.in);

            PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(vectors);
            permutationAlgorithm.findBestPermutation(true);
            permutationAlgorithm.printAcceptablePermutations();

            SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors);
            sortByAngleAlgorithm.findBestOrder();
            sortByAngleAlgorithm.printBestOrder();

            return;
        }

        if (args[0].equals("m3")){
            int startAmount;
            int maxAmount;
            int loops;

            if (args.length < 4){
                return;
            }

            startAmount = Integer.parseInt(args[1]);
            maxAmount = Integer.parseInt(args[2]);
            loops = Integer.parseInt(args[3]);

            TimeMeasurement timeMeasurement = new TimeMeasurement(startAmount, maxAmount, loops);
            timeMeasurement.doMeasurements();
            return;
        }

        if (args[0].equals("m4")){
            int startAmount;
            int maxAmount;
            int loops;

            if (args.length < 4){
                return;
            }

            startAmount = Integer.parseInt(args[1]);
            maxAmount = Integer.parseInt(args[2]);
            loops = Integer.parseInt(args[3]);

            TimeMeasurement timeMeasurement = new TimeMeasurement(startAmount, maxAmount, loops);
            timeMeasurement.doSortingMeasurement();
            return;
        }

    }
}
