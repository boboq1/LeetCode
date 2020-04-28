package LeetCode.验证二叉树;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/23 13:31
 */
public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[]arrays = new int[n];
        for (int i=0;i<n;i++){
            if (leftChild[i]!=-1)arrays[leftChild[i]]++;
            if (rightChild[i]!=-1)arrays[rightChild[i]]++;
        }
        int num0 = 0;
        int num1 = 0;
        for (int array:arrays){
            if (array==0)num0++;
            if (array>1)num1++;
        }
        return num0==1&&num1==0;
    }
    public static void main(String[]args){
        int n=4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,3,-1,-1};
        Solution s = new Solution();
        System.out.println(s.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
