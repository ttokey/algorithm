package programmers.practice.lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SkillTree_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String checkSkill : skill_trees) {
            boolean flag = true;
            Queue<Character> skillQueue = new LinkedList<>();
            Set<Character> skillSet = new HashSet<>();
            for (int i = 0; i < skill.length(); i++) {
                Character c = skill.charAt(i);
                skillQueue.add(c);
                skillSet.add(c);
            }
            for (int i = 0; i < checkSkill.length() && flag; i++) {
                char c = checkSkill.charAt(i);
                if (skillSet.contains(c)) {
                    if (!skillQueue.isEmpty() && skillQueue.poll() != c) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}
