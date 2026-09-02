import java.util.PriorityQueue;

class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    boolean[] present;
    int current;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        present = new boolean[1001];

        current = 1;

        for (int i = 1; i <= 1000; i++) {
            present[i] = true;
        }
    }

    public int popSmallest() {
        int smallest = pq.isEmpty() ? current : pq.poll();

        if (smallest == current) {
            current++;
        }

        present[smallest] = false;

        return smallest;
    }

    public void addBack(int num) {
        if (!present[num]) {
            if (num < current) {
                pq.offer(num);
            }

            present[num] = true;
        }
    }
}