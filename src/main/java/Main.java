import config.LoggerConfig;
import model.Vector;
import utils.VectorGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LoggerConfig.init();

	// write your code here

//        List<Vector> list1 = new ArrayList<>();
//        Vector vector1 = new Vector(1, 0, "a");
//        Vector vector2 = new Vector(1, 1, "b");
//        Vector vector3 = new Vector(0, 1, "c");
//        Vector vector4 = new Vector(-1, 1, "d");
//        Vector vector5 = new Vector(-1, 0, "e");
//        Vector vector6 = new Vector(-1, -1, "f");
//        Vector vector7 = new Vector(0, -1, "g");
//        Vector vector8 = new Vector(1, -1, "h");
//
//        System.out.println(Math.toDegrees(vector1.getxAngle()) + ":" + Math.toDegrees(vector1.getyAngle1()));
//        System.out.println(Math.toDegrees(vector2.getxAngle()) + ":" + Math.toDegrees(vector2.getyAngle1()));
//        System.out.println(Math.toDegrees(vector3.getxAngle()) + ":" + Math.toDegrees(vector3.getyAngle1()));
//        System.out.println(Math.toDegrees(vector4.getxAngle()) + ":" + Math.toDegrees(vector4.getyAngle1()));
//        System.out.println(Math.toDegrees(vector5.getxAngle()) + ":" + Math.toDegrees(vector5.getyAngle1()));
//        System.out.println(Math.toDegrees(vector6.getxAngle()) + ":" + Math.toDegrees(vector6.getyAngle1()));
//        System.out.println(Math.toDegrees(vector7.getxAngle()) + ":" + Math.toDegrees(vector7.getyAngle1()));
//        System.out.println(Math.toDegrees(vector8.getxAngle()) + ":" + Math.toDegrees(vector8.getyAngle1()));
//
//        list1.add(vector2);
//        list1.add(vector4);
//        list1.add(vector5);
//        list1.add(vector6);
//        list1.add(vector7);
//        list1.add(vector3);
//        list1.add(vector8);
//        list1.add(vector1);

//        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(list1);
//        System.out.println("X ascending:");
//        sortByAngleAlgorithm.sort(true,true,0, list1.size()-1);
//        for (int i = 0; i < list1.size(); i++){
//            System.out.println(sortByAngleAlgorithm.getVectorList().get(i).getName() + " " +
//                    Math.toDegrees(sortByAngleAlgorithm.getVectorList().get(i).getxAngle()));
//        }
//        System.out.println("X descending:");
//        sortByAngleAlgorithm.sort(false,true,0, list1.size()-1);
//        for (int i = 0; i < list1.size(); i++){
//            System.out.println(sortByAngleAlgorithm.getVectorList().get(i).getName() + " " +
//                    Math.toDegrees(sortByAngleAlgorithm.getVectorList().get(i).getxAngle()));
//        }
//        System.out.println("Y ascending:");
//        sortByAngleAlgorithm.sort(true,false,0, list1.size()-1);
//        for (int i = 0; i < list1.size(); i++){
//            System.out.println(sortByAngleAlgorithm.getVectorList().get(i).getName() + " " +
//                    Math.toDegrees(sortByAngleAlgorithm.getVectorList().get(i).getyAngle1()));
//        }
//        System.out.println("y descending:");
//        sortByAngleAlgorithm.sort(false,false,0, list1.size()-1);
//        for (int i = 0; i < list1.size(); i++){
//            System.out.println(sortByAngleAlgorithm.getVectorList().get(i).getName() + " " +
//                    Math.toDegrees(sortByAngleAlgorithm.getVectorList().get(i).getyAngle1()));
//        }


//        model.LineSegment lineSegment1 = new model.LineSegment(0, 0, 1, 1);
//        model.LineSegment lineSegment2 = new model.LineSegment(1,1,2,0);
//        System.out.println(utils.LineCrossingDetector.isCrossingDetected(lineSegment1, lineSegment2));
//
        List<Vector> vectors = new ArrayList<>();

        vectors.add(new Vector(1,1, "A"));
        vectors.add(new Vector(1,0, "B"));
        vectors.add(new Vector(1,-1, "C"));
        vectors.add(new Vector(-1, -1, "D"));
        vectors.add(new Vector(-1, 0, "E"));
        vectors.add(new Vector(-1, -1, "F"));


        PermutationAlgorithm permutationAlgorithm = new PermutationAlgorithm(vectors);
        permutationAlgorithm.findBestPermutation();

        SortByAngleAlgorithm sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors);
        List<Vector> bestOrder = sortByAngleAlgorithm.findBestOrder();
        System.out.println("Best order: ");
        for (int i = 0; i < vectors.size(); i++){
            System.out.print(bestOrder.get(i).getName() + " ");
        }
        System.out.println(sortByAngleAlgorithm.getMaxArea());
        System.out.println();
//
        List<Vector> vectors2 = new ArrayList<>();

        vectors2.add(new Vector(1,1, "A"));
        vectors2.add(new Vector(1,0, "B"));
        vectors2.add(new Vector(1,-1, "C"));
        vectors2.add(new Vector(-1, -1, "D"));
        vectors2.add(new Vector(-1, 0, "E"));
        vectors2.add(new Vector(-1, 1, "F"));


        permutationAlgorithm = new PermutationAlgorithm(vectors2);
        permutationAlgorithm.findBestPermutation();

        sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors2);
        List<Vector> bestOrder2 = sortByAngleAlgorithm.findBestOrder();
        System.out.println("Best order: ");
        for (int i = 0; i < vectors2.size(); i++){
            System.out.print(bestOrder2.get(i).getName() + " ");
        }
        System.out.println(sortByAngleAlgorithm.getMaxArea());

        System.out.println("Acceptable permutations: ");
        List<List<Vector>> acceptable1 = permutationAlgorithm.acceptablePermutations;
        for (int i = 0; i < acceptable1.size(); i++){
            System.out.print(i + " - ");
            for (int j = 0; j < bestOrder2.size(); j++){
                System.out.print(acceptable1.get(i).get(j).getName() + " ");
            }
            System.out.println();
        }
//
//        List<Vector> vectors3 = new ArrayList<>();
//
//        vectors3.add(new Vector(2,2, "A"));
//        vectors3.add(new Vector(2,0, "B"));
//        vectors3.add(new Vector(2,-2, "C"));
//        vectors3.add(new Vector(-2, -2, "D"));
//        vectors3.add(new Vector(-2, 0, "E"));
//        vectors3.add(new Vector(-2, -2, "F"));
//
//
//        permutationAlgorithm = new PermutationAlgorithm(vectors3);
//        permutationAlgorithm.initPermutationList();
//        permutationAlgorithm.findBestPermutation();
//
//        sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors3);
//        List<Vector> bestOrder3 = sortByAngleAlgorithm.findBestOrder();
//        System.out.println("Best order: ");
//        for (int i = 0; i < vectors3.size(); i++){
//            System.out.print(bestOrder3.get(i).getName() + " ");
//        }
//        System.out.println(sortByAngleAlgorithm.getMaxArea());



        VectorGenerator generator = new VectorGenerator(8);
        ArrayList<Vector> vectors4 = generator.generateList();

        for (int i = 0; i < vectors4.size(); i++){
            System.out.println(vectors4.get(i).getName() + " " + vectors4.get(i).getxSteps() + " "
                    + vectors4.get(i).getySteps() + " " + vectors4.get(i).getxAngle());
        }

        permutationAlgorithm = new PermutationAlgorithm(vectors4);
        permutationAlgorithm.findBestPermutation();
        System.out.println("Best permutation: ");
        for (int i = 0; i < permutationAlgorithm.getBestPermutation().size(); i++){
            System.out.print(permutationAlgorithm.getBestPermutation().get(i).getName() + " ");
        }
        System.out.println(permutationAlgorithm.getMaxArea());

        sortByAngleAlgorithm = new SortByAngleAlgorithm(vectors4);
        List<Vector> bestOrder4 = sortByAngleAlgorithm.findBestOrder();
        System.out.println("Best order: ");
        for (int i = 0; i < bestOrder4.size(); i++){
            System.out.print(bestOrder4.get(i).getName() + " ");
        }
        System.out.println(sortByAngleAlgorithm.getMaxArea());

        System.out.println("Acceptable permutations: ");
        List<List<Vector>> acceptable = permutationAlgorithm.acceptablePermutations;
        for (int i = 0; i < acceptable.size(); i++){
            System.out.print(i + " - ");
            for (int j = 0; j < bestOrder4.size(); j++){
                System.out.print(acceptable.get(i).get(j).getName() + " ");
            }
            System.out.println();
        }

        generator.generateToFile("res\\s.txt");


    }
}
