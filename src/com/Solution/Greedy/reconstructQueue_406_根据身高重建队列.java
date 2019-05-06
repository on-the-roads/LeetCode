package com.Solution.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 思路：贪心思想
 * 思路1：自己最初思考的方法，复杂度较高。先根据k值升序、身高升序对数组进行排列，然后从前往后遍历，对每一个学生，都将其与排在其前面的学生进行比较，
 * 根据k值判断其是否出现在正确的位置上，若不正确则进行移位处理。
 * 思路2：优化后的算法,对数组按身高降序，k值升序进行排序（先放置身高较高的学生，这样后面插入身高较矮的学生对k值的影响不大），然后将学生按照其对应的k值放置。这里用到了ArrayList 的add(index,element)方法
 */
public class reconstructQueue_406_根据身高重建队列 {
    //思路1
//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1]==0?o1[0] - o2[0]:o1[1] - o2[1];//k值升序、身高升序
//            }
//        });
//        for (int i = 0; i < people.length; i++) {
//            int cnt = 0;
//            int val = people[i][1];
//            int key = people[i][0];
//            for (int j = 0; j < i; j++) {//与排在其前面的学生进行比较
//                if (key <= people[j][0])//如果排在其前面的学生身高>=其身高，计数器加1
//                    cnt++;
//                if (cnt > val) {//如果计数器的值>该学生的k值,则将该学生位置与前面的学生位置进行交换
//                    swap(people, i, j );
//                    continue;
//                }
//            }
//        }
//        return people;
//    }

//    private void swap(int[][] people, int i, int j) {
//        int temp = people[i][0];
//        people[i][0] = people[j][0];
//        people[j][0] = temp;
//        temp = people[i][1];
//        people[i][1] = people[j][1];
//        people[j][1] = temp;
//    }

    //思路2
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];//身高降序，k值升序
                    }
                }
        );
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] test = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = new reconstructQueue_406_根据身高重建队列().reconstructQueue(test);

    }
}
