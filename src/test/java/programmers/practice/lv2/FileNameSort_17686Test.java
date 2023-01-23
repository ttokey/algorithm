package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FileNameSort_17686Test {
    FileNameSort_17686 fileNameSort_17686 = new FileNameSort_17686();

    @Test
    public void test() {
        //given
        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] expect = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};

        //when
        String[] result = fileNameSort_17686.solution(input);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}