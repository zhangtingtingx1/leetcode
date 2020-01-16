/*
楼下水果店正在促销，你打算买些苹果，arr[i] 表示第 i 个苹果的单位重量。

你有一个购物袋，最多可以装 5000 单位重量的东西，算一算，最多可以往购物袋里装入多少苹果。

 

示例 1：

输入：arr = [100,200,150,1000]
输出：4
解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/how-many-apples-can-you-put-into-the-basket
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
 tag:贪心算法
*/

/*
 一开始以为是最大重量，结果是最大个数，那就没有任何难度了，从小到大放就行。这题太水了。
*/

class Solution {
    public int maxNumberOfApples(int[] arr) {
        int sum = 0;
        int weight = 0;
        Arrays.sort(arr);
        for (int item : arr) {
            weight += item;
            if (weight > 5000) {
                break;
            } else {
                sum++;
            }
        }
        return sum;
    }
}