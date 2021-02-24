package LeetCode.最长公共前缀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hcb
 * @Date: 2021/1/30 12:30
 * @Version 1.0
 */
public class SolutionKaoKu {
   /* public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int len = strs.length;
        String result = strs[0];
        for (int i = 1; i < len; i++) {
            result = method(result,strs[i]);
        }
        return result;
    }

    private String method(String result, String str) {
        int len = Math.min(result.length(),str.length());
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (result.charAt(k) == str.charAt(k)) {
                k++;
            }else {
                break;
            }
        }
        return result.substring(0,k);
    }*/
   /*public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) return "";
       int length = strs[0].length();
       int len = strs.length;
       for (int i = 0; i < length; i++) {
           char ch = strs[0].charAt(i);
           for (int j = 1; j < len; j++) {
               if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                   return strs[0].substring(0,i);
               }
           }
       }
       return strs[0];
   }*/

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) return result;
        int l = 0;

        int r = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            r = Math.min(r,strs[i].length());
        }
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            if (isTrue(strs,mid)) {
                l = mid;
            }else r = mid - 1;
        }
        return strs[0].substring(0,l);
    }

    private boolean isTrue(String[] strs, int mid) {
        String result = strs[0].substring(0,mid);
        for (int i = 1; i < strs.length; i++) {
            if (!result.equals(strs[i].substring(0,mid))) {
                return false;
            }
        }
        return true;
    }

}
