/*
给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。

示例 1：

输入：["cba", "daf", "ghi"]
输出：1
解释：
当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
tag:贪心算法
*/

/*
 这个题目除了描述很绕，看不到难点在哪里，贪心的说服力也不是很够。
*/

class Solution {
    public int minDeletionSize(String[] A) {
        int sum = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                char current = A[j].charAt(i);
                char next = A[j+1].charAt(i);
                if (current > next) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}