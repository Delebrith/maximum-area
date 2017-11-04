package ui;

import core.VectorGenerator;
import exceptions.NotAPolygonException;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Polygon;
import model.Vector;
import model.Vertex;
import solution.PermutationAlgorithm;
import solution.SortByAngleAlgorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Content extends Scene {

    private final int PIXELS_PER_UNIT = 10;

    private Button generateButton;
    private Button permutationsButton;
    private Button sortButton;
    private Button clearButton;

    private Image plane;
    private ImageView planeView;
    private Label numberOfVectors;
    private TextField numberOfVectorsInput;
    private Label randomVectors;
    private int amountOfVectors = 0;
    private ArrayList<javafx.scene.shape.Polygon> permutationPolygons;
    private javafx.scene.shape.Polygon orderPolygon;

    private UIManager manager;

    private ArrayList<Vector> vectors;


    public Content(Group root, double width, double height, Paint fill, UIManager manager) {
        super(root, width, height, fill);
        this.manager = manager;
        generateButton = new Button("Generate vectors");
        permutationsButton = new Button("Draw acceptable permutations");
        sortButton = new Button("Draw best order");
        clearButton = new Button("CLEAR");
        plane = new Image(new File("src/main/res/plane.png").toURI().toString());
        planeView = new ImageView(plane);
        numberOfVectors = new Label("Number of vectors: ");
        numberOfVectorsInput = new TextField();
        randomVectors = new Label();
    }

    public void draw(){
        preparePlaneView();
        prepareInput();
        prepareButtons();
        ((Group)this.getRoot()).getChildren().addAll(planeView, numberOfVectors, numberOfVectorsInput,
                generateButton, permutationsButton, sortButton);
    }

    private void preparePlaneView(){
        planeView.setX(0.0);
        planeView.setX(0.0);
    }

    private void prepareInput(){
        numberOfVectors.setLayoutX(1050);
        numberOfVectors.setLayoutY(30);
        numberOfVectors.setFont(Font.font(16));
        numberOfVectorsInput.setLayoutX(1220);
        numberOfVectorsInput.setLayoutY(25);
        numberOfVectorsInput.setText("0");
    }

    private void prepareButtons(){
        generateButton.setLayoutX(1170);
        generateButton.setLayoutY(70);
        generateButton.setFont(Font.font(16));
        generateButton.setMinWidth(150);
        generateButton.setAlignment(Pos.CENTER);

        generateButton.setOnMouseClicked((event) -> {
            prepareVectors();
            ((Group)getRoot()).getChildren().add(randomVectors);
        });

        permutationsButton.setLayoutX(1110);
        permutationsButton.setLayoutY(800);
        permutationsButton.setFont(Font.font(16));
        permutationsButton.setMinWidth(150);
        permutationsButton.setAlignment(Pos.CENTER);
        permutationsButton.setOnMouseClicked((event) -> {
            drawAcceptablePolygons();
        });

        sortButton.setLayoutX(1170);
        sortButton.setLayoutY(840);
        sortButton.setFont(Font.font(16));
        sortButton.setMinWidth(150);
        sortButton.setAlignment(Pos.CENTER);
        sortButton.setOnMouseClicked((event) -> {
            drawBestOrder();
        });

    }

    private void prepareVectors(){
        amountOfVectors = Integer.parseInt(String.valueOf(numberOfVectorsInput.getCharacters()));
        manager.setVectorGenerator(new VectorGenerator(amountOfVectors));
        vectors = manager.getVectorGenerator().generateList();

        StringBuilder builder = new StringBuilder();
        builder.append("Vectors: \n\n\n");
        for (Vector vector : vectors){
            builder.append(vector.getxSteps() + "\t\t" + vector.getySteps() + "\n");
        }
        randomVectors.setFont(Font.font(15));
        randomVectors.setTextAlignment(TextAlignment.CENTER);
        randomVectors.setText(builder.toString());
        randomVectors.setLayoutX(1050);
        randomVectors.setLayoutY(120);
    }

    private void drawAcceptablePolygons(){
        permutationPolygons = new ArrayList<>();
        manager.setPermutationAlgorithm(new PermutationAlgorithm(vectors));
        manager.getPermutationAlgorithm().findBestPermutation();
        ArrayList<ArrayList<Vector>> acceptable =
                (ArrayList)manager.getPermutationAlgorithm().getAcceptablePermutations();
        for (ArrayList list : acceptable){
            Polygon polygon = null;
            try {
                polygon = new Polygon(list);
            } catch (NotAPolygonException e) {
                e.printStackTrace();
            }
            javafx.scene.shape.Polygon drawnPolygon = new javafx.scene.shape.Polygon();
            for (Vertex vertex : polygon.getVertices()){
                drawnPolygon.getPoints().add(vertex.getX() * PIXELS_PER_UNIT + 500);
                drawnPolygon.getPoints().add(vertex.getY() * PIXELS_PER_UNIT + 500);
            }
            permutationPolygons.add(drawnPolygon);
        }
        for (javafx.scene.shape.Polygon polygon : permutationPolygons){

            polygon.fillProperty().setValue((Paint)new Color(
                    ThreadLocalRandom.current().nextDouble(),
                    ThreadLocalRandom.current().nextDouble(),
                    ThreadLocalRandom.current().nextDouble(),
                    0.4
            ));
            ((Group)getRoot()).getChildren().add(polygon);
        }

    }

    private void drawBestOrder(){
        manager.setSortByAngleAlgorithm(new SortByAngleAlgorithm(vectors));
        manager.getSortByAngleAlgorithm().findBestOrder();
        ArrayList<Vector> bestOrder = (ArrayList) manager.getSortByAngleAlgorithm().getBestOrder();
        try {
            Polygon polygon = new Polygon(bestOrder);
            orderPolygon = new javafx.scene.shape.Polygon();
            for (Vertex vertex : polygon.getVertices()){
                orderPolygon.getPoints().add(vertex.getX()*PIXELS_PER_UNIT + 500);
                orderPolygon.getPoints().add(vertex.getY()*PIXELS_PER_UNIT + 500);
            }
            orderPolygon.fillProperty().setValue((Paint)new Color(
                    ThreadLocalRandom.current().nextDouble(),
                    ThreadLocalRandom.current().nextDouble(),
                    ThreadLocalRandom.current().nextDouble(),
                    0.8
            ));
            ((Group)getRoot()).getChildren().add(orderPolygon);
        } catch (NotAPolygonException e) {
            e.printStackTrace();
        }
    }


}
