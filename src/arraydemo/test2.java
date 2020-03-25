package arraydemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        ArrayList<peopple> list=new ArrayList<>();
        // a b c d
        list.add(new peopple("a",4,1));
        list.add(new peopple("c",4,2));
        list.add(new peopple("b",4,3));
        list.add(new peopple("d",4,0));

        Collections.sort(list);
        for(peopple p:list){
            System.out.println(p.getName());
        }
    }
}
