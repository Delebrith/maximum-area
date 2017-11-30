package utils;

import model.Vector;
import solutions.PermutationAlgorithm;
import solutions.SortByAngleAlgorithm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TimeMeasurement {

    private final String FILE_NAME = "results.txt";

    private int startAmount;
    private int maxAmount;
    private int loopsForAmount;

    private long averagePermutationsTime;
    private long averageSortingTime;

    public TimeMeasurement(int startAmount, int maxAmount, int loopsForAmount) {
        this.startAmount = startAmount;
        this.maxAmount = maxAmount;
        this.loopsForAmount = loopsForAmount;
        averagePermutationsTime = 0;
        averageSortingTime = 0;
    }

    public void doMeasurements(){
        System.out.println("Starting measurement...");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILE_NAME, "UTF-8");
            writer.println("amount\tpermutations time\tsorting time");

            for (int i = startAmount; i <= maxAmount; i++){
                for (int j = 0; j < loopsForAmount; j++){
                    measurePermutationsTime(i);
                    measureSortingTime(i);
                }
                averagePermutationsTime /= loopsForAmount;
                averageSortingTime /= loopsForAmount;
                writer.println(i + "\t" + averagePermutationsTime + "\t" + averageSortingTime);
                System.out.println(i + "\t" + averagePermutationsTime + "\t" + averageSortingTime);
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (writer != null){
            writer.close();
        }
        System.out.println("Measurements finished! Check out results in results.txt");

    }

    private void measurePermutationsTime(int currentNumberOfVectors){
        VectorGenerator generator = new VectorGenerator(currentNumberOfVectors);
        ArrayList<Vector> vectors = generator.generateList();
        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(vectors);

        long start = System.currentTimeMillis();
        permutationAlgorithm.findBestPermutation(false);
        long stop = System.currentTimeMillis();
        averagePermutationsTime += (stop - start);
    }

    private void measureSortingTime(int currentNumberOfVectors){

        VectorGenerator generator = new VectorGenerator(currentNumberOfVectors);
        ArrayList<Vector> vectors = generator.generateList();
        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors);

        long start = System.currentTimeMillis();
        sortByAngleAlgorithm.findBestOrder();
        long stop = System.currentTimeMillis();
        averageSortingTime += (stop - start);
    }

    public void doSortingMeasurement(){
        System.out.println("Starting measurement...");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("sorting_" + FILE_NAME, "UTF-8");
            writer.println("amount\tsorting time");

            for (int i = startAmount; i <= maxAmount; i++){
                for (int j = 0; j < loopsForAmount; j++){
                    measureSortingTime(i);
                }
                averageSortingTime /= loopsForAmount;
                writer.println(i + "\t"  + "\t" + averageSortingTime);
                System.out.println(i + "\t"  + "\t" + averageSortingTime );
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (writer != null){
            writer.close();
        }
        System.out.println("Measurements finished! Check out results in sorting_results.txt");
    }

    public void warmup(){
        System.out.println("Warming up JVM...");
        for (int i = 3; i < 10; i++){
            for (int j = 0; j < 10; j++){
                measurePermutationsTime(i);
                measureSortingTime(i);
            }
        }
        averageSortingTime = 0;
        averagePermutationsTime = 0;
    }

}

