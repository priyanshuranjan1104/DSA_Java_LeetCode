class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int energy = 0;
        int current = 0;
        
        for (int[] task : tasks) {
            if (current < task[1]) {
                energy += task[1] - current;
                current = task[1];
            }
            current -= task[0];
        }
        
        return energy;
    }
}