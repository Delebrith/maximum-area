import junit.framework.TestCase;
import model.Vector;
import org.junit.Before;
import org.junit.Test;
import solutions.PermutationAlgorithm;
import solutions.SortByAngleAlgorithm;
import utils.VectorGenerator;

import java.util.ArrayList;

public class TestSortByAngleAlgorithm {

    private ArrayList<Vector> hexagon;
    private ArrayList<Vector> sixVectorsPolygon;

    private final double HEXAGON_AREA = 4.0;
    private final double POLYGON_AREA = 6.0;

    @Before
    public void init(){
        hexagon = new ArrayList<>();

        hexagon.add(new Vector(1,1, "A"));
        hexagon.add(new Vector(1,0, "B"));
        hexagon.add(new Vector(1,-1, "C"));
        hexagon.add(new Vector(-1, -1, "D"));
        hexagon.add(new Vector(-1, 0, "E"));
        hexagon.add(new Vector(-1, 1, "F"));

        sixVectorsPolygon = new ArrayList<>();

        sixVectorsPolygon.add(new Vector(1,1, "A"));
        sixVectorsPolygon.add(new Vector(1,0, "B"));
        sixVectorsPolygon.add(new Vector(1,-1, "C"));
        sixVectorsPolygon.add(new Vector(-1, -1, "D"));
        sixVectorsPolygon.add(new Vector(-1, 0, "E"));
        sixVectorsPolygon.add(new Vector(-1, -1, "F"));
    }

    @Test
    public void hexagonTest(){

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(hexagon);
        sortByAngleAlgorithm.findBestOrder();

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(hexagon);
        permutationAlgorithm.findBestPermutation(true);

        TestCase.assertTrue(TestUtils.contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(sortByAngleAlgorithm.getMaxArea(), HEXAGON_AREA);
    }

    @Test
    public void twoIdenticalVectorsTest(){

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(sixVectorsPolygon);
        permutationAlgorithm.findBestPermutation(true);

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(sixVectorsPolygon);
        sortByAngleAlgorithm.findBestOrder();

        TestCase.assertTrue(TestUtils.contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(POLYGON_AREA, sortByAngleAlgorithm.getMaxArea());
    }

}
