package LeetCode.H726原子的数量;

import java.util.*;

class Solution {
    int i, n;
    String formula;

    public String countOfAtoms(String formula) {
       /* this.i = 0;
        this.n = formula.length();
        this.formula = formula;

        Deque<Map<String, Integer>> stack = new LinkedList<Map<String, Integer>>();
        stack.push(new HashMap<String, Integer>());
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                i++;
                stack.push(new HashMap<String, Integer>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
            } else if (ch == ')') {
                i++;
                int num = parseNum(); // 括号右侧数字
                Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
            }
        }

        Map<String, Integer> map = stack.pop();
        //TreeMap根据键值排序
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i++)); // 扫描首字母
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
        }
        return sb.toString();
    }

    public int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1; // 不是数字，视作 1
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字
        }
        return num;*/
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;
        Deque<Map<String,Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>());
        while (i < n) {
            char ch = formula.charAt(i);
             if (ch == '(') {
                 i++;
                 stack.push(new HashMap<>());
             } else if (ch == ')') {
                 i++;
                 int num = parseNum();
                 Map<String,Integer> topMap = stack.pop();
                 Map<String,Integer> peekMap = stack.peek();
                 for (Map.Entry<String,Integer> entry:topMap.entrySet()) {
                     String atom = entry.getKey();
                     int value = entry.getValue();
                     peekMap.put(atom,peekMap.getOrDefault(atom,0) + value * num);
                 }
             } else {
                 String atom = parseAtom();
                 int num = parseNum();
                 Map<String,Integer> peekMap = stack.peek();
                 peekMap.put(atom, peekMap.getOrDefault(atom,0) + num);
             }
        }
        Map<String, Integer> map = stack.peek();
        TreeMap<String ,Integer> treeMap = new TreeMap<>(map);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            sb.append(atom);
            int value = entry.getValue();
            if (value > 1){
                sb.append(value);
            }
        }
        return sb.toString();
    }
    public String parseAtom() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            stringBuffer.append(formula.charAt(i++));
        }
        return stringBuffer.toString();
    }
    public int parseNum() {
        int sum = 0;
        if (i == n || !Character.isDigit(formula.charAt(i))) {
             return 1;
        }
        while (i < n && Character.isDigit(formula.charAt(i))) {
             sum =  sum * 10 + formula.charAt(i++) - '0';
        }
        return sum;
    }
}
