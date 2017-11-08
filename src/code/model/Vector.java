package code.model;

public class Vector {

    private double xStart = 0;
    private double yStart = 0;
    private double xSteps;
    private double ySteps;
    private double xAngle;

    //for testing
    private String name;

    public Vector(double xSteps, double ySteps, String name) {
        this.xSteps = xSteps;
        this.ySteps = ySteps;
        this.setxAngle();
        this.name = name;
    }

    public double getxStart() {
        return xStart;
    }

    public double getyStart() {
        return yStart;
    }

    public double getxSteps() {
        return xSteps;
    }

    public double getySteps() {
        return ySteps;
    }

    public double getxAngle() {
        return xAngle;
    }

    public String getName() {
        return name;
    }

    public void setxStart(double xStart) {
        this.xStart = xStart;
    }

    public void setyStart(double yStart) {
        this.yStart = yStart;
    }

    private void setxAngle() {
        if (ySteps < 0 || (ySteps == 0 && xSteps >= 0)) {
            this.xAngle = 2 * Math.PI + Math.atan2(ySteps, xSteps);
        } else {
            this.xAngle = Math.atan2(ySteps, xSteps);
        }
        this.xAngle = Math.toDegrees(this.xAngle);
    }

}
