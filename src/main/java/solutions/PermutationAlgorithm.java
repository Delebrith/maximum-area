package solutions;

import exceptions.NotAPolygonException;
import model.Polygon;
import model.Vector;

import java.util.ArrayList;
import java.util.List;

public class PermutationAlgorithm {

    private List<Vector> vectors;
    private List<List<Vector>> permutations = new ArrayList<>();
    private List<Vector> bestPermutation;
    private double maxArea;

    private List<List<Vector>> acceptablePermutations = new ArrayList<>();

    public PermutationAlgorithm(List<Vector> vectors) {
        this.vectors = vectors;
        maxArea = 0;
    }

    public List<List<Vector>> getAcceptablePermutations() {
        return acceptablePermutations;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void findBestPermutation(boolean findAll){
        permute(vectors, 0);
        for (List<Vector> list : permutations) {
            try {
                Polygon polygon = new Polygon(list);
                double area = polygon.calculateArea();
                if (maxArea < area){
                    maxArea = area;
                    bestPermutation = list;
                }
            } catch (NotAPolygonException e) {
            }
        }

        if (findAll) {
            for (List<Vector> list : permutations) {
                try {
                    Polygon polygon = new Polygon(list);
                    double area = polygon.calculateArea();
                    if (area == maxArea) {
                        acceptablePermutations.add(new ArrayList<>(list));
                    }
                } catch (NotAPolygonException e) {
                }
            }
        }
    }

    public void printAcceptablePermutations(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < acceptablePermutations.size(); i++){
            builder.append(i + "# ");
            for (int j = 0; j < bestPermutation.size(); j++){
                builder.append(acceptablePermutations.get(i).get(j).getName() + " ");
            }
            builder.append("\n");
        }
        System.out.println("Acceptable permutations: \n" + builder.toString());
    }

    public void pribtBestPermutation(){
        StringBuilder builder = new StringBuilder();
        for (Vector aBestPermutation : bestPermutation) {
            builder.append(aBestPermutation.getName() + " ");
        }
        System.out.println("Best permutation: " + builder.toString() + "area: " + maxArea);
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
