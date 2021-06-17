package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FindWordsTest {
    FindWords findWords = new FindWords();

    @Test
    public void test() {
        //given
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a', 'a'}};
        String[] words = {"aaa"};

        List<String> expect = new ArrayList<>();

        //when
        List<String> result = findWords.findWords(board, words);

        //then
        System.out.println(result);
    }
}