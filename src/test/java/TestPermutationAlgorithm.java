import junit.framework.TestCase;
import model.Vector;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestPermutationAlgorithm {

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
        ArrayList<Vector> result = new ArrayList<>(hexagon);

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(hexagon);
        permutationAlgorithm.findBestPermutation();

        TestCase.assertTrue(permutationAlgorithm.acceptablePermutations.contains(result));
        TestCase.assertEquals(permutationAlgorithm.getMaxArea(), HEXAGON_AREA);
    }

    @Test
    public void twoIdenticalVectorsTest(){
        ArrayList<Vector> result = new ArrayList<>(sixVectorsPolygon);
        Vector vectorE = result.get(4);
        Vector vectorF = result.get(5);
        result.remove(5);
        result.remove(4);
        result.add(vectorF);
        result.add(vectorE);

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(sixVectorsPolygon);
        permutationAlgorithm.findBestPermutation();

        TestCase.assertTrue(permutationAlgorithm.acceptablePermutations.contains(result));
        TestCase.assertEquals(permutationAlgorithm.getMaxArea(), POLYGON_AREA);

    }
}
