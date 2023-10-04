package category.leetcode.october.fourth;

import java.util.ArrayList;
import java.util.List;

public class October4th {

    private static final int kSize = 10000;
    List<int[]>[] lists;

    public October4th() {
        lists = new List[kSize];
        for (int i = 0; i < kSize; ++i) {
            lists[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        for (int[] pair : lists[key % kSize]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        lists[key % kSize].add(new int[]{key, value});
    }

    public int get(int key) {
        for (int[] pair : lists[key % kSize]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < lists[key % kSize].size(); ++i) {
            if (lists[key % kSize].get(i)[0] == key) {
                lists[key % kSize].remove(i);
                return;
            }
        }
    }
}
