
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package LeetCode.leetcode.editor.cn;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for singly-linked list.

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    class Solution {

        //暴力破解
       /* public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);
            ListNode pre = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val<l2.val){
                    pre.next = l1;
                    l1 = l1.next;
                }else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            pre.next = l1==null?l2 : l1;
            return prehead.next ;
        }*/
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null){
                return l2;
            }else
            if (l2 == null){
                return l1;
            }else
            if (l1.val<l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}