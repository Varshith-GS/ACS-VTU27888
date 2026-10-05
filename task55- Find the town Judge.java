class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];
        for (int[] t : trust) {
            int person = t[0];
            int judge = t[1];
            degree[person]--;
            degree[judge]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
