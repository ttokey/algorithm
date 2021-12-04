package programmers.devMatching2;

public class Ball {
    public int solution(String[] drum) {
        Map map = new Map(drum);
        return map.countResult();
    }

    public class Map{
        char[][] map;

        public Map(String[] drum) {
            int height = drum.length;
            char[][] toMap = new char[drum[0].length()][height];
            for(int i = 0 ; i < height ; i++){
                toMap[i] =  drum[i].toCharArray();
            }
            this.map = toMap;
        }

        public int countResult(){
            int count = 0;
            for(int i = 0; i < sideLength(); i++){
                if(isCanGoFloor(i)){
                    count++;
                }
            }
            return count;
        }

        public boolean isCanGoFloor(int start){
            Node node = new Node(start, 0, 0);
            int floor = node.goDown(this);
            return floor == height() ? true : false;
        }

        public int height(){
            return this.map.length;
        }

        public int sideLength(){
            return this.map[0].length;
        }
    }

    public class Node{
        int x;
        int y;
        int mineCount;

        public Node(int x, int y, int mineCount) {
            this.x = x;
            this.y = y;
            this.mineCount = mineCount;
        }

        public int goDown(Map map){
            int height = map.height();
            while(mineCount < 2 && y < height){
                if(map.map[y][x] == '#'){
                    y++;
                }else if(map.map[y][x] == '<'){
                    x--;
                }else if(map.map[y][x] == '>'){
                    x++;
                }else if(map.map[y][x] == '*'){
                    mineCount++;
                    y++;
                }
            }
            if(mineCount == 2){
                return -1;
            }
            return this.y;
        }
    }






}
