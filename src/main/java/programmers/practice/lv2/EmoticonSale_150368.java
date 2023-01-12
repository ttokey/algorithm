package programmers.practice.lv2;

public class EmoticonSale_150368 {
    public int[] solution(int[][] users, int[] emoticons) {
        int emoticonPlusCount = 0;
        int emoticonSaleAmount = 0;
        for (int i = 0; i < Math.pow(4, emoticons.length); i++) {
            StringBuilder sb = new StringBuilder();
            String saleString = Integer.toString(i, 4);
            for (int j = 0; j < emoticons.length - saleString.length(); j++) {
                sb.append("0");
            }
            sb.append(saleString);
            int[] calcResult = calc(sb.toString(), emoticons, users);
            if (emoticonPlusCount < calcResult[0]) {
                emoticonPlusCount = calcResult[0];
                emoticonSaleAmount = calcResult[1];
            } else if (emoticonPlusCount == calcResult[0] && emoticonSaleAmount < calcResult[1]) {
                emoticonSaleAmount = calcResult[1];
            }
        }
        int[] answer = {emoticonPlusCount, emoticonSaleAmount};
        return answer;
    }

    public int[] calc(String salePercent, int[] emoticons, int[][] users) {
        int totalPlusCount = 0;
        int totalSaleAmount = 0;
        int[] emoticonSalePercent = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            emoticonSalePercent[i] = (Integer.parseInt(salePercent.substring(i, i + 1)) + 1) * 10;
        }
        for (int[] user : users) {
            int userSalePrice = 0;
            for (int i = 0; i < emoticons.length && userSalePrice < user[1]; i++) {
                if (emoticonSalePercent[i] >= user[0]) {
                    userSalePrice += (100 - emoticonSalePercent[i]) * emoticons[i] / 100;
                }
            }
            if (userSalePrice >= user[1]) {
                totalPlusCount++;
            } else {
                totalSaleAmount += userSalePrice;
            }
        }
        int[] result = {totalPlusCount, totalSaleAmount};
        return result;
    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        EmoticonSale_150368 emoticonSale_150368 = new EmoticonSale_150368();

        int[] result = emoticonSale_150368.solution(users, emoticons);
        System.out.println(result[0] + " " + result[1]);
    }
}
