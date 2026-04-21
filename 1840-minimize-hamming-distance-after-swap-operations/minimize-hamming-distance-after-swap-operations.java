class Solution {
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        
        UnionFind uf = new UnionFind(n);

        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        Map<Integer, List<Integer>> groups = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }
        
        int result = 0;
        
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();
            
            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }
            
            for (int idx : group) {
                int val = target[idx];
                
                if (freq.getOrDefault(val, 0) > 0) {
                    freq.put(val, freq.get(val) - 1);
                } else {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    class UnionFind {
        int[] parent;
        
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }
        
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }
}