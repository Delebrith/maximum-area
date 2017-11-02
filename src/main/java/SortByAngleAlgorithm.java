import config.LoggerConfig;
import exceptions.NotAPolygonException;
import model.Polygon;
import model.Vector;
import utils.MergeSorter;
import model.Polygon;
import model.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortByAngleAlgorithm {

    private final Logger LOGGER = Logger.getLogger("MyLogger");

    private List<Vector> vectorList;
    private List<Vector> bestOrder;
    private double maxArea = 0;


    public SortByAngleAlgorithm(List<Vector> vectorList) {
        this.vectorList = vectorList;
    }

    public List<Vector> getBestOrder() {
        return bestOrder;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public List<Vector> findBestOrder(){
        MergeSorter mergeSorter = new MergeSorter(vectorList);

        mergeSorter.sort(true, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }


        mergeSorter.sort(false, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }

        StringBuilder builder = new StringBuilder();
        for (Vector aBestOrder : bestOrder) {
            builder.append(aBestOrder.getName() + " ");
        }
        LOGGER.info("Best order: " + builder.toString() + "area: " + maxArea);
        return bestOrder;
    }

    private void isTheBest() {
        try {
            Polygon polygon = new Polygon(vectorList);
            double currentArea = polygon.calculateArea();
            if (maxArea < currentArea) {
                maxArea = currentArea;
                bestOrder = new ArrayList<>(vectorList);
            }
        } catch (NotAPolygonException e){
            LOGGER.log(Level.FINER, e.getMessage());
        }
    }

    private void shiftVectors(){
        Vector shiftedVector = new Vector(vectorList.get(0).getxSteps(), vectorList.get(0).getySteps(),
                vectorList.get(0).getName());
        vectorList.remove(0);
        vectorList.add(shiftedVector);
    }
}
