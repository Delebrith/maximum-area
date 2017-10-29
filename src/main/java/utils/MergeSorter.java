package utils;

import model.Vector;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter {

    private static List<Vector> vectorList;

    public enum Sorting{X1, Y1}

    public MergeSorter(List<Vector> vectorList) {
        this.vectorList = vectorList;
    }

    /**
     *
     * @param direction ascending = 0; descending = 1;
     * @param sortingMode
     * @param firstIndex
     * @param lastIndex
     */
    public static void sort(boolean direction, Sorting sortingMode, int firstIndex, int lastIndex){
        if (firstIndex < lastIndex){
            int middleIndex = (firstIndex + lastIndex) /2;
            sort(direction, sortingMode, firstIndex, middleIndex);
            sort(direction, sortingMode, middleIndex + 1, lastIndex);
            if (sortingMode == Sorting.X1){
                mergeX1(direction, firstIndex, middleIndex, lastIndex);
            } else {
                mergeY1(direction, firstIndex, middleIndex, lastIndex);
            }
        }
    }

    private static void mergeX1(boolean direction, int firstIndex, int middleIndex, int lastIndex){
        ArrayList<Vector> tmpList = new ArrayList<>(vectorList);
        int i = firstIndex;
        int j = middleIndex + 1;
        int k = firstIndex;
        if (direction){
            while (i <= middleIndex && j <= lastIndex){
                if (tmpList.get(i).getxAngle1() < tmpList.get(j).getxAngle1()){
                    vectorList.set(k++, tmpList.get(i++));
                } else {
                    vectorList.set(k++, tmpList.get(j++));
                }
            }
            while (i <= middleIndex){
                vectorList.set(k++, tmpList.get(i++));
            }
        } else {
            while (i <= middleIndex && j <= lastIndex){
                if (tmpList.get(i).getxAngle1() > tmpList.get(j).getxAngle1()){
                    vectorList.set(k++, tmpList.get(i++));
                } else {
                    vectorList.set(k++, tmpList.get(j++));
                }
            }
            while (i <= middleIndex){
                vectorList.set(k++, tmpList.get(i++));
            }
        }
    }

    private static void mergeY1(boolean direction, int firstIndex, int middleIndex, int lastIndex){
        ArrayList<Vector> tmpList = new ArrayList<>(vectorList);
        int i = firstIndex;
        int j = middleIndex + 1;
        int k = firstIndex;
        if (direction){
            while (i <= middleIndex && j <= lastIndex){
                if (tmpList.get(i).getyAngle1() < tmpList.get(j).getyAngle1()){
                    vectorList.set(k++, tmpList.get(i++));
                } else {
                    vectorList.set(k++, tmpList.get(j++));
                }
            }
            while (i <= middleIndex){
                vectorList.set(k++, tmpList.get(i++));
            }
        } else {
            while (i <= middleIndex && j <= lastIndex){
                if (tmpList.get(i).getyAngle1() > tmpList.get(j).getyAngle1()){
                    vectorList.set(k++, tmpList.get(i++));
                } else {
                    vectorList.set(k++, tmpList.get(j++));
                }
            }
            while (i <= middleIndex){
                vectorList.set(k++, tmpList.get(i++));
            }
        }
    }
}
