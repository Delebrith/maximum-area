import core.VectorGenerator;
import junit.framework.TestCase;
import model.Vector;
import org.junit.Before;
import org.junit.Test;

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

    private boolean contains(PermutationAlgorithm permutationAlgorithm,
                             SortByAngleAlgorithm sortByAngleAlgorithm){
        boolean contains = false;
        ArrayList<String> acceptableResults = new ArrayList<>();

        for (int i = 0; i < permutationAlgorithm.getAcceptablePermutations().size(); i++){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < sortByAngleAlgorithm.getBestOrder().size(); j++){
                builder.append(sortByAngleAlgorithm.getBestOrder().get(j).getName() + " ");
            }
            acceptableResults.add(builder.toString());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sortByAngleAlgorithm.getBestOrder().size(); i++){
            builder.append(sortByAngleAlgorithm.getBestOrder().get(i).getName() + " ");
        }
        String sortResult = builder.toString();

        for (String result : acceptableResults){
            if (result.equals(sortResult)) contains = true;
        }
        return contains;
    }

    @Test
    public void hexagonTest(){

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(hexagon);
        sortByAngleAlgorithm.findBestOrder();

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(hexagon);
        permutationAlgorithm.findBestPermutation();

        TestCase.assertTrue(contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(sortByAngleAlgorithm.getMaxArea(), HEXAGON_AREA);
    }

    @Test
    public void twoIdenticalVectorsTest(){

        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(sixVectorsPolygon);
        permutationAlgorithm.findBestPermutation();

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(sixVectorsPolygon);
        sortByAngleAlgorithm.findBestOrder();

        TestCase.assertTrue(contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(POLYGON_AREA, sortByAngleAlgorithm.getMaxArea());
    }

    @Test
    public void randomPolygon(){
        VectorGenerator generator = new VectorGenerator(9);
        ArrayList<Vector> polygon = generator.generateList();


        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(polygon);
        permutationAlgorithm.findBestPermutation();

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(polygon);
        sortByAngleAlgorithm.findBestOrder();

        TestCase.assertTrue(contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(permutationAlgorithm.getMaxArea(), sortByAngleAlgorithm.getMaxArea());

    }

}
