package model;

public class Vector {

    private double xStart = 0;
    private double yStart = 0;
    private double xSteps;
    private double ySteps;
    private double xAngle1;
    private double yAngle1;

    //tmp
    private String name;

    public Vector(double xSteps, double ySteps, String name) {
        this.xSteps = xSteps;
        this.ySteps = ySteps;
        this.setxAngle();
        this.setyAngle();
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

    public double getxAngle1() {
        return xAngle1;
    }

    public double getyAngle1() {
        return yAngle1;
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
            this.xAngle1 = 2 * Math.PI + Math.atan2(ySteps, xSteps);
        } else {
            this.xAngle1 = Math.atan2(ySteps, xSteps);
        }
        this.xAngle1 = Math.toDegrees(this.xAngle1);
    }

    private void setyAngle() {
        if (xSteps < 0 || (xSteps == 0 && ySteps >= 0)) {
            this.yAngle1 = 2 * Math.PI + Math.atan2(xSteps, ySteps);
        } else {
            this.yAngle1 = Math.atan2(xSteps, ySteps);
        }
        this.yAngle1 = Math.toDegrees(this.yAngle1);
    }

}
