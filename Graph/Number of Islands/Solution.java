import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;

        Node() {
            this.x = 0;
            this.y = 0;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == '0') {
                        visited[i][j] = true;
                        continue;
                    }
                    count++;
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Node temp = q.remove();
                        int row = temp.x;
                        int col = temp.y;

                        int[] delx = { -1, 0, 1, 0 };
                        int[] dely = { 0, 1, 0, -1 };
                        for (int k = 0; k < 4; k++) {
                            int nrow = row + delx[k];
                            int ncol = col + dely[k];
                            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                                q.add(new Node(nrow, ncol));
                                visited[nrow][ncol] = true;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid));
    }
}