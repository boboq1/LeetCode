//（这是一个 交互式问题 ） 
//
// 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 
//值。 
//
// 如果不存在这样的下标 index，就请返回 -1。 
//
// 
//
// 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件： 
//
// 首先，A.length >= 3 
//
// 其次，在 0 < i < A.length - 1 条件下，存在 i 使得： 
//
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
//
// 
//
// 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据： 
//
// 
// MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始） 
// MountainArray.length() - 会返回该数组的长度 
// 
//
// 
//
// 注意： 
//
// 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。 
//
// 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请
//注意这 不是一个正确答案。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：array = [1,2,3,4,5,3,1], target = 3
//输出：2
//解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。 
//
// 示例 2： 
//
// 输入：array = [0,1,2,4,2,1], target = 3
//输出：-1
//解释：3 在数组中没有出现，返回 -1。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= mountain_arr.length() <= 10000 
// 0 <= target <= 10^9 
// 0 <= mountain_arr.get(index) <= 10^9 
// 
// Related Topics 二分查找

package LeetCode.leetcode.editor.cn;
   class FindInMountainArray{
      public static void main(String[] args) {
           Solution solution = new FindInMountainArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

  // This is MountainArray's API interface.
  // You should not implement it, or speculate about its implementation
  interface MountainArray {
      public static int get(int index) {return MountainArray.get(index);}
      public static int length() {return MountainArray.length();}
  }
       class Solution  {
           public int findInMountainArray(int target, MountainArray mountainArr) {
               if(mountainArr.length()<=2) return -1;
               //首先找出最大值，将数组分为升序和降序的两部分，利用二分查找分别查找target
               int pre = 0 ,last = mountainArr.length()-1;
               while(pre+1<last){
                   int mid =(last+pre)/2;
                   int midVal = mountainArr.get(mid);
                   if(midVal>mountainArr.get(mid-1)){
                       pre = mid;
                   }else{
                       last = mid;
                   }
               }
               int maxIndex = mountainArr.get(last)>mountainArr.get(pre)?last:pre;
               int index = binaryFind(target,mountainArr,0,maxIndex,true);
               return index != -1?index:binaryFind(target,mountainArr,maxIndex+1,mountainArr.length()-1,false);
           }
           private int binaryFind(int target,MountainArray mountainArr,int pre,int last, boolean isPre){

               while(pre<=last){
                   int mid = (last+pre)/2;
                   int midVal = mountainArr.get(mid);
                   if(target == midVal){
                       return mid;
                   }
                   if(target>midVal){
                       pre = isPre?mid+1:pre;
                       last = isPre?last:mid-1;
                   }else{

                       last = isPre?mid-1:last;
                       pre = isPre?pre:mid+1;
                   }
               }
               return -1;
           }

       }
//leetcode submit region end(Prohibit modification and deletion)

  }