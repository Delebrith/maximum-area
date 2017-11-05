package solutions;

import exceptions.NotAPolygonException;
import model.Polygon;
import model.Vector;
import utils.MergeSorter;

import java.util.ArrayList;
import java.util.List;

public class SortByAngleAlgorithm {

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
        }
    }

    private void shiftVectors(){
        Vector shiftedVector = new Vector(vectorList.get(0).getxSteps(), vectorList.get(0).getySteps(),
                vectorList.get(0).getName());
        vectorList.remove(0);
        vectorList.add(shiftedVector);
    }

    public void printBestOrder(){
        StringBuilder builder = new StringBuilder();
        for (Vector aBestOrder : bestOrder) {
            builder.append(aBestOrder.getName() + " ");
        }
        System.out.println("Best order: " + builder.toString() + "area: " + maxArea);
    }
}
