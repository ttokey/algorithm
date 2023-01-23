package programmers.practice.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileNameSort_17686 {
    public String[] solution(String[] files) {
        List<File> fileList = Arrays.stream(files).map(file -> new File(file)).sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        return fileList.stream().map(file -> file.getOrigin()).toArray(String[]::new);
    }

    public class File {
        String head;
        String number;
        String origin;

        public File(String fileName) {
            this.head = fileName.split("[\\d]")[0].toUpperCase();
            this.number = fileName.substring(head.length()).split("[^\\d]")[0];
            this.origin = fileName;
        }

        public String getOrigin() {
            return origin;
        }

        public int compareTo(File other) {
            int compareHead = this.head.compareTo(other.head);
            if (compareHead != 0) {
                return compareHead;
            }
            return Integer.parseInt(this.number) - Integer.parseInt(other.number);
        }
    }
}
