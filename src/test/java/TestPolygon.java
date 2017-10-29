import exceptions.NotAPolygonException;
import junit.framework.TestCase;
import model.Polygon;
import model.Vector;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestPolygon {

    private static final double AREA = 7.0;
    private ArrayList<Vector> octagon;
    private ArrayList<Vector> notAPolygon;


    @Before
    public void init(){

        Vector v0 = new Vector(1, 0, "0");
        Vector v1 = new Vector(1, -1, "1");
        Vector v2 = new Vector(0, -1, "2");
        Vector v3 = new Vector(-1, -1, "3");
        Vector v4 = new Vector(-1, 0, "4");
        Vector v5 = new Vector(-1, 1, "5");
        Vector v6 = new Vector(0, 1, "6");
        Vector v7 = new Vector(1, 1, "7");

        octagon = new ArrayList<>();
        octagon.add(v0);
        octagon.add(v1);
        octagon.add(v2);
        octagon.add(v3);
        octagon.add(v4);
        octagon.add(v5);
        octagon.add(v6);
        octagon.add(v7);

        notAPolygon = new ArrayList<>();
        notAPolygon.add(v1);
        notAPolygon.add(v0);
        notAPolygon.add(v7);
        notAPolygon.add(v5);
        notAPolygon.add(new Vector(-2.0, -2.0, "8"));
    }

    @Test(expected = NotAPolygonException.class)
    public void notAPolygonTest() throws NotAPolygonException {
        Polygon polygon = new Polygon(notAPolygon);
    }

    @Test
    public void areaCalculationTest(){
        Polygon polygon = null;
        try {
            polygon = new Polygon(octagon);
        } catch (NotAPolygonException e) {
            e.printStackTrace();
        }
        if (polygon != null) {
            TestCase.assertEquals(polygon.calculateArea(), AREA);
        } else {
            TestCase.fail();
        }

    }
}
