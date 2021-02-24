package LeetCode.账户合并;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) return accounts;
        Map<String,Integer> emailToIndex = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();
        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!emailToIndex.containsKey(account.get(i))){
                    emailToIndex.put(account.get(i),count++);
                    emailToName.put(account.get(i),name);
                }
            }
        }
        UnionFind uf = new UnionFind(count);
        for (List<String> account : accounts) {
            String firstName = account.get(1);
            int firstIndex = emailToIndex.get(firstName);
            for (int i = 2; i < account.size(); i++) {
                int sencondIndex = emailToIndex.get(account.get(i));
                uf.union(firstIndex,sencondIndex);
            }
        }
        Map<Integer,List<String>> indexToEmails = new HashMap<>();
        for (String email:emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String > account = indexToEmails.getOrDefault(index,new ArrayList<>());
            account.add(email);
            indexToEmails.put(index,account);
        }
        List<List<String>> mergedAccount = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            mergedAccount.add(account);
        }
        return mergedAccount;
        }
        //并查集合算法：适用于两个及其以上的有交集的集合的合并
    class UnionFind{
        int[] parent;
        //这里以数组里的每个元素代表节点
        //根节点就是一个集合中下标与其值相同的那个节点，集合中其他节点的值就是根节点的下标，代表他们同属一个集合
        //注意：并不代表一个集合中用数组表示的所有元素的值都相同，在两个有交集的集合合并时，会出现有两个不同的值的情况，
        //例如: 三个下标为0,1,2其初始值分别为0，1，2的元素同属一个集合，以[0,0]为根节点合并后其值均为0,
        // 而三个下标分别为3，2，4其初始值分别为3，0，4的三个元素同属一个集合时，以[3,3]为根节点合并后三个值分别为3，0，3，
        // 而其与第一个有交集所以两个集合可以合并为一个，则第一个集合中的根节点则变为[0,3]既其值指向第二个集合的根节点的下标

        //初始时以parent的每个元素为一个个单独的元素，此时每个集合的根节点为其本身既是其下标与其值相同
        public UnionFind(int count){
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }
        //合并
        public void union(int index1,int index2){
            //左边找到一个集合的根节点的下标并将其值赋值为index1的根节点的下标，
            // 这两个集合就合并为一个并以index1的根节点作为新集合的根节点
            parent[find(index2)] = find(index1);
        }
        //查找一个集合的根节点的下标，根节点的下标与其对应的值相同
        public int find(int index){
            if (parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
