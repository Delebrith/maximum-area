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

public class SortByAngleAlgorithm {

    private List<Vector> vectorList;
    private List<Vector> bestOrder;
    double maxArea = 0;


    public SortByAngleAlgorithm(List<Vector> vectorList) {
        this.vectorList = vectorList;
    }

    public List<Vector> getVectorList() {
        return vectorList;
    }

    public List<Vector> getBestOrder() {
        return bestOrder;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public List<Vector> findBestOrder(){
        MergeSorter mergeSorter = new MergeSorter(vectorList);

        mergeSorter.sort(true, MergeSorter.Sorting.X1, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }


        mergeSorter.sort(false, MergeSorter.Sorting.X1, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }

        mergeSorter.sort(true, MergeSorter.Sorting.Y1, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }

        mergeSorter.sort(false, MergeSorter.Sorting.Y1, 0, vectorList.size()-1);
        for (int i = 0; i < vectorList.size()-1; i++){
            isTheBest();
            shiftVectors();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bestOrder.size(); i++){
            builder.append(bestOrder.get(i).getName() + " ");
        }
        LoggerConfig.LOGGER.info("Best order: " + builder.toString() + "area: " + maxArea);
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
            LoggerConfig.LOGGER.log(Level.FINER, e.getMessage());
        }
    }

    private void shiftVectors(){
        Vector shiftedVector = new Vector(vectorList.get(0).getxSteps(), vectorList.get(0).getySteps(),
                vectorList.get(0).getName());
        vectorList.remove(0);
        vectorList.add(shiftedVector);
    }
}
