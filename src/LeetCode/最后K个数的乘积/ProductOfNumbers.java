package LeetCode.最后K个数的乘积;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 10:53
 */
/**
 *解析：时间复杂度O(1)，只要累乘即可，遇到0的情况比较特殊，
 *
 *
 */
public class ProductOfNumbers {
    private int[]sum;
    private List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num==0){
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(num*list.get(list.size()-1));
        }

    }

    public int getProduct(int k) {
        int result=1;
        if (list.size()<=k){
            return 0;
        }else {
            result = list.get(list.size()-1)/list.get(list.size()-1-k);
            return result;
        }
    }
}
