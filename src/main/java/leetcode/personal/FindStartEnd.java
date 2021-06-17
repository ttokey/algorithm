package leetcode.personal;

import java.util.List;

/*
정렬된 List와 target이 주어집니다.
정렬된 List중에서 target의 startInde, endIndex위치를 찾아 반환하세요.
    example 1.
    input [1,2,5,8,8,8,8,8,8,9,10],8
    output [3,8]

    example 2.
    input [1,4,5,6,9,11,12],5
    output [2,2]

    example 3.
    input [],8
    output [-1,-1]

    example 4.
    input [1,2,3,4],5
    output [-1,-1]

시간복잡도는 O(logN) 에 대한 제약
 */
public class FindStartEnd {
    int startIndex = -1;
    int endIndex = -1;

    public int[] findStartEnd(List<Integer> arr, int target) {
        int[] result = new int[2];
        if (arr.size() != 0) {
            findStart(arr, target, 0, arr.size() - 1);
            findEnd(arr, target, 0, arr.size() - 1);
        }
        result[0] = startIndex;
        result[1] = endIndex;
        return result;
    }

    public void findStart(List<Integer> arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (arr.get(mid) == target) {
            if (mid - 1 >= 0) {
                if (arr.get(mid - 1) != target) {
                    startIndex = mid;
                } else {
                    findStart(arr, target, start, mid - 1);
                }
            }
        } else if (arr.get(mid) < target) {
            if (mid + 1 < arr.size()) {
                findStart(arr, target, mid + 1, end);
            }
        } else {
            if (mid - 1 >= 0) {
                findStart(arr, target, start, mid - 1);
            }
        }
    }

    public void findEnd(List<Integer> arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (arr.get(mid) == target) {
            if (mid + 1 < arr.size()) {
                if (arr.get(mid + 1) != target) {
                    endIndex = mid;
                } else {
                    findEnd(arr, target, mid + 1, end);
                }
            }
        } else if (arr.get(mid) > target) {
            if (mid - 1 >= 0) {
                findEnd(arr, target, start, mid - 1);
            }
        } else {
            if (mid + 1 < arr.size()) {
                findEnd(arr, target, mid + 1, end);
            }
        }
    }
}
