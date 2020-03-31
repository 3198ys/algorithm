package jichu;

import java.io.*;

public class duquwenjian {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        try(
                FileInputStream fileInputStream=new FileInputStream("D:\\abc.txt");
                BufferedInputStream bs=new BufferedInputStream(fileInputStream);
                FileOutputStream filterOutputStream=new FileOutputStream("D:\\abc1.txt");
                BufferedOutputStream bof=new BufferedOutputStream(filterOutputStream);
                ){
            int size;
            byte []buf=new byte[1024];
            while ((size=bs.read(buf))!=-1){
                bof.write(buf,0,size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
