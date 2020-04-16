package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @date:2020/4/1
 */
public class day40 {

  public static void main(String[] args) {
    String a="I am a student.";
    String s = ReverseSentenceV3(a);
    System.out.println(s);
  }
  public String ReverseSentence(String str){
    if(str.trim().equals("") || str==null){
      return str;
    }
    String[] s = str.split(" ");
    String []fan = fan(s, 0, s.length - 1);
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<fan.length;i++){
      sb.append(fan[i]).append(" ");
    }
    return sb.substring(0,sb.length()-1).toString();
  }




  public String[] fan(String [] a,int start,int end){

    String tmq;
    while (start<end){

      tmq=a[start];
      a[start]=a[end];
      a[end]=tmq;
      start++;
      end--;
    }
    return a;
  }

  public String ReverseSentenceV2(String str) {
    if(str.trim().equals("")){
      return str;
    }
    String[] a = str.split(" ");
    StringBuffer o = new StringBuffer();
    int i;
    for (i = a.length; i >0;i--){
      o.append(a[i-1]);
      if(i > 1){
        o.append(" ");
      }
    }
    return o.toString();
  }

  public static String ReverseSentenceV3(String str) {
    if(str.trim().equals("")){
      return str;
    }
    String[] a = str.split(" ");
    StringBuffer o = new StringBuffer();
    int i;
    for (i = a.length-1; i >=0;i--){
      o.append(a[i]);
      if(i!=0){
        o.append(" ");
      }

    }
    return o.toString();
  }
}
