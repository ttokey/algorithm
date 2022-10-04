package tving;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubtitleComparatorTest {

    SubtitleComparator subtitleComparator = new SubtitleComparator();

    @Test

    public void subtitleTest() {
        //given
        List<SubtitleComparator.Input> inputList = List.of(
                new SubtitleComparator.Input("zh", "Y"),
                new SubtitleComparator.Input("th", "N"),
                new SubtitleComparator.Input("ko", "Y")
        );
        List<SubtitleComparator.Output> expectList = List.of(
                new SubtitleComparator.Output("한국어(해설)", "ko", "Y"),
                new SubtitleComparator.Output("중국어(해설)", "zh", "Y"),
                new SubtitleComparator.Output("태국어", "th", "N")
        );

        //when
        List<SubtitleComparator.Output> outputList = subtitleComparator.subtitleComparator(inputList);

        //then
        for (SubtitleComparator.Output output : outputList) {
            System.out.println(output.toString());
        }
        for (int i = 0; i < expectList.size(); i++) {
            Assertions.assertThat(expectList.get(i).toString()).isEqualTo(outputList.get(i).toString());
        }
    }

}