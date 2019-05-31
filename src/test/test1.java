package test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(LocalDate.now().toString());
        System.out.println(sdf.format(new Date()));
    }
}
