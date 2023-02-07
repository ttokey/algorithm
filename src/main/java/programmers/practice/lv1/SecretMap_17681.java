package programmers.practice.lv1;

public class SecretMap_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String arr1String = getOneRow(n, arr1[i]);
            String arr2String = getOneRow(n, arr2[i]);
            answer[i] = sumRow(arr1String, arr2String);
        }
        return answer;
    }

    public String getOneRow(int n, int input) {
        String binaryString = Integer.toBinaryString(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - binaryString.length(); i++) {
            sb.append("0");
        }
        sb.append(binaryString);
        return sb.toString().replaceAll("1", "#").replaceAll("0", " ");
    }

    public String sumRow(String input1, String input2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == '#' || input2.charAt(i) == '#') {
                sb.append("#");
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
