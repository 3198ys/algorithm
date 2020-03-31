package offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class day39 {
    public static void main(String[] args) {
        String a="abcdefg";
        String c=LeftRotateStringV2(a,2);

        System.out.println(c);


    }



    public String LeftRotateString(String str,int n) {
        char[] chars=new char[str.length()];
        for(int i=0;i<str.length();i++){
            int tmq=i-n;
            if(tmq<0){
                tmq=str.length()+tmq;
            }
            chars[tmq]=str.charAt(i);
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 这道题主要考察的就是   数组的  翻转  利用三次翻转 来达到 数组的左移
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateStringV2(String str,int n) {
        int len=str.length();
        if(0==len || n==0){
            return str;
        }
        n=n%len;
        char[] chars=str.toCharArray();
        fun(chars,0,n-1);
        fun(chars,n,len-1);
        fun(chars,0,len-1);

        return new String(chars);

    }

    /**
     * 数组的翻转 很好用 要记住
     * @param str
     * @param start
     * @param end
     */
    public static  void fun(char []str,int start,int end){
        char tmq;
        while (start<end){
            tmq=str[start];
            str[start]=str[end];
            str[end]=tmq;
            start++;
            end--;
        }
    }
}
