package programmers.devMatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ToothBrushSalesTest {
    ToothBrushSales toothBrushSales = new ToothBrushSales();

    @Test
    public void testToothBrush() {
        //given
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] expect = {360, 958, 108, 0, 450, 18, 180, 1080};

        //when
        int[] result = toothBrushSales.solution(enroll, referral, seller, amount);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}