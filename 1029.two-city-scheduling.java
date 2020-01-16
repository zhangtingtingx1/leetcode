/*
公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。

返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。

 

示例：

输入：[[10,20],[30,200],[400,50],[30,20]]
输出：110
解释：
第一个人去 A 市，费用为 10。
第二个人去 A 市，费用为 30。
第三个人去 B 市，费用为 50。
第四个人去 B 市，费用为 20。

最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-city-scheduling
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
tag:贪心算法
*/

/*
 1. 首先是思路，假设我们把所有人送往B市，再选择若干人送往A市。
 	对于那些去B比去A越贵的人，让他们去A市越能省钱。
 	所以我们按o[1]-o[0]也就是去B花费与去A花费的差值从小到大排序，前一半送往B市，后一半送往A市。
 	这也是个典型的贪心算法思路。

 2. 然后是具体实现。
 	2.1 熟悉利用Comparator给二维数组排序的思路。
 	2.2 for循环我本来想遍历 costs.length 次，看了别人的题解意识到可以
 		少循环一半。
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[1] - o[0]));
        int groupCount = costs.length/2;
        for (int i = 0; i < groupCount; i++) {
            sum += costs[i][1] + costs[i + groupCount][0];
        }
        return sum;
    }
}