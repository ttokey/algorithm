package programmers.lineFinance;

//입출력 예
//        rectangles	result
//        [[0,2,1,3],[1,2,2,5],[3,3,4,4],[4,1,6,3],[1,6,5,7],[5,5,7,6],[5,8,6,10]]	["0 0 1 1","1 0 2 3","2 0 3 1","3 0 5 2","0 3 4 4","2 2 4 3","4 3 5 5"]

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lineFinanceFourth {
    public String[] solution(int[][] input) {

        Rectangles rectangles = new Rectangles(input);
        rectangles.moveDown();
        rectangles.moveLeft();

        return rectangles.getPoint();
    }

    public class Rectangles {
        List<Rectangle> originRectangles;
        List<Rectangle> moveRectangles;

        public Rectangles(int[][] rectangles) {
            originRectangles = new ArrayList<>();
            moveRectangles = new ArrayList<>();
            for (int[] point : rectangles) {
                Rectangle rectangle = new Rectangle(point);
                originRectangles.add(rectangle);
                moveRectangles.add(rectangle);
            }
        }

        private void sortX() {
            Collections.sort(this.moveRectangles, (a, b) -> a.x1 < b.x1 ? -1 : 0);
        }

        private void sortY() {
            Collections.sort(this.moveRectangles, (a, b) -> a.y1 < b.y1 ? -1 : 0);
        }

        public void moveDown() {

            sortY();
            for (int i = 0; i < moveRectangles.size(); i++) {
                boolean canMove = true;
                while (canMove) {
                    if (moveRectangles.get(i).y1 == 0) {
                        canMove = false;
                    } else {
                        for (int j = 0; j < i; j++) {
                            if (!moveRectangles.get(i).canMoveDown(moveRectangles.get(j))) {
                                canMove = false;
                            }
                        }
                    }
                    if (canMove) {
                        moveRectangles.get(i).moveDown();
                    }

                }
            }
        }

        public void moveLeft() {
            sortX();
            for (int i = 0; i < moveRectangles.size(); i++) {
                boolean canMove = true;
                while (canMove) {
                    if (moveRectangles.get(i).x1 == 0) {
                        canMove = false;
                    } else {
                        for (int j = 0; j < i; j++) {
                            if (!moveRectangles.get(i).canMoveLeft(moveRectangles.get(j))) {
                                canMove = false;
                            }
                        }
                    }
                    if (canMove) {
                        moveRectangles.get(i).moveLeft();
                    }
                }
            }
        }

        public String[] getPoint() {
            return originRectangles.stream()
                    .map(rectangle -> rectangle.getPoint())
                    .toArray(String[]::new);
        }
    }

    public class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int[] input) {
            this.x1 = input[0];
            this.y1 = input[1];
            this.x2 = input[2];
            this.y2 = input[3];
        }

        public void moveDown() {
            y1 -= 1;
            y2 -= 1;
        }

        public void moveLeft() {
            x1 -= 1;
            x2 -= 1;
        }


        public boolean canMoveDown(Rectangle rectangle) {
            if (this.y1 > rectangle.y2 ||
                    this.x1 >= rectangle.x2 ||
                    this.x2 <= rectangle.x1) {
                return true;
            }
            return false;
        }

        public boolean canMoveLeft(Rectangle rectangle) {
            if (this.x1 > rectangle.x2 ||
                    this.y1 >= rectangle.y2 ||
                    this.y2 <= rectangle.y1) {
                return true;
            }
            return false;

        }

        public String getPoint() {
            StringBuilder sb = new StringBuilder();
            sb.append(x1)
                    .append(" ")
                    .append(y1)
                    .append(" ")
                    .append(x2)
                    .append(" ")
                    .append(y2);
            return sb.toString();
        }
    }


}
