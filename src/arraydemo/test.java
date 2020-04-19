package arraydemo;

import java.io.File;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {
    final int a=1;
    public static void main(String[] args) {

        ArrayList<String> list=new ArrayList<>();
        Map<Integer,String> map=new HashMap<>();
        File file = new File("D:\\danci");
//        readFiels(file,map,0);
//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext())
//        {
//            Map.Entry<Integer, String> next = iterator.next();
//            System.out.println(next.getKey()+":"+next.getValue());
//        }
        readFiles1(file,list);
        int count=1;
        int day=1;



        Map<Integer,List<String>> map1=new HashMap<>();

        List<String> aa=new ArrayList<>();
        for(String a:list)
        {


            if(count%10==0)
            {
               map1.put(day,aa);
                day++;
                aa=new ArrayList<>();
            }
            aa.add(a);
            count++;


        }

        Iterator<Map.Entry<Integer, List<String>>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, List<String>> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }

    public static void readFiels(File path, Map<Integer,String> fileNameList,int day)
    {

        if(path.isDirectory())
        {
            File[] files = path.listFiles();
            if(files!=null&&files.length>0)
            {
                for(File file1:files)
                {
                    if(file1.isDirectory())
                    {
                       day++;
                        readFiels(file1,fileNameList,day);
                    }else
                    {
                        fileNameList.put(day,file1.getPath());
                    }
                }
            }
        }else {
            fileNameList.put(day,path.getPath());
        }
    }


    public static void readFiles1(File file, ArrayList<String> fileNameList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    readFiles1(files[i], fileNameList);
                } else {

                    if(files[i].getPath().split("\\.")[1].equals("png"))
                    {

                        fileNameList.add(files[i].getPath());
                    }

                }
            }
        } else {

            if(file.getPath().split("\\.")[1].equals("png"))
            {
                fileNameList.add(file.getPath());

            }
        }
    }

    public void aaa(){

    }

}
