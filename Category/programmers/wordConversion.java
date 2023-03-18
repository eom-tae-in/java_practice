package Category.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class wordConversion {
    static boolean[] ch;
    static class Word {
        String word;
        int move;
        public Word(String word, int move) {
            this.word = word;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String begin = str1[0];
        String target = str1[1];
        String[] words = sc.nextLine().split(" ");
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        ch = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        while (!queue.isEmpty()) {
            Word word = queue.remove();
            if (target.equals(word.word)) {
                return word.move;
            }
            for (int i = 0; i < words.length; i++) {
                if (conditionValidation(word.word, words[i]) && !ch[i]) {
                    ch[i] = true;
                    queue.add(new Word(words[i], word.move + 1));
                }
            }
        }
        return 0;
    }

    public static boolean conditionValidation(String pre, String post) {
        int count = 0;
        for (int i = 0; i < pre.length(); i++) {
            if (pre.charAt(i) == post.charAt(i)) {
                count++;
            }
        }
        return count == pre.length() - 1;
    }
}