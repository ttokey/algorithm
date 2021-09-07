package leetcode.personal;


import java.util.LinkedList;
import java.util.List;

public class CalculateSum {
    public int[] calculateSum(int[] arr1, int[] arr2) {
        int sumArr1 = getNum(arr1);
        int sumArr2 = getNum(arr2);
        int sum = sumArr1 + sumArr2;
        List<Integer> list = new LinkedList<>();
        while (sum > 0) {
            list.add(0, sum % 10);
            sum /= 10;
        }
        
        return list.stream().mapToInt(num -> num.intValue()).toArray();
    }

    public int getNum(int[] arr) {
        int j = 1;
        int sumArr = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sumArr += arr[i] * j;
            j *= 10;
        }
        return sumArr;
    }

}
