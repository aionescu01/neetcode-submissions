class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int s: stones){
            heap.offer(-s);
        }

        while(heap.size()>1){
            int a = heap.poll();
            int b = heap.poll();
            if(b>a){
                heap.offer(a-b);
            }
        }
        heap.offer(0);
        return Math.abs(heap.peek());
    }
}
