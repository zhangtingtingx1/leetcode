/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

示例 1：

输入：[5,5,5,10,20]
输出：true
解释：
前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。

来源：力扣（LeetCode）
链接：https://dev.lingkou.xyz/problems/lemonade-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
tag:贪心算法
*/

/*
 看到贪心算法想得复杂了，其实很简单的一道题。
 贪心算法归根结底是一种思想，即每一步都选择当前的最优解。本例中贪心的地方在于收到20元的时候优先找零10+5,而不是5x3。
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        for (int bill : bills) {
            if (bill == 5) {
                countFive++;
            } else if (bill == 10) {
                if (countFive == 0) {
                    return false;
                } else {
                    countFive--;
                    countTen++;
                }
            } else {
                if (countFive > 0 && countTen > 0) {
                    countFive--;
                    countTen--;
                } else if (countFive >= 3) {
                    countFive -=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}