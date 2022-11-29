package programmers.devMatching3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class solution2 {
    public String[] solution(String[] records) {
        Course[] courses = new Course[5];
        for (int i = 0; i < 5; i++) {
            courses[i] = new Course();
        }
        List<Player> players = new ArrayList<>();
        for (String record : records) {
            String[] nameAndRecord = record.split(":");
            int[] playerRecord = Arrays.stream(nameAndRecord[1].split(","))
                    .mapToInt(s -> Integer.valueOf(s))
                    .toArray();
            for (int i = 0; i < 5; i++) {
                courses[i].addRecord(nameAndRecord[0], playerRecord[i]);
            }
            players.add(new Player(nameAndRecord[0], playerRecord));
        }
        for (Course course : courses) {
            Map<String, String> medals = course.getMedal();
            for (String playerName : medals.keySet()) {
                for (Player player : players) {
                    if (player.isPlayer(playerName)) {
                        player.addMedal(medals.get(playerName));
                    }
                }
            }
        }
        System.out.println(players.get(2).isWinner(players.get(3)));
        return players.stream().sorted((a, b) -> b.isWinner(a)).map(player -> player.name).toArray(String[]::new);
    }

    public class Course {
        PriorityQueue<Map.Entry<String, Integer>> course;

        public Course() {
            this.course = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        }

        public void addRecord(String playerName, int record) {
            if (record != 0) {
                this.course.add(new AbstractMap.SimpleEntry<>(playerName, record));
            }
        }

        public Map<String, String> getMedal() {
            int goldCount = (int) Math.ceil(((double) course.size() / 12));
            int silverCount = (int) Math.ceil(((double) course.size() / 4)) - goldCount;
            int bronzeCount = (int) Math.ceil(((double) course.size() / 2)) - goldCount - silverCount;
            Map<String, String> result = new HashMap<>();
            while (goldCount > 0) {
                result.put(course.poll().getKey(), "gold");
                goldCount--;
            }
            while (silverCount > 0) {
                result.put(course.poll().getKey(), "silver");
                silverCount--;
            }
            while (bronzeCount > 0) {
                result.put(course.poll().getKey(), "bronze");
                bronzeCount--;
            }
            return result;
        }
    }

    public class Player {
        String name;
        int maxCourse;
        int gold;
        int silver;
        int bronze;
        int completeCount;
        int totalCompleteTime;

        public Player(String name, int[] records) {
            this.name = name;
            this.maxCourse = getMaxCourse(records);
            this.completeCount = getCompleteCount(records);
            this.totalCompleteTime = Arrays.stream(records).sum();
            this.gold = 0;
            this.silver = 0;
            this.bronze = 0;
        }

        public int isWinner(Player another) {
            if (this.completeCount > another.completeCount) {
                return 1;
            } else if (this.completeCount < another.completeCount) {
                return -1;
            }

            if (this.maxCourse > another.maxCourse) {
                return 1;
            } else if (this.maxCourse < another.maxCourse) {
                return -1;
            }

            if (this.gold > another.gold) {
                return 1;
            } else if (this.gold < another.gold) {
                return -1;
            }

            if (this.silver > another.silver) {
                return 1;
            } else if (this.silver < another.silver) {
                return -1;
            }

            if (this.bronze > another.bronze) {
                return 1;
            } else if (this.bronze < another.bronze) {
                return -1;
            }

            if (this.totalCompleteTime < another.totalCompleteTime) {
                return 1;
            } else if (this.totalCompleteTime > another.totalCompleteTime) {
                return -1;
            }

            if (this.totalCompleteTime < another.totalCompleteTime) {
                return 1;
            } else if (this.totalCompleteTime > another.totalCompleteTime) {
                return -1;
            }

            return this.name.compareTo(another.name);
        }

        public boolean isPlayer(String playerName) {
            return name == playerName;
        }

        public void addMedal(String medal) {
            if ("gold".equals(medal)) {
                this.gold++;
            } else if ("silver".equals(medal)) {
                this.silver++;
            } else if ("bronze".equals(medal)) {
                this.bronze++;
            }
        }

        private int getMaxCourse(int[] records) {
            for (int i = 4; i >= 0; i--) {
                if (records[i] != 0) {
                    return i;
                }
            }
            return -1;
        }

        private int getCompleteCount(int[] records) {
            int result = 0;
            for (int i = 0; i < records.length; i++) {
                if (i > 0) {
                    result++;
                }
            }
            return result;
        }
    }
}
