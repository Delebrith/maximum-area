package code.model;

public class LineSegment {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    //straight line equation
    private double a;
    private double b;

    public LineSegment(double xStart, double yStart, double xEnd, double yEnd) {
        this.x1 = xStart < xEnd ? xStart : xEnd;
        this.y1 = this.x1 == xStart ? yStart : yEnd;
        this.x2 = xStart > xEnd ? xStart : xEnd;
        this.y2 = this.x2 == xStart ? yStart : yEnd;
        calculateStraightLine();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    private void calculateStraightLine(){
        a = (y2 - y1) / (x2 - x1);
        b = y1 - a * x1;
    }


    public boolean includesPoint(double x, double y) {
        if ( y != a*x + b) return false;
        if (x < x1 || x > x2) return false;
        if (a > 0){
            if (y < y1 || y > y2) return false;
        } else {
            if (y > y1 || y < y2) return false;
        }

        return true;
    }
}
