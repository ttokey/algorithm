package programmers.practice;

import java.util.HashSet;
import java.util.Set;

public class RollCake_132265 {


    public int solution(int[] topping) {
        int count = 0;
        int[] leftToppingSet = new int[topping.length];
        int[] rightToppingSet = new int[topping.length];
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            leftSet.add(topping[i]);
            rightSet.add(topping[topping.length - i - 1]);
            leftToppingSet[i] = leftSet.size();
            rightToppingSet[topping.length - i - 1] = rightSet.size();
        }
        for (int i = 0; i < topping.length - 1; i++) {
            if (leftToppingSet[i] == rightToppingSet[i + 1]) {
                count++;
            }
        }
        return count;
    }

    public int solution2(int[] topping) {
        int answer = -1;

        if (topping.length == 1) {
            return 0;
        }

        Set<Integer> old = new HashSet<>();
        Set<Integer> young = new HashSet<>();
        int maxSize = 0;
        int oldIdx = -1;
        int youngIdx = topping.length;
        int oldTarget = -1;
        int youngTarget = topping.length;
        while (oldIdx < youngIdx) {


            if (old.size() == young.size()) {
                old.add(topping[++oldIdx]);
                young.add(topping[--youngIdx]);

            } else if (old.size() > young.size()) {
                young.add(topping[--youngIdx]);
            } else {
                old.add(topping[++oldIdx]);
            }

            if (old.size() == young.size() && maxSize < old.size()) {
                if (oldTarget < oldIdx) {
                    oldTarget = oldIdx;
                }
                if (youngTarget > youngIdx) {
                    youngTarget = youngIdx;
                }

                maxSize = old.size();
            }
        }


        if (old.size() != young.size()) {
            return 0;
        }

        answer = Math.abs(oldTarget - youngTarget);

        return answer;

    }


}

//public class RollCake_132265 {
//    int count = 0;
//    int[] leftToppingSet;
//    int[] rightToppingSet;
//
//    public int solution(int[] topping) {
//        int[] leftToppingSet = new int[topping.length];
//        int[] rightToppingSet = new int[topping.length];
//        Set<Integer> leftSet = new HashSet<>();
//        Set<Integer> rightSet = new HashSet<>();
//        for (int i = 0; i < topping.length; i++) {
//            leftSet.add(topping[i]);
//            rightSet.add(topping[topping.length - i - 1]);
//            leftToppingSet[i] = leftSet.size();
//            rightToppingSet[topping.length - i - 1] = rightSet.size();
//        }
//        for (int i = 0; i < topping.length - 1; i++) {
//            if (leftToppingSet[i] == rightToppingSet[i + 1]) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//
//    public void isSame(int left, int right) {
//        if (left > right) {
//            return;
//        }
//        int middle = (left + right) / 2;
//        if (leftToppingSet[middle] == rightToppingSet[middle + 1]) {
//            count++;
//            isSame(left, middle - 1);
//            isSame(middle + 1, right);
//        } else if (leftToppingSet[middle] > rightToppingSet[middle + 1]) {
//            isSame(left, middle - 1);
//        } else if (leftToppingSet[middle] < rightToppingSet[middle + 1]) {
//            isSame(middle + 1, right);
//        }
//    }
//}