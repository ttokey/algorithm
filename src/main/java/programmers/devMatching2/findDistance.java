package programmers.devMatching2;

public class findDistance {


    public int solution(String s) {
        KeyBoard keyBoard = new KeyBoard();
        char[] splits = s.toCharArray();
        int[] distances = new int[splits.length-1];
        for(int i = 0 ; i < splits.length - 1 ; i++){
            distances[i] = keyBoard.getDistance(splits[i],splits[i+1]);
        }
        int divide = 1000000007;
        long result = 0;
//        for(int i = 1; i<= distances.length;i++){
//            for(int j = 0; j <= distances.length - i;j++){
//                for(int k = j; k < j + i; k++){
//                    result += distances[k];
//                    result %= divide;
//                }
//            }
//        }
        for(int distance : distances){
            result += distance;
        }
        result = result * distances.length;

        return (int) result  % divide;
    }

    public class KeyBoard{
        char[][] key = new char[9][3];

        public KeyBoard() {
            String[] inputs = {"qwertyuio", "pasdfghjk", "lzxcvbnm "};
            for(int i = 0 ; i < inputs.length ; i++){
                this.key[i] = inputs[i].toCharArray();
            }
        }

        public int getDistance(char input1, char input2){
            int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;

            for(int i = 0; i < 3; i++){
                for(int j = 0 ; j < 9; j++){
                    if(key[i][j] == input1){
                        x1 = i;
                        y1 = j;
                    }
                    if(key[i][j] == input2){
                        x2 = i;
                        y2 = j;
                    }
                }
            }
            return Math.abs(x1-x2) + Math.abs(y2-y1);
        }
    }


}
