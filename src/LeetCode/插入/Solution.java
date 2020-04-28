package LeetCode.插入;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/26 16:30
 */
public class Solution {
    public int insertBits(int N, int M, int i, int j) {

        StringBuffer NStr = new StringBuffer(Integer.toBinaryString(N));
        StringBuffer MStr = new StringBuffer(Integer.toBinaryString(M));
        int remain = 32-NStr.length();
        while (remain-->0) {
            NStr.insert(0,'0');
        }
        remain = j-i+1-MStr.length();
        while (remain-->0){
            MStr.insert(0,'0');
        }
        NStr.replace(NStr.length()-1-j,NStr.length()-i,MStr.toString());
        return Integer.parseInt(NStr.toString(),2);
    }
}
