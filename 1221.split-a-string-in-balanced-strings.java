/*
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

返回可以通过分割得到的平衡字符串的最大数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
 tag:贪心算法
*/

/*
 类似判断有效括号题目的简化版，第一反应用栈。
 考虑一下因为是判断可分割个数，而不是字符串是否平衡，所以不需要用栈，但是思路类似。
*/

class Solution {
    public int balancedStringSplit(String s) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == 'R') {
                sum ++;
            } else {
                sum --;
            }
            if (sum == 0) {
            	//每当sum为0，意味着组成了一个有效的平衡串
                result ++;
            }
        }
        
        return result;
    }
}