package leetcode.二分查找;

/**
 * @Author ys 2021/2/8
 *
 * @description 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *     <p>在比较时，字母是依序循环出现的。举个例子：
 *     <p>如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *     <p>来源：力扣（LeetCode）
 *
 */
public class ques744 {

  public static void main(String[] args) {

    char c[]=new char[]{'c','f','j'
    };
    char c1 = nextGreatestLetter(c, 'c');
    System.out.println(c1);
  }

  public static char nextGreatestLetter(char[] letters, char target) {

    int l=0;int r=letters.length;

    while (l<r){
      int mid=(l+r)/2;
      if(letters[mid]<=target){
        l=mid+1;
      }else{
        r=mid-1;
      }
    }

    //加这个取模的原因就是  题目中的没找到循环取值的那个要求
    return letters[l%letters.length];
  }
}
