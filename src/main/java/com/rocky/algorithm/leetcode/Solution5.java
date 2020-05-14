package com.rocky.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题没做出来～～
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<s.length(); j++) {
                dp[i][j] = 0;
            }
        }
        List<Integer> result = new ArrayList<>();
        checkPalindrome(dp,0, s.length()-1, result, s);
        return s.substring(result.get(0), result.get(1)+1);


    }

    private void checkPalindrome(int[][] dp, int i, int j, List<Integer> result,String s) {
        if (i == j) {
            dp[i][i] = 1;
            checkBetterResult(result, i, j);
        }else if (j==i+1) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
                checkBetterResult(result,i,j);

            }else {
                dp[i][j] = -1;
            }

        }else {
            checkPalindrome(dp, i+1, j-1, result, s);
            if (dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 1;
                checkBetterResult(result, i, j);
            }
        }

    }

    private void checkBetterResult(List<Integer> result, int i, int j) {
        if (result.isEmpty()) {
            result.add(i);
            result.add(j);
        }else {
            int ci = result.get(0);
            int cj = result.get(1);
            if (cj - ci < j-i) {
                result.set(0, i);
                result.set(1, j);
            }
        }
    }

    public static void main(String[] args) {
//        String r = new Solution5().longestPalindrome("babad");
        String r2 = new Solution5().longestPalindrome("dsfsdhadhfkdsdsfsdhadhdsfsdhadhfkddsfsdhadhfkdsahfksadhdsfsdhadhfkdsahfksadhfksddsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsksahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsk");
    }
}
