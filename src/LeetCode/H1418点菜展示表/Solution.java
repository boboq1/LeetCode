package LeetCode.H1418点菜展示表;

import java.util.*;

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> foodNameList = new ArrayList<>();//食物清单
        List<Integer> ids = new ArrayList<>();//餐桌号清单
        Map<Integer,Map<String,Integer>> idFoodCount = new HashMap<>();
        List<List<String>> foodShow = new ArrayList<>();//菜单展示
        Set<String> foodNameSet = new HashSet<>();
        Set<Integer> idSet = new HashSet<>();
        //获得食物清单并按字母排序
        for (List<String> order : orders) {
            String foodName = order.get(2);
            String id = order.get(1);
            foodNameSet.add(foodName);
            idSet.add(Integer.parseInt(id));
            Map<String, Integer> foodCount = idFoodCount.getOrDefault(Integer.parseInt(id), new HashMap<>());
            foodCount.put(foodName,foodCount.getOrDefault(foodName,0) + 1);
            idFoodCount.put(Integer.parseInt(id),foodCount);
        }
        int n = idSet.size();
        int foodSize = foodNameSet.size();
        for (Integer id : idSet) {
            ids.add(id);
        }
        for (String foodName : foodNameSet) {
            foodNameList.add(foodName);
        }
        Collections.sort(foodNameList);
        Collections.sort(ids);

        //将Table和foodName加入foodShow第一行
        List<String> firstLine = new ArrayList<>();
        firstLine.add("Table");
        firstLine.addAll(foodNameList);
        foodShow.add(firstLine);

        //添加订单数量
        for (int i = 0; i < n; i++) {
            List<String> item = new ArrayList<>();
            item.add(String.valueOf(ids.get(i)));
            for (int j = 0; j < foodSize; j++) {
                item.add(String.valueOf(idFoodCount.get(ids.get(i)).getOrDefault(foodNameList.get(j),0)));
            }
            foodShow.add(item);
        }
        return foodShow;
    }
}
