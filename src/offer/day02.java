package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
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
