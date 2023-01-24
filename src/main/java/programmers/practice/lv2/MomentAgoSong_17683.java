package programmers.practice.lv2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MomentAgoSong_17683 {
    public String solution(String m, String[] musicInfos) {
        List<MusicInfo> musicInfoList = new ArrayList<>();
        for (String musicInfo : musicInfos) {
            musicInfoList.add(new MusicInfo(musicInfo));
        }
        return musicInfoList.stream()
                .filter(musicInfo -> musicInfo.isSameMusic(m))
                .sorted((a, b) -> b.playTime - a.playTime)
                .map(musicInfo -> musicInfo.musicName)
                .findFirst()
                .orElse("(None)");
    }

    public class MusicInfo {
        int playTime;
        String musicName;
        String musicString;

        public MusicInfo(String musicInfo) {
            String[] musicInfoArray = musicInfo.split(",");
            String[] startDateString = musicInfoArray[0].split(":");
            String[] endDateString = musicInfoArray[1].split(":");
            LocalDateTime startDate = LocalDateTime.of(2023, 1, 26, Integer.parseInt(startDateString[0]), Integer.parseInt(startDateString[1]));
            LocalDateTime endDate = LocalDateTime.of(2023, 1, 26, Integer.parseInt(endDateString[0]), Integer.parseInt(endDateString[1]));
            musicName = musicInfoArray[2];
            String music = transMusicString(musicInfoArray[3]);
            playTime = (int) ChronoUnit.MINUTES.between(startDate, endDate);
            StringBuilder sb = new StringBuilder();
            while (sb.length() < playTime) {
                sb.append(music);
            }
            musicString = sb.substring(0, playTime);
        }

        public boolean isSameMusic(String inputMusicString) {
            inputMusicString = transMusicString(inputMusicString);
            return this.musicString.contains(inputMusicString);
        }

        public String transMusicString(String music) {
            music = music.replaceAll("C#", "H");
            music = music.replaceAll("D#", "I");
            music = music.replaceAll("F#", "J");
            music = music.replaceAll("G#", "K");
            music = music.replaceAll("A#", "L");
            return music;
        }
    }
}
