package com.rocky.algorithm.leetcode;

import java.util.*;

/**
 * 找到每一个字母的开始和结束节点，然后排序，判断是否重叠
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        Map<Character, Pair> cMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (cMap.containsKey(c)) {
                Pair pair = cMap.get(c);
                pair.end = i;
            }else {
                Pair pair = new Pair(c, i, i);
                cMap.put(c, pair);
            }
        }
        Pair[] pairs = new ArrayList<>(cMap.values()).toArray(new Pair[]{});
        Arrays.sort(pairs, new Pair());
        List<Integer> result = new ArrayList<>();

        Pair pre = pairs[0];

        for (int i = 1; i <pairs.length; i++) {
            if (!isOverLap(pre, pairs[i])) {
                // 不重叠
                result.add(pre.end - pre.start + 1);
                pre = pairs[i];
            }else {
                pre.end = Math.max(pre.end, pairs[i].end);
            }
        }
        result.add(pre.end - pre.start + 1);
        return result;
    }

    private boolean isOverLap(Pair p1, Pair p2) {
        Pair[] pairs = new Pair[] {p1, p2};
        Arrays.sort(pairs, new Pair());
        return pairs[1].start <= pairs[0].end;

    }

    public static class Pair implements Comparator<Pair> {
        public Character value;
        public int start;
        public int end;

        public Pair() {
        }

        public Pair(Character value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.start - o2.start != 0) {
                return o1.start - o2.start;
            }else {
                return o1.end - o2.end;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> ababcbacadefegdehijhklij = new Solution763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
