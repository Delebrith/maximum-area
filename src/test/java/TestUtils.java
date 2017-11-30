import solutions.PermutationAlgorithm;
import solutions.SortByAngleAlgorithm;

import java.util.ArrayList;

public class TestUtils {

    public static boolean contains(PermutationAlgorithm permutationAlgorithm,
                             SortByAngleAlgorithm sortByAngleAlgorithm){
        boolean contains = false;
        ArrayList<String> acceptableResults = new ArrayList<>();

        for (int i = 0; i < permutationAlgorithm.getAcceptablePermutations().size(); i++){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < sortByAngleAlgorithm.getBestOrder().size(); j++){
                builder.append(sortByAngleAlgorithm.getBestOrder().get(j).getName()).append(" ");
            }
            acceptableResults.add(builder.toString());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sortByAngleAlgorithm.getBestOrder().size(); i++){
            builder.append(sortByAngleAlgorithm.getBestOrder().get(i).getName()).append(" ");
        }
        String sortResult = builder.toString();

        for (String result : acceptableResults){
            if (result.equals(sortResult)) contains = true;
        }
        return contains;
    }

}
