package leetcode.贪心算法;

import java.util.Arrays;

/**
 * @Author ys 2020/12/18
 *
 * @description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *     <p>对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j
 *     分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
使用贪心算法来做 饼干数组 和人数组要升序排序 之后 通过饼干最小的去找满足人最小的 把大尺寸的饼干流到最后哦
 */
public class ques455 {
  public int findContentChildren(int[] g, int[] s) {

    if(g == null || s == null) return 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int grid=0;
    int size=0;
    while (grid<g.length && size<s.length){
      if(g[grid]<=s[size]){
        grid++;
      }
      size++;
    }
    return grid;
  }


  public int findContentChildrenV2(int[] g, int[] s) {

    if(g==null || s==null){
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);

    int grid=0;
    int size=0;
    while (grid<g.length && size<s.length){
      if(g[grid]<=s[size]){
        grid++;
      }
      size++;
    }
    return grid;

  }
}
