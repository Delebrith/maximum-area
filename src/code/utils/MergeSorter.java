package code.utils;


import code.model.Vector;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter {

    private List<Vector> vectorList;

    public MergeSorter(List<Vector> vectorList) {
        this.vectorList = vectorList;
    }

    public List<Vector> getVectorList() {
        return vectorList;
    }

    /**
     *
     * @param direction ascending = true; descending = false;
     * @param firstIndex
     * @param lastIndex
     */
    public void sort(boolean direction, int firstIndex, int lastIndex){
        if (firstIndex < lastIndex){
            int middleIndex = (firstIndex + lastIndex) /2;
            sort(direction, firstIndex, middleIndex);
            sort(direction, middleIndex + 1, lastIndex);
            merge(direction, firstIndex, middleIndex, lastIndex);
        }
    }

    private void merge(boolean direction, int firstIndex, int middleIndex, int lastIndex){
        ArrayList<Vector> tmpList = new ArrayList<>(vectorList);
        int i = firstIndex;
        int j = middleIndex + 1;
        int k = firstIndex;
        if (direction){
            while (i <= middleIndex && j <= lastIndex){
                if (tmpList.get(i).getxAngle() < tmpList.get(j).getxAngle()){
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
                if (tmpList.get(i).getxAngle() > tmpList.get(j).getxAngle()){
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
