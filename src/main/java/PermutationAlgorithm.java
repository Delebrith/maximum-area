import config.LoggerConfig;
import exceptions.NotAPolygonException;
import model.Polygon;
import model.Vector;
import model.Polygon;
import model.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PermutationAlgorithm {

    private List<Vector> vectors;
    private List<List<Vector>> permutations = new ArrayList<>();
    private List<Vector> bestPermutation;
    private double maxArea;

    public List<List<Vector>> acceptablePermutations = new ArrayList<>();

    public PermutationAlgorithm(List<Vector> vectors) {
        this.vectors = vectors;
        maxArea = 0;
        permute(vectors, 0);
    }

    public List<Vector> getBestPermutation() {
        return bestPermutation;
    }

    public List<List<Vector>> getAcceptablePermutations() {
        return acceptablePermutations;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void findBestPermutation(){
        for (List<Vector> list : permutations) {
            try {
                Polygon polygon = new Polygon(list);
                double area = polygon.calculateArea();
                if (maxArea < area){
                    maxArea = area;
                    bestPermutation = list;
                }
            } catch (NotAPolygonException e) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < list.size(); i++){
                    builder.append(list.get(i).getName() + " ");
                }
                LoggerConfig.LOGGER.info("For permutation: " + builder.toString()+ " " + e.getMessage());
            }
        }
        for (List<Vector> list : permutations) {
            try {
                Polygon polygon = new Polygon(list);
                double area = polygon.calculateArea();
                if (area == maxArea){
                    acceptablePermutations.add(new ArrayList<>(list));
                }
            } catch (NotAPolygonException e) {
                LoggerConfig.LOGGER.log(Level.FINER, e.getMessage());
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bestPermutation.size(); i++){
            builder.append(bestPermutation.get(i).getName() + " ");
        }
        LoggerConfig.LOGGER.info("Best permutation: " + builder.toString() + "area: " + maxArea);
        builder.delete(0, builder.length());
        for (int i = 0; i < acceptablePermutations.size(); i++){
            builder.append(i + "# ");
            for (int j = 0; j < bestPermutation.size(); j++){
                builder.append(acceptablePermutations.get(i).get(j).getName() + " ");
            }
            builder.append("\n");
        }
        LoggerConfig.LOGGER.info("Acceptable permutations: \n" + builder.toString());


    }


    private void permute(List<Vector> singleVectorList, int startIndex){
        if (startIndex >= singleVectorList.size()){
            permutations.add(new ArrayList<>(singleVectorList));
        }

        for (int i = startIndex; i < singleVectorList.size(); i++){
            swap(singleVectorList, startIndex, i);
            permute(singleVectorList, startIndex + 1);
            swap(singleVectorList, startIndex, i);
        }
    }

    private void swap(List<Vector> singleVectorList, int i, int j){
        Vector tmpVector = singleVectorList.get(i);
        singleVectorList.set(i, singleVectorList.get(j));
        singleVectorList.set(j, tmpVector);
    }
}
