package LeetCode.最后K个数的乘积;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @date 2020/2/16 10:59
 */
public class Test {
    private int[]sum;
    private List<Integer> list = new ArrayList<>();
    public void test(int num){
        list.add(num);
        sum = new int[list.size()];
        for (int i=0;i<list.size();i++){
                    sum[i] = list.get(i);
        }

    }
    public void outPUt(){
        for (int i=0;i<sum.length;i++){
            System.out.println(sum[i]);
        }
    }
    public static void main(String[]args){
        Test t = new Test();
        t.test(1);
        t.test(2);
        t.test(32);
        t.test(3);
        t.outPUt();

    }
}
