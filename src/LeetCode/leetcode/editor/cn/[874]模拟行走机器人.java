//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法

package LeetCode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int x = 0, y = 0;
            int max = 0;
            //1.设置方向数组
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//四个方向
            //2.将障碍物放入Set中
            Set<String> obstaclesSet = new HashSet<>();
            for (int i = 0; i < obstacles.length; i++) {
                obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
            }
            int curDir = 0;
            int dir_x = 0,dir_y = 0;
            //3.判断
            for (int i = 0; i < commands.length; i++) {
                if (commands[i] == -1) {
                    curDir = (curDir + 1) % 4;
                } else if (commands[i] == -2) {
                    curDir = (curDir + 3) % 4;
                } else if (commands[i] > 0) {
                    for (int j = 1; j <= commands[i]; j++) {
                        //3.1判断方向
                         dir_x = x + dir[curDir][0];
                         dir_y = y + dir[curDir][1];
                        //3.2判断是否遇到障碍物
                        if (obstaclesSet.contains(dir_x + "," + dir_y)) {
                            break;
                        }else {
                            x = dir_x;
                            y = dir_y;
                            //3.3取最大值
                            max = Math.max(max,x*x+y*y);
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}