package LeetCode.形成三的最大倍数;

import java.util.Arrays;
/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/25 11:38
 * 解析：3的倍数，余数是1或2
 */
public class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<digits.length;i++){
            sum+=digits[i];
            stringBuffer.append(digits[digits.length-1-i]);
        }
        if (sum==0)return "0";
        int mod = sum%3;
        if (mod==0)return String.valueOf(stringBuffer);
        for (int i=0;i<digits.length;i++){
            if (digits[i]%3!=0){
                if (mod==1&&mod==digits[i]%3){
                    stringBuffer.deleteCharAt(digits.length-1-i);
                    return String.valueOf(stringBuffer);
                }
                if (mod==2){
                    if (mod==digits[i]%3){
                        stringBuffer.deleteCharAt(digits.length-1-i);
                        return String.valueOf(stringBuffer);
                    }
                }
            }
        }
        int temp=0;
        for (int i=0;i<digits.length;i++){
            if (digits[i]%3!=0){
                if (mod==1&&digits[i]%3==2){
                    temp+=digits[i];
                    stringBuffer.deleteCharAt(digits.length-1-i);
                   if (mod==temp%3){
                       return String.valueOf(stringBuffer);
                   }
                }
                if (mod==2){
                    mod-=digits[i]%3;
                    stringBuffer.deleteCharAt(digits.length-1-i);
                    if (mod==0){
                        return String.valueOf(stringBuffer);
                    }
                }
            }

        }
        return "";
    }
    public static void main(String[] args){
        int[]digits = {1,1,1,2};
        Solution s = new Solution();
        System.out.println(s.largestMultipleOfThree(digits));

    }
}
