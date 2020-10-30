package arraydemo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
//        String s = Base64.getEncoder()
//            .encodeToString(
//                ("1" + "," + "hello")
//                    .getBytes(StandardCharsets.UTF_8));
//    System.out.println(s);

        String s="http://test1-kids.youdao.com/wx/index.html#/coupon/index?userCouponId=%s";
    System.out.println(String.format(s,"aa"));

//        String  a=null;
//    System.out.println(a);
//    a=a+"$"+"bbbbb";
//        String b="bbb";
////    System.out.printlln(b);
//        String[] split = a.split("\\$");
//        for(String a1:split){
//      System.out.println(a1);
//        }

    }
}
