class Solution {
    public int minimumBoxes(int n) {
        int base = 0;      
        int total = 0;     
        int row = 0;

        while (total + (row + 1) * (row + 2) / 2 <= n) {
            row++;
            total += row * (row + 1) / 2;
            base += row;
        }

        int extra = 0;
        while (total < n) {
            extra++;
            total += extra;
        }

        return base + extra;
    }
}