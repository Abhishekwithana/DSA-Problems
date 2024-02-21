/**
 * Leetcode Link : https://leetcode.com/problems/furthest-building-you-can-reach/description
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        for(i = 0; i < n - 1; i++) {
            if(heights[i + 1] - heights[i] < 0) continue;

            int diff = heights[i + 1] - heights[i];

            if(bricks >= diff) {
                bricks -= diff;
                pq.offer(diff);
            }else if(ladders > 0) {
                if(!pq.isEmpty() && pq.peek() > diff) {
                    bricks += pq.poll();
                    bricks -= diff;
                    pq.offer(diff);
                }
                ladders--;
            }else {
                break;
            }
        }
        return i;
    }
}
