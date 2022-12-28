package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SkillTree_49993Test {
    SkillTree_49993 skillTree_49993 = new SkillTree_49993();

    @Test
    public void test() {
        //given
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int expect = 2;

        //when
        int result = skillTree_49993.solution(skill, skill_trees);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}