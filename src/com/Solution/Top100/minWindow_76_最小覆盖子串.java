package com.Solution.Top100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class minWindow_76_最小覆盖子串 {
    /**
     * 思路1：滑动窗口思路
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> dict = new HashMap();
        for (char ch : t.toCharArray()) {
            int val = dict.getOrDefault(ch, 0);
            dict.put(ch, val + 1);
        }
        int l = 0;
        int r = 0;
        int formed = 0;
        int[] arr = new int[]{-1, 0, 0};
        int size = dict.size();
        HashMap<Character, Integer> win = new HashMap();
        while (r < s.length()) {
            char cur = s.charAt(r);
            int val = win.getOrDefault(cur, 0);
            win.put(cur, val + 1);
            if (dict.containsKey(cur) && dict.get(cur).intValue() == win.get(cur).intValue())
                formed++;
            while (l <= r && formed == size) {
                if (arr[0] == -1 || r - l + 1 < arr[0]) {
                    arr[0] = r - l + 1;
                    arr[1] = l;
                    arr[2] = r;
                }
                char pre = s.charAt(l);
                win.put(pre, win.get(pre) - 1);
                if (dict.containsKey(pre) && dict.get(pre).intValue() > win.get(pre).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return arr[0] == -1 ? "" : s.substring(arr[1], arr[2] + 1);
    }

    /**
     * 对思路一做了优化，将S进行过滤，只包含在T中的字符
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        if(s.length()==0||t.length()==0) return "";
        HashMap<Character,Integer> dict=new HashMap();
        for(char ch:t.toCharArray()){
            int val=dict.getOrDefault(ch,0);
            dict.put(ch,val+1);
        }
        ArrayList<Pair<Integer,Character>> list=new ArrayList();
        //过滤
        for(int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            if(dict.containsKey(chs))
                list.add(new Pair(i,chs));
        }

        int l=0;
        int r=0;
        int formed=0;
        int[] arr=new int[]{-1,0,0};
        int size=dict.size();
        HashMap<Character,Integer> win=new HashMap();
        while(r<list.size()){
            char cur=list.get(r).getValue();
            int val=win.getOrDefault(cur,0);
            win.put(cur,val+1);
            if(dict.containsKey(cur)&&dict.get(cur).intValue()==win.get(cur).intValue())
                formed++;
            while(l<=r&&formed==size){
                int end=list.get(r).getKey();
                int start=list.get(l).getKey();
                if(arr[0]==-1||end-start+1<arr[0]){
                    arr[0]=end-start+1;
                    arr[1]=start;
                    arr[2]=end;
                }
                char pre=list.get(l).getValue();
                win.put(pre,win.get(pre)-1);
                if(dict.containsKey(pre)&&dict.get(pre).intValue()>win.get(pre).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return arr[0]==-1?"":s.substring(arr[1],arr[2]+1);
    }
}
