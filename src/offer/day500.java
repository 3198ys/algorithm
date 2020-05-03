package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *此题的解法主要就是分析 字符的下一个字符是否是* 之后分情况讨论   如果 当前的下一个字符是 * 则  分为两种情况
 * 第一种情况就是  str的当前字符和 pattern的当前字符相同  或者 pattern的当前字符是 . 这时候 还有三种情况 就是 *代表  0 1 或者多个
 * 如果是  0 的话  就pattern向后移动2位  1的话 str移动一位  pattern移动两位  多个的话  则 str移动一位  pattern不动
 * 第二种情况就是  str当前的不等于 pattern当前的  切 pattern也不等于 . 则 pattern直接 当做 *匹配0向后移动两位
 *
 *
 * 当 下一个字符不是 *的时候 直接匹配相同一起移动一位不相同返回false
 *
 *
 * @date:2020/5/3
 */
public class day500 {
  public boolean match(char[] str, char[] pattern)
  {

    if(str == null || pattern==null){
      return false;
    }
    int strStart=0;
    int patternStart=0;
    return digui(str,strStart,pattern,patternStart);
  }
  public boolean digui(char[] str,int strStart,char[] pattern,int patternStart){
    //二者同时结束所以返回true
    if(strStart == str.length && patternStart == pattern.length){
      return true;
    }
    if(strStart != str.length && patternStart == pattern.length){
      return false;
    }
    /***
     * 先判断 pattern下一个是否是 *
     */
    if((patternStart+1)<pattern.length && pattern[patternStart+1]=='*'){

      /**
       * 这个if是判断  str当前的值和pattern的当前值相同 或者 pattern的下一个是.
       */
      if((strStart!=str.length && str[strStart]==pattern[patternStart]) || (strStart!=str.length && pattern[patternStart]=='.')){
        /**
         * 分为三种情况  * 代表 0 1 多个 代表0 的时候   bbbba  pattern .*a*a 这个时候  第二个*就要代表0个
         */
        return digui(str,strStart+1,pattern,patternStart+2) || digui(str,strStart+1,pattern,patternStart) || digui(str,strStart,pattern,patternStart+2);
      }else{
        /**
         * 匹配不上的时候
         */
        return digui(str,strStart,pattern,patternStart+2);
      }
    }else{
      /**
       * pattern的下一个字符不是*
       */
      if((strStart!=str.length && str[strStart]==pattern[patternStart]) || (strStart!=str.length && pattern[patternStart]=='.')){
        return digui(str,strStart+1,pattern,patternStart+1);
      }else{
        return false;
      }
    }
  }
}
