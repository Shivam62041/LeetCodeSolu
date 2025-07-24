class Solution {
    int time = 0;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int [] xorSubTree = new int[n];
        int [] inTime = new int[n];
        int [] outTime = new int[n];
        int totalXor = DFS(0, -1, graph, nums, xorSubTree, inTime, outTime);
        List<Integer> subTreeRoots = new ArrayList<>();
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            subTreeRoots.add(inTime[u] > inTime[v] ? u : v);
        }
        int minScore = Integer.MAX_VALUE;
        int m = subTreeRoots.size();
        for (int i = 0; i < m; i++){
            for (int j = i + 1; j < m; j++){
                int u = subTreeRoots.get(i);
                int v = subTreeRoots.get(j);
                int a, b, c;
                if (find(u, v, inTime, outTime)){
                    a = xorSubTree[v];
                    b = xorSubTree[u] ^ xorSubTree[v];
                    c = totalXor ^ xorSubTree[u];
                } else if (find(v, u, inTime, outTime)){
                    a = xorSubTree[u];
                    b = xorSubTree[v] ^ xorSubTree[u];
                    c = totalXor ^ xorSubTree[v];
                } else {
                    a = xorSubTree[u];
                    b = xorSubTree[v];
                    c = totalXor ^ xorSubTree[u] ^ xorSubTree[v];
                }
                int score = Math.max(Math.max(a, b), c) - Math.min(Math.min(a, b), c);
                minScore = Math.min(minScore, score);
            }
        }
        return minScore;
    }
    private int DFS(int u, int parent, List<List<Integer>> graph, int[] nums, int[] xorSubTree, int[] inTime, int[] outTime) {
        int xor = nums[u];
        inTime[u] = time++;
        for (int v : graph.get(u)){
            if (v != parent){
                xor ^= DFS(v, u, graph, nums, xorSubTree, inTime, outTime);
            }
        }
        outTime[u] = time;
        xorSubTree[u] = xor;
        return xor;
    }
    private boolean find(int u, int v, int[] inTime, int[] outTime){
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}