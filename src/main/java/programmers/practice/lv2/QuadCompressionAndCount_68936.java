package programmers.practice.lv2;

public class QuadCompressionAndCount_68936 {
    int zeroCount = 0;
    int oneCount = 0;

    public int[] solution(int[][] arr) {
        compression(0, 0, arr.length - 1, arr[0].length - 1, arr);
        int[] answer = {zeroCount, oneCount};
        return answer;
    }

    public void compression(int startY, int startX, int endY, int endX, int[][] arr) {
        if (startX == endX && startY == endY) {
            upCount(arr[startY][startX]);
            return;
        }

        int number = arr[startY][startX];
        boolean isChange = false;

        for (int y = startY; y <= endY && !isChange; y++) {
            for (int x = startX; x <= endX && !isChange; x++) {
                if (number != arr[y][x]) {
                    isChange = true;
                    break;
                }
            }
        }

        if (!isChange) {
            upCount(number);
            return;
        } else {
            int middleY = (int) Math.ceil((double) (endY - startY) / 2);
            int middleX = (int) Math.ceil((double) (endX - startX) / 2);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int firstX = startX + i * middleX;
                    int firstY = startY + j * middleY;
                    int secondX = firstX + middleX - 1;
                    int secondY = firstY + middleY - 1;
                    compression(firstY, firstX, secondY, secondX, arr);
                }
            }
        }
    }

    public void upCount(int number) {
        if (number == 0) {
            zeroCount++;
        } else {
            oneCount++;
        }
    }

}
