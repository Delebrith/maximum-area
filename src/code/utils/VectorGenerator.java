package code.utils;


import code.model.Vector;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VectorGenerator {

    private final Logger LOGGER = Logger.getLogger("Logger");

    private static final double MIN = -10;
    private static final double MAX = 10;

    private int amount;

    public VectorGenerator(int amount) {
        this.amount = amount;
    }

    public void generateToOutstream(){
        System.out.println(vectorListToString(generateList()));
    }

    public void generateToFile(String filename){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new PrintWriter(filename));
            ArrayList<Vector> vectors = generateList();
            for (int i = 0; i < vectors.size(); i++){
                writer.write(vectors.get(i).getxSteps() + " " + vectors.get(i).getySteps() + "\n");
            }
        } catch (IOException e) {
            LOGGER.log(Level.FINER, e.getMessage());
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.log(Level.FINER, e.getMessage());
                }
            }
        }
    }

    public ArrayList<Vector> generateList(){
        ArrayList<Vector> vectorList = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            double x  = ThreadLocalRandom.current().nextDouble(MIN, MAX);
            double y  = ThreadLocalRandom.current().nextDouble(MIN, MAX);
            vectorList.add(new Vector(x, y, Integer.toString(i)));
        }
        return vectorList;
    }

    private String vectorListToString(ArrayList<Vector> vectorList){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vectorList.size(); i++){
            stringBuilder.append(vectorList.get(i).getxSteps() + " " + vectorList.get(i).getySteps() + "\n");
        }
        return stringBuilder.toString();
    }
}
