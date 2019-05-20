package com.Solution.Search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class minPathLengthByBFS_template {
    /**
     * 自定义静态内部类表示坐标
     * @param <K>
     * @param <V>
     */
  private static class Pair <K,V> implements Map.Entry<K,V> {
        private K key;
        private V value;
        Pair(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public Object setValue(Object value) {
            return null;
        }
    }

    public int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//方向：上、下、左、右
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));//源点压入队列
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();//cr：当前行  cc：当前列
                grids[cr][cc] = 0; // 标记grids该坐标位置元素已经被访问过了
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    //出界或者元素已被访问，则继续下一轮循环
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0) {
                        continue;
                    }
                    //到达目标位置，返回路径长度
                    if (nr == tr && nc == tc) {
                        return pathLength;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

}
