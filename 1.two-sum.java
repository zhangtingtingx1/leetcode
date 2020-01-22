/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
 tag:数组；哈希表
*/

/*
 暴力思路是两层循环，使用 target-i 查找，时间复杂度O(n2)，代码就不写了。
*/

/*
 使用hashMap是降低查询复杂度的好方法，因为它的时间复杂度约为O(1)，我们可以使用HashMap的key和value分别存储数组的value和index，
 使用containsKey方法查找所需值。
*/

/*
 错误解答：忽略了数组元素相同的情况, fail case:[3,3]
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int key : map.keySet()) {
        	if (map.containsKey(target - key)) {
            	return new int[]{map.get(key), map.get(target - key)};
        	}
    	}
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*
 leetcode 官方的正确解答，思路是一样的。
 当index不同而value相同时，map会丢失一部分index，但是包含完整value，依然能够获得正确答案。
 但是需要注意循环判定条件需要使用原数组，而非map的keyset。
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}