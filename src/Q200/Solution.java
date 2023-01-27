package Q200;

import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        LinkedList<List<Integer>> bfsQueue = new LinkedList<>();
        int num_islands = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    bfsQueue.add(Arrays.asList(i, j));
                    grid[i][j] = 'x';
                    while (! bfsQueue.isEmpty()) {
                        List<Integer> node = bfsQueue.getFirst();
                        bfsQueue.removeFirst();
                        if (node.get(0) + 1 < grid.length && grid[node.get(0)+1][node.get(1)] == '1') {
                            bfsQueue.addLast(Arrays.asList(node.get(0)+1, node.get(1)));
                            grid[node.get(0)+1][node.get(1)] = 'x';
                        }
                        if (node.get(0) - 1 >= 0 && grid[node.get(0)-1][node.get(1)] == '1') {
                            bfsQueue.addLast(Arrays.asList(node.get(0)-1, node.get(1)));
                            grid[node.get(0)-1][node.get(1)] = 'x';
                        }
                        if (node.get(1) + 1 < grid[0].length && grid[node.get(0)][node.get(1)+1] == '1') {
                            bfsQueue.addLast(Arrays.asList(node.get(0), node.get(1)+1));
                            grid[node.get(0)][node.get(1)+1] = 'x';
                        }
                        if (node.get(1) - 1 >= 0 && grid[node.get(0)][node.get(1)-1] == '1') {
                            bfsQueue.addLast(Arrays.asList(node.get(0), node.get(1)-1));
                            grid[node.get(0)][node.get(1)-1] = 'x';
                        }
                    }
                }
                bfsQueue = new LinkedList<>();
                /*
                for (int m=0;m<grid.length;m++) {
                    for (int n = 0; n < grid[0].length; n++) {
                        System.out.print(grid[m][n]);
                    }
                    System.out.print('\n');
                }
                System.out.print('\n');
                */
            }
        }
        return num_islands;
    }
}