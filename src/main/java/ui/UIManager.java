package ui;

import core.VectorGenerator;
import solution.PermutationAlgorithm;
import solution.SortByAngleAlgorithm;

public class UIManager{

    private Window window;
    private PermutationAlgorithm permutationAlgorithm;
    private SortByAngleAlgorithm sortByAngleAlgorithm;
    private VectorGenerator vectorGenerator;

    public UIManager() {
        this.window = new Window(this);
    }

    public PermutationAlgorithm getPermutationAlgorithm() {
        return permutationAlgorithm;
    }

    public SortByAngleAlgorithm getSortByAngleAlgorithm() {
        return sortByAngleAlgorithm;
    }

    public VectorGenerator getVectorGenerator() {
        return vectorGenerator;
    }

    public void setPermutationAlgorithm(PermutationAlgorithm permutationAlgorithm) {
        this.permutationAlgorithm = permutationAlgorithm;
    }

    public void setSortByAngleAlgorithm(SortByAngleAlgorithm sortByAngleAlgorithm) {
        this.sortByAngleAlgorithm = sortByAngleAlgorithm;
    }

    public void setVectorGenerator(VectorGenerator vectorGenerator) {
        this.vectorGenerator = vectorGenerator;
    }
}
