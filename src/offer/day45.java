package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @descripti将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @date:2020/4/23
 */
public class day45 {

  public int strToint(String str){
    if(str==null){
      return 0;
    }
    int result=0;
    boolean negative=false;
    int i=0,len=str.length();
    int limit=-Integer.MAX_VALUE ;//判断是否溢出用de

    int mulimin;
    int digit;
    if(len>0){
      char firstCharr=str.charAt(0);
      if(firstCharr<'0'){
        if(firstCharr == '-'){
          negative=true;
          limit=Integer.MIN_VALUE;
        }else if(firstCharr!='+'){
          return 0;
        }
        if(len==1){
          return 0;
        }
        i++;
      }

      mulimin=limit/10;
      while (i<len){
        digit=str.charAt(i++)-'0';
        if(digit<0 || digit>9){
          return 0;
        }
        if(result<mulimin){
          return 0;
        }
        result*=10;
        if(result<limit+digit){
          return 0;
        }
        result-=digit;
      }
    }else{
      return 0;
    }
  return negative?result:-result;
  }
}
