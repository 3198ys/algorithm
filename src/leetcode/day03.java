package leetcode;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class day03 {
    public static void main(String[] args) {
        int abcabcbb = huadongchuangkou("abcabcbb");
        System.out.println(abcabcbb);
    }
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int n=chars.length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){

                boolean isone = isone(chars, i, j);
                if(isone){
                    max=Math.max(max,j-i);
                }
            }
        }
        return max;
    }

    public boolean isone(char[] chars,int i,int j){
        HashSet<Character>  set=new HashSet<>();
        for(int k=i;k<j;k++){
            if(!set.contains(chars[k])){
                set.add(chars[k]);
            }else{
                return false;
            }
        }
        return true;
    }

    public static int huadongchuangkou(String s){
        HashSet<Character> set=new HashSet<>();
        char[] chars = s.toCharArray();
        int i=0,max=0,j=0;
        while (i<chars.length && j<chars.length){
            if(!set.contains(chars[j])){
                set.add(chars[j++]);
                max=Math.max(max,j-i);
            }else{
                //移动窗口
                set.remove(chars[i++]);
            }
        }
        return max;
    }
}
