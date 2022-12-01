package programmers.practice.lv2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingFee_92341 {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, LocalDateTime> parkingMap = new HashMap<>();
        Map<Integer, Integer> parkingMinuteMap = new HashMap<>();
        Map<Integer, Integer> feeMap = new HashMap<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");
            int[] splitTime = Arrays.stream(splitRecord[0].split(":")).mapToInt(i -> Integer.valueOf(i)).toArray();
            if ("IN".equals(splitRecord[2]) && !"23:59".equals(splitRecord[0])) {
                parkingMap.put(Integer.valueOf(splitRecord[1]), LocalDateTime.of(1993, 02, 19, splitTime[0], splitTime[1]));
            } else if ("OUT".equals(splitRecord[2])) {
                int car = Integer.valueOf(splitRecord[1]);
                int betweenMinute = (int) ChronoUnit.MINUTES.between(parkingMap.get(car), LocalDateTime.of(1993, 02, 19, splitTime[0], splitTime[1]));
                if (!parkingMinuteMap.containsKey(car)) {
                    parkingMinuteMap.put(car, betweenMinute);
                } else {
                    parkingMinuteMap.put(car, parkingMinuteMap.get(car) + betweenMinute);
                }
                parkingMap.remove(car);
            }
        }

        for (Integer car : parkingMap.keySet()) {
            int betweenMinute = (int) ChronoUnit.MINUTES.between(parkingMap.get(car), LocalDateTime.of(1993, 02, 19, 23, 59));
            if (!parkingMinuteMap.containsKey(car)) {
                parkingMinuteMap.put(car, betweenMinute);
            } else {
                parkingMinuteMap.put(car, parkingMinuteMap.get(car) + betweenMinute);
            }
        }

        List<Integer> carList = parkingMinuteMap.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> feeList = new ArrayList<>();
        for (Integer car : carList) {
            feeList.add(getFee(parkingMinuteMap.get(car), fees));
        }
        return feeList.stream().mapToInt(i -> i).toArray();
    }

    public int getFee(int minute, int[] fees) {
        if (minute <= fees[0]) {
            return fees[1];
        }
        return (int) (fees[1] + Math.ceil((double) (minute - fees[0]) / fees[2]) * fees[3]);
    }
}
