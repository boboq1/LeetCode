package LeetCode.K1540次操作转变字符串;

/**
 * @Auther: 13771
 * @Date: 2021/9/9 22:00
 * @Description: Solution
 * @Version 1.0.0
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().canConvertString("z", "t", 1);
    }

    public boolean canConvertString(String s, String t, int k) {

        if (s.length() != t.length()) return false;//两数组长度不同返回false
        int[] counts = new int[26];//计录数组对应位置数字的差出现的次数，原题规定每个下标变换次数不能与其他下表相同
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int dif = t.charAt(i) - s.charAt(i);
            if (dif < 0) {//t中的下表对应字母在s之前的情况
                dif += 26;
            }
            counts[dif]++;//统计dif出现的次数
        }
        for (int i = 1; i < 26; i++) {
            int max = i + (counts[i] - 1) * 26;//统计s中每个字母变换的最大次数
            if (max > k) return false;
        }
        return true;
    }
}
