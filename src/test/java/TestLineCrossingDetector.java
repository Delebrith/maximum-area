import junit.framework.TestCase;
import model.LineSegment;
import org.junit.Before;
import org.junit.Test;
import utils.LineCrossingDetector;

public class TestLineCrossingDetector {

    LineSegment lineSegment1;
    LineSegment lineSegment2;
    LineSegment lineSegment3;
    LineSegment lineSegment4;

    @Before
    public void init(){
        lineSegment1 = new LineSegment(0, 0, 4, 4);
        lineSegment2 = new LineSegment(4, 0, 0, 4);
        lineSegment3 = new LineSegment(8, 0, 4, 4);
        lineSegment4 = new LineSegment(12, 0, 8, 4);
    }

    @Test
    public void crossingDetectedInTheMiddleTest(){
        TestCase.assertTrue(LineCrossingDetector.isCrossingDetected(lineSegment1, lineSegment2));

        TestCase.assertEquals(LineCrossingDetector.detectCrossing(lineSegment1, lineSegment2).getX(), 2.0);
        TestCase.assertEquals(LineCrossingDetector.detectCrossing(lineSegment1, lineSegment2).getY(), 2.0);
    }

    @Test
    public void crossingDetectedInTheEndsTest(){
        TestCase.assertTrue(LineCrossingDetector.isCrossingDetected(lineSegment1, lineSegment3));

        TestCase.assertEquals(LineCrossingDetector.detectCrossing(lineSegment1, lineSegment3).getX(), 4.0);
        TestCase.assertEquals(LineCrossingDetector.detectCrossing(lineSegment1, lineSegment3).getY(), 4.0);
    }

    @Test
    public void crossingNotDetectedTest(){
        TestCase.assertFalse(LineCrossingDetector.isCrossingDetected(lineSegment1, lineSegment4));
    }
}
