package programmers.practice.lv1;

import java.util.HashMap;
import java.util.Map;

public class RunningRace_178871 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Player> playerMap = new HashMap<>();
        Player prev = new Player(players[0]);
        playerMap.put(players[0], prev);
        for (int i = 1; i < players.length; i++) {
            Player nowPlayer = new Player(players[i], prev, i);
            playerMap.put(players[i], nowPlayer);
            prev = nowPlayer;
        }

        for (String call : callings) {
            playerMap.get(call).called();
        }

        String[] result = new String[players.length];
        for (Player player : playerMap.values()) {
            result[player.rank] = player.player;
        }
        return result;
    }

    public class Player {
        String player;
        Player prev = null;
        Player next = null;
        int rank = 0;

        public Player(String player, Player prev, int rank) {
            this.player = player;
            this.prev = prev;
            if (prev != null) {
                prev.next = this;
            }
            this.rank = rank;
        }

        public Player(String player) {
            this.player = player;
        }

        public void called() {
            this.prev.rank++;
            this.rank--;
            if (this.next != null) {
                this.next.prev = this.prev;
            }
            if (this.prev.prev != null) {
                this.prev.prev.next = this;
            }
            Player tempPrevPrev = this.prev.prev;
            Player tempPrev = this.prev;

            this.prev.next = this.next;
            this.prev.prev = this;

            this.prev = tempPrevPrev;
            this.next = tempPrev;
        }
    }
}
