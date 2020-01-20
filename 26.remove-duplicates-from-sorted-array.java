/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
 tag:双指针
 */

/*
 这道题目有两点值得注意：1. 数组是有序的；2.原地修改数组，且不关心修改后的数组后面的数值。
 这意味着我们可以使用双指针，以及一个用于比较的锚点tmp，快指针负责寻找与当前锚点不同的数值，并将寻找到的数值复制到慢指针所在的位置。
 当快指针遍历完数组，慢指针以前的所有数值都是不重复的。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int tmp = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) {
                continue;
            }
            nums[j] = nums[i];
            tmp = nums[j];
            j++;
        }
        return j;
    }
}