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


  //这道题 看着实际上找的是字符串 也可以找数字 反正只要是带顺序的数组就可以用erfenchazhao
  public char nextGreatest(char[] letters,char target){
    int left= 0;
    int right = letters.length-1;
    while (left<=right){
      int mid= (left+right)/2;
      if(letters[left]<=target){
        left= mid+1;
      }else{
        right = mid-1;
      }
    }
    //这样返回的原因就是 只要left最后一个left的字符串比target 小 +1之后就是大于他的最后的结果就是left == right的时候 left当前值 一定是大于target的 如果没有值的话 left最后就是和长度一样大了

    return letters[left%letters.length];
  }
}
