package LeetCode.账户合并;

import java.util.*;

public class Solution1_27 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) return accounts;
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!emailToIndex.containsKey(account.get(i))) {
                    emailToIndex.put(account.get(i),count++);
                    emailToName.put(account.get(i),name);
                }
            }
        }
        UnionFind uf = new UnionFind(count);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int lastIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex,lastIndex);
            }
        }
        Map<Integer,List<String>> indextToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indextToEmails.getOrDefault(index,new ArrayList<>());
            account.add(email);
            indextToEmails.put(index,account);
        }
        List<List<String>> mergedAccount = new ArrayList<>();
        for (List<String> emails : indextToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            mergedAccount.add(account);
        }
        return mergedAccount;
    }
    public class UnionFind{
        int[] parent;
        public UnionFind(int count){
            parent= new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }
        public void union(int index1,int index2) {
            int num1 = find(parent[index1]);
            parent[find(index2)] = num1;
        }
        public int find(int index){
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

    }
}
