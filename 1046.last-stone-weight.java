/*
有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

 

提示：

1 <= stones.length <= 30
1 <= stones[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/last-stone-weight
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
 tag:堆；贪心算法
*/

/*
 第一反应还是每次操作都排序一次，因为数组length比较小所以速度还挺快，
 但是一旦length较大就非常容易超时。
 时间复杂度O(n*logn)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        int l = stones.length - 1;
        int i = stones.length - 1;
        while (i > 0) {
            Arrays.sort(stones);
            stones[l - 1] = stones[l] - stones[l - 1];
            stones[l] = 0;
            i--;
        }
        Arrays.sort(stones);
        return stones[l];
    }
}

/*
 这题目主要还是用来熟悉堆操作。
 Java中的PriorityQueue可以实现。
 关于PriorityQueue：https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x > y) {
                pq.offer(x - y);
            }
        }
        
        return pq.size() == 1 ? pq.peek() : 0;
    }
}

