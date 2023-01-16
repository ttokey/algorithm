package programmers.practice.lv2;

import java.util.Stack;

public class StockPrice_42584 {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> priceStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            int count = 1;
            while (!priceStack.isEmpty() && priceStack.peek() > prices[i]) {
                int index = indexStack.pop();
                priceStack.pop();
                result[index] = i - index;
            }
            priceStack.add(prices[i]);
            indexStack.add(i);
        }
        for (int i = 0; i < prices.length; i++) {
            if (result[i] == 0) {
                result[i] = prices.length - i - 1;
            }
        }
        return result;
    }
}
