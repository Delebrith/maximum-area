package code.model;


import code.utils.LineCrossingDetector;
import code.exceptions.NotAPolygonException;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private List<Vertex> vertices = new ArrayList<>();

    public Polygon(List<Vector> vectors) throws NotAPolygonException {
        int notAddedVertices = 0;
        vertices.add(new Vertex(0,0));

        for (int i = 0; i < vectors.size(); i++) {
            if (i != 0){
                vectors.get(i).setxStart(vectors.get(i-1).getxStart() + vectors.get(i-1).getxSteps());
                vectors.get(i).setyStart(vectors.get(i-1).getyStart() + vectors.get(i-1).getySteps());
            }

            if (vertices.size() > 2) {
                LineSegment addedLineSegment = new LineSegment(vectors.get(i).getxStart(), vectors.get(i).getyStart(),
                        vectors.get(i).getxStart() + vectors.get(i).getxSteps(),
                        vectors.get(i).getyStart() + vectors.get(i).getySteps());
                for (int j = 0; j < (vertices.size()-2); j++) {

                    LineSegment lineSegment = new LineSegment(vertices.get(j).getX(), vertices.get(j).getY(),
                            vertices.get(j + 1).getX(), vertices.get(j + 1).getY());
                    Vertex crossingPoint = LineCrossingDetector.detectCrossing(lineSegment, addedLineSegment);

                    if (LineCrossingDetector.isCrossingDetected(lineSegment, addedLineSegment)) {
                        if (j == 0 && i == vectors.size()-1 && crossingPoint.getY() == 0 &&
                                crossingPoint.getY() == 0) {
                            break;
                        } else {
                            throw new NotAPolygonException();
                        }
                    }
                }
            }

            vertices.add(new Vertex(vertices.get(i-notAddedVertices).getX() + vectors.get(i).getxSteps(),
                    vertices.get(i-notAddedVertices).getY() + vectors.get(i).getySteps()));
        }
    }

    public double calculateArea(){
        double area = 0;
        for (int i = 0; i < vertices.size() - 1; i++){
            area += (vertices.get(i).getX() * vertices.get(i+1).getY());
        }
        area += (vertices.get(vertices.size()-1).getX() * vertices.get(0).getY());

        for (int i = 0; i < vertices.size() - 1; i++){
            area -= (vertices.get(i+1).getX() * vertices.get(i).getY());
        }
        area -= (vertices.get(0).getX() * vertices.get(vertices.size()-1).getY());

        return (Math.abs(area)/2);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}
