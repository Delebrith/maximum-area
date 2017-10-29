import junit.framework.TestCase;
import model.Vector;
import org.junit.Before;
import org.junit.Test;
import utils.MergeSorter;

import java.util.ArrayList;

public class TestMergeSorter {

    private ArrayList<Vector> unsorted;
    private ArrayList<Vector> sortedByXAngleAscending;
    private ArrayList<Vector> sortedByXAngleDescending;

    @Before
    public void init(){
        unsorted = new ArrayList<>();
        sortedByXAngleAscending = new ArrayList<>();
        sortedByXAngleDescending = new ArrayList<>();

        Vector v0 = new Vector(1, 0, "0");
        Vector v1 = new Vector(1, -1, "1");
        Vector v2 = new Vector(0, -1, "2");
        Vector v3 = new Vector(-1, -1, "3");
        Vector v4 = new Vector(-1, 0, "4");
        Vector v5 = new Vector(-1, 1, "5");
        Vector v6 = new Vector(0, 1, "6");
        Vector v7 = new Vector(1, 1, "7");

        unsorted.add(v0);
        unsorted.add(v7);
        unsorted.add(v1);
        unsorted.add(v6);
        unsorted.add(v2);
        unsorted.add(v5);
        unsorted.add(v3);
        unsorted.add(v4);


        sortedByXAngleDescending.add(v0);
        sortedByXAngleDescending.add(v1);
        sortedByXAngleDescending.add(v2);
        sortedByXAngleDescending.add(v3);
        sortedByXAngleDescending.add(v4);
        sortedByXAngleDescending.add(v5);
        sortedByXAngleDescending.add(v6);
        sortedByXAngleDescending.add(v7);

        sortedByXAngleAscending.add(v7);
        sortedByXAngleAscending.add(v6);
        sortedByXAngleAscending.add(v5);
        sortedByXAngleAscending.add(v4);
        sortedByXAngleAscending.add(v3);
        sortedByXAngleAscending.add(v2);
        sortedByXAngleAscending.add(v1);
        sortedByXAngleAscending.add(v0);

    }

    @Test
    public void sortByXAngleAscendingTest(){
        MergeSorter sorter = new MergeSorter(new ArrayList<>(unsorted));
        sorter.sort(true, 0, unsorted.size()-1);

        for (int i = 0; i < sortedByXAngleAscending.size() - 1; i++){
            TestCase.assertSame(sorter.getVectorList().get(i), sortedByXAngleAscending.get(i));
        }
    }

    @Test
    public void sortByXAngleDescendingTest(){
        MergeSorter sorter = new MergeSorter(new ArrayList<>(unsorted));
        sorter.sort(false, 0, unsorted.size()-1);

        for (int i = 0; i < sortedByXAngleDescending.size() - 1; i++){
            TestCase.assertSame(sorter.getVectorList().get(i), sortedByXAngleDescending.get(i));
        }
    }
}
