package programmers.practice;
//https://programmers.co.kr/learn/courses/30/lessons/72411


//orders	course	result
//["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]

//손님 번호 주문한 단품메뉴 조합
//1번 손님 A,B,C,F,G
//2번 손님 A,C
//3번 손님 C,D,E
//4번 손님 A,C,D,E
//5번 손님 B,C,F,G
//6번 손님 A,C,D,E,H
//가장 많이 함께 주문된 단품메뉴 조합에 따라"스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

//코스 종류 메뉴 구성 설명
//요리 2개 코스 A,C 1번,2번,4번,6번 손님으로부터 총 4번 주문됐습니다.
//요리 3개 코스 C,D,E 3번,4번,6번 손님으로부터 총 3번 주문됐습니다.
//요리 4개 코스 B,C,F,G 1번,5번 손님으로부터 총 2번 주문됐습니다.
//요리 4개 코스 A,C,D,E 4번,6번 손님으로부터 총 2번 주문됐습니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RenewalMenu {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            List<String> manyOrder = getManyOrder(getMap(orders, course[i]));
            if (!manyOrder.isEmpty()) {
                result.addAll(manyOrder);
            }
        }
        result.sort(Comparator.naturalOrder());
        return result.toArray(new String[0]);
    }

    public List<String> getManyOrder(Map<String, Integer> orderMap) {
        List<String> result = new ArrayList<>();
        if (orderMap.isEmpty()) {
            return result;
        }
        int maxCount = Math.max(orderMap.values().stream().max(Comparator.naturalOrder()).get(), 2);

        for (String key : orderMap.keySet()) {
            if (orderMap.get(key) == maxCount) {
                result.add(key);
            }
        }
        return result;
    }

    public Map<String, Integer> getMap(String[] orders, int index) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            List<String> orderGroup = getString(orders[i], index);
            for (String order : orderGroup) {
                result.merge(order, 1, (v1, v2) -> v1 + 1);
            }
        }
        return result;
    }

    public List<String> getString(String input, int index) {
        char[] parseInput = input.toCharArray();
        Arrays.sort(parseInput);
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            q.add(new Node(parseInput[i], i));
        }

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            for (int i = nowNode.lastIndex + 1; i < input.length(); i++) {
                if (i < input.length()) {
                    Node newNode = nowNode.addMenu(parseInput[i], i);
                    if (newNode.getMenu().length() == index) {
                        result.add(newNode.getMenu());
                    } else {
                        q.add(newNode);
                    }
                }
            }
        }
        return result;
    }

    public class Node {
        private String menu;
        private Integer lastIndex;

        public Node(String menu, Integer lastIndex) {
            this.menu = menu;
            this.lastIndex = lastIndex;
        }

        public Node(char menu, Integer lastIndex) {
            this.menu = String.valueOf(menu);
            this.lastIndex = lastIndex;
        }

        public Integer getLastIndex() {
            return lastIndex;
        }

        public String getMenu() {
            return menu;
        }

        public Integer length() {
            return this.menu.length();
        }

        public Node addMenu(char c, int lastIndex) {
            Node newNode = new Node(this.menu, this.lastIndex);
            newNode.menu = this.menu.concat(String.valueOf(c));
            newNode.lastIndex = lastIndex;
            return newNode;
        }
    }
}
