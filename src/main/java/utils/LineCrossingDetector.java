package utils;

import model.LineSegment;
import model.Vertex;

public class LineCrossingDetector {

    public static boolean isCrossingDetected(LineSegment lineSegment1, LineSegment lineSegment2){

        Vertex crossingPoint = detectCrossing(lineSegment1, lineSegment2);
        if (crossingPoint == null) return false;

        if (lineSegment1.includesPoint(crossingPoint.getX(), crossingPoint.getY()) &&
                lineSegment2.includesPoint(crossingPoint.getX(), crossingPoint.getY())){
            return true;
        } else {
            return false;
        }
    }

    public static Vertex detectCrossing(LineSegment lineSegment1, LineSegment lineSegment2){
        // b1 = y - a1*x
        // b2 = y - a2*x
        // det = 1*(-a2) - (-a1 * 1))
        // detY = b1*(-a2) - (-a1*b2)
        // detX = 1*b2 - b1*1
        double det = -lineSegment2.getA() + lineSegment1.getA();

        if (det == 0) return null;

        double detX = lineSegment2.getB() - lineSegment1.getB();
        double detY = -lineSegment2.getA() * lineSegment1.getB() + lineSegment1.getA() * lineSegment2.getB();
        double crossingX = detX / det;
        double crossingY = detY / det;

        return new Vertex(crossingX, crossingY);
    }

}
