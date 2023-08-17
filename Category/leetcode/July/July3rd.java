package Category.leetcode.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class July3rd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String goal = sc.next();
        System.out.println(buddyStrings(s, goal));
    }
    public static boolean buddyStrings(String s, String goal) {
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        List<Integer> list = new ArrayList<>();
        if (s.length() != goal.length()){
            return false;
        }
        for (int i = 0; i < goal.length(); i++){
            if (s.charAt(i) != goal.charAt(i)){
                list.add(i);
            }
            chars1[s.charAt(i) - 'a']++;
            chars2[goal.charAt(i) - 'a']++;
        }
        if (goal.length() == 1){
            return false;
        }
        if (list.size() == 2){
            return s.charAt(list.get(1)) == goal.charAt(list.get(0)) && s.charAt(list.get(0)) == goal.charAt(list.get(1));
        }
        if (Arrays.equals(chars1, chars2) && list.size() == 0){
            for(int i : chars1){
                if (i > 1){
                    return true;
                }
            }
        }
        return false;
    }
}

