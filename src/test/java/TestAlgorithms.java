import junit.framework.TestCase;
import model.Vector;
import org.junit.Test;
import solutions.PermutationAlgorithm;
import solutions.SortByAngleAlgorithm;
import utils.VectorGenerator;

import java.util.ArrayList;

public class TestAlgorithms {

    @Test
    public void randomPolygon(){
        VectorGenerator generator = new VectorGenerator(9);
        ArrayList<Vector> polygon = generator.generateList();


        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(polygon);
        permutationAlgorithm.findBestPermutation(true);

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(polygon);
        sortByAngleAlgorithm.findBestOrder();

        TestCase.assertTrue(TestUtils.contains(permutationAlgorithm, sortByAngleAlgorithm));
        TestCase.assertEquals(permutationAlgorithm.getMaxArea(), sortByAngleAlgorithm.getMaxArea());

    }
}
