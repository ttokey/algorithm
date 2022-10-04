package tving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubtitleComparator {
    public String inputString =
            "| 1        | 한국어           | ko      | N                |\n" +
                    "| 2        | 한국어(해설)     | ko      | Y                |\n" +
                    "| 3        | 일본어           | ja      | N                |\n" +
                    "| 4        | 일본어(해설)     | ja      | Y                |\n" +
                    "| 5        | 영어             | en      | N                |\n" +
                    "| 6        | 영어(해설)       | en      | Y                |\n" +
                    "| 7        | 중국어           | zh      | N                |\n" +
                    "| 8        | 중국어(해설)     | zh      | Y                |\n" +
                    "| 9        | 태국어           | th      | N                |\n" +
                    "| 10       | 태국어(해설)     | th      | Y                |\n" +
                    "| 11       | 프랑스어         | fr      | N                |\n" +
                    "| 12       | 프랑스어(해설)   | fr      | Y                |\n" +
                    "| 13       | 스페인어         | es      | N                |\n" +
                    "| 14       | 스페인어(해설)   | es      | Y                |\n" +
                    "| 15       | 독일어           | de      | N                |\n" +
                    "| 16       | 독일어(해설)     | de      | Y                |\n" +
                    "| 17       | 러시아어         | ru      | N                |\n" +
                    "| 18       | 러시아어(해설)   | ru      | Y                |\n" +
                    "| 19       | 이탈리아어       | it      | N                |\n" +
                    "| 20       | 이탈리아어(해설) | it      | Y                |\n" +
                    "| 21       | 아랍어           | ar      | N                |\n" +
                    "| 22       | 아랍어(해설)     | ar      | Y                |\n" +
                    "| 23       | 말레이어         | ms      | N                |\n" +
                    "| 24       | 말레이어(해설)   | ms      | Y                |\n" +
                    "| 25       | 페르시아어       | fa      | N                |\n" +
                    "| 26       | 페르시아어(해설) | fa      | Y                |\n" +
                    "| 27       | 포르투칼어       | ot      | N                |\n" +
                    "| 28       | 포르투칼어(해설) | ot      | Y                |\n" +
                    "| 29       | 그리스어         | el      | N                |\n" +
                    "| 30       | 그리스어(해설)   | el      | Y                |\n" +
                    "| 31       | 네덜란드어       | nl      | N                |\n" +
                    "| 32       | 네덜란드어(해설) | nl      | Y                |\n" +
                    "| 33       | 스페인어         | sv      | N                |\n" +
                    "| 34       | 스페인어(해설)   | sv      | Y                |\n" +
                    "| 35       | 터키어           | tr      | N                |\n" +
                    "| 36       | 터키어(해설)     | tr      | Y                |\n" +
                    "| 37       | 폴란드어         | pl      | N                |\n" +
                    "| 38       | 폴란드어(해설)   | pl      | Y                |\n" +
                    "| 39       | 헝가리어         | hu      | N                |\n" +
                    "| 40       | 헝가리어(해설)   | hu      | Y                |\n";

    public List<Output> subtitleComparator(List<Input> inputList) {
        List<Language> languageList = Arrays.stream(inputString.split("\n"))
                .map(s -> new Language(s))
                .collect(Collectors.toList());
        Set<Input> inputSet = new HashSet<>(inputList);
        List<Output> result = languageList.stream()
                .filter(v -> inputSet.contains(v.toInput()))
                .map(v -> v.toOutput())
                .collect(Collectors.toList());
        return result;
    }

    public static class Language {
        int order;
        String language;
        String lang_cd;
        String close_caption_yn;

        public Language(int order, String language, String lang_cd, String close_caption_yn) {
            this.order = order;
            this.language = language;
            this.lang_cd = lang_cd;
            this.close_caption_yn = close_caption_yn;
        }

        public Language(String s) {
            String[] strings = s
                    .replaceAll(" ", "")
                    .split("\\|");
            this.order = Integer.valueOf(strings[1]);
            this.language = strings[2];
            this.lang_cd = strings[3];
            this.close_caption_yn = strings[4];
        }

        public Output toOutput() {
            return new Output(this.language, this.lang_cd, this.close_caption_yn);
        }

        public Input toInput() {
            return new Input(this.lang_cd, this.close_caption_yn);
        }
    }

    public static class Input {
        String lang_cd;
        String close_caption_yn;

        public Input(String lang_cd, String close_caption_yn) {
            this.lang_cd = lang_cd;
            this.close_caption_yn = close_caption_yn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Input input = (Input) o;

            if (lang_cd != null ? !lang_cd.equals(input.lang_cd) : input.lang_cd != null) {
                return false;
            }
            return close_caption_yn != null ? close_caption_yn.equals(input.close_caption_yn) : input.close_caption_yn == null;
        }

        @Override
        public int hashCode() {
            int result = lang_cd != null ? lang_cd.hashCode() : 0;
            result = 31 * result + (close_caption_yn != null ? close_caption_yn.hashCode() : 0);
            return result;
        }
    }

    public static class Output {
        String language;
        String lang_cd;
        String close_caption_yn;

        public Output(String language, String lang_cd, String close_caption_yn) {
            this.language = language;
            this.lang_cd = lang_cd;
            this.close_caption_yn = close_caption_yn;
        }
    }
}
