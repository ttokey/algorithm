package programmers.practice.lv1;

import java.util.LinkedList;

public class MakeHamburger_133502 {
    public int solution(int[] ingredient) {
        LinkedList<Integer> ingredientLinkedList = new LinkedList<>();
        int count = 0;
        for (int input : ingredient) {
            ingredientLinkedList.add(input);
            while (makeHamburger(ingredientLinkedList)) {
                count++;
            }
        }
        return count;
    }

    private boolean makeHamburger(LinkedList<Integer> ingredientLinkedList) {
        int lastIndex = ingredientLinkedList.size() - 1;
        if (ingredientLinkedList.size() < 4) {
            return false;
        }
        if (ingredientLinkedList.get(lastIndex) == 1
                && ingredientLinkedList.get(lastIndex - 1) == 3
                && ingredientLinkedList.get(lastIndex - 2) == 2
                && ingredientLinkedList.get(lastIndex - 3) == 1) {
            for (int i = 0; i < 4; i++) {
                ingredientLinkedList.removeLast();
            }
            return true;
        }
        return false;
    }
}
