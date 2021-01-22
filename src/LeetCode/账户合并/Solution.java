package LeetCode.账户合并;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) return accounts;
        Map<String, Integer> names = new HashMap<>();
        List<List<String>> accountsHasMerge = new ArrayList<>();

        return accountsHasMerge;
    }
    class UnionFind{
        int[] parent;
        public UnionFind(int count){
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }
        public void union(int index1,int index2){
            parent[parent[index2]] = find(index1);
        }
        public int find(int index){
            if (parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
