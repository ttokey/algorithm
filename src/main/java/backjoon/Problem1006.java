package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1006 {
    public class Main {
        public void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<Integer> result = new ArrayList<>();
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                Operation operation = readOperation(br);

            }

        }

        public Operation readOperation(BufferedReader br) throws IOException {
            String input = br.readLine();
            String[] split = input.split(" ");
            int areaCount = Integer.parseInt(split[0]);
            int soldier = Integer.parseInt(split[1]);
            String areaMap1 = br.readLine();
            String areaMap2 = br.readLine();
            int[] area1 = Arrays.stream(areaMap1.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return null;
        }

        public class Operation {
            int areaCount;
            int soldier;
            int[][] areaMap;

            public Operation(int areaCount, int soldier, int[][] areaMap) {
                this.areaCount = areaCount;
                this.soldier = soldier;
                this.areaMap = areaMap;
            }
        }
    }
}
