package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @date:2020-01-06
 */
public class day02 {

  public String replaceSpace(StringBuffer str) {

    StringBuffer sb=new StringBuffer();
    for(int i=0;i<str.length();i++){
      if(str.charAt(i)==' '){

        sb.append("%20");
      }else{
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }


}
