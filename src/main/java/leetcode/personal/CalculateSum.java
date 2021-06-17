package leetcode.personal;
/*
input으로 두개의 배열이 주어집니다.
        두 배열을 sum 한 값의 결과를 반환하도록 하세요.
        example 1.
        input [1,2,3],[3,4,5]
        output [4,6,8]
        example 2.
        input [1,4,0,9],[2,9,1]
        output [1,7,0,0]
        example 3.
        input [9,0,4,1],[9,9,9]
        output [1,0,0,4,0]

 */

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
