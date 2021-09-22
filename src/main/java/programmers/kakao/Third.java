package programmers.kakao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Third {
    Map<String, List<LocalDateTime>> in = new HashMap<>();
    Map<String, List<LocalDateTime>> out = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        makeRecordsMap(records);
        List<String> carNumbers = in.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int[] answer = new int[in.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            answer[i] = calcFee(carNumbers.get(i), fees);
        }
        return answer;
    }

    public int calcFee(String carNumber, int[] fees) {
        List<LocalDateTime> inTime = in.getOrDefault(carNumber, new ArrayList<>());
        List<LocalDateTime> outTime = out.getOrDefault(carNumber, new ArrayList<>());
        LocalDateTime lastTime = LocalDateTime.of(2021, 9, 11, 23, 59);
        int minute = 0;
        int result = 0;
        for (int i = 0; i < inTime.size(); i++) {
            if (i < outTime.size()) {
                minute += ChronoUnit.MINUTES.between(inTime.get(i), outTime.get(i));
            } else {
                minute += ChronoUnit.MINUTES.between(inTime.get(i), lastTime);
            }
        }
        result += fees[1];
        minute -= fees[0];
        while (minute > 0) {
            result += fees[3];
            minute -= fees[2];
        }
        return result;
    }


    public void makeRecordsMap(String[] records) {
        for (String record : records) {
            String[] split = record.split(" ");
            String[] times = split[0].split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            LocalDateTime time = LocalDateTime.of(2021, 9, 11, hour, minute);
            if (split[2].equals("IN")) {
                if (in.containsKey(split[1])) {
                    List<LocalDateTime> value = in.get(split[1]).stream().collect(Collectors.toList());
                    value.add(time);
                    in.put(split[1], value);
                } else {
                    in.put(split[1], Arrays.asList(time));
                }

            } else {
                if (out.containsKey(split[1])) {
                    List<LocalDateTime> value = out.get(split[1]).stream().collect(Collectors.toList());
                    value.add(time);
                    out.put(split[1], value);
                } else {
                    out.put(split[1], Arrays.asList(time));
                }
            }
        }
    }


}
