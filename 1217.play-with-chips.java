/*
数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。

你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：

将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
最开始的时候，同一位置上也可能放着两个或者更多的筹码。

返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/play-with-chips
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
 tag:贪心算法
*/

/*
 就是描述难以理解，题目本身也没什么难度。
*/

class Solution {
    public int minCostToMoveChips(int[] chips) {
        int number = 0;
        for (int i : chips) {
            if (i % 2 == 0) {
                number++;
            }
        }
        if (number > chips.length / 2) {
            return chips.length - number;
        } else {
            return number;
        }
    }
}
