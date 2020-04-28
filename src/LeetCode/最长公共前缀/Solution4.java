package LeetCode.最长公共前缀;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/3/2 17:13
 * 二分查找
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(),minLength);
        }
        int low = 1;
        int high = minLength;
        while (low <= high) {
            int mid = (low+high)/2;
            if (isCommonPrefix(strs,mid)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0,(low+high)/2);
    }

    private boolean isCommonPrefix(String[] strs, int mid) {
        String str = strs[0].substring(0,mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
