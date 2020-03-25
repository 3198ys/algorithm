package arraydemo;

import java.util.Comparator;

public class peopple implements Comparable<peopple> {

    private String name;
    private Integer status;
    private Integer type;

    public peopple(Integer status, Integer type) {
        this.status = status;
        this.type = type;
    }

    public peopple(String name, Integer status, Integer type) {
        this.name = name;
        this.status = status;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    @Override
//    public int compare(peopple o1, peopple o2) {
//        if(o1.getStatus()==o2.getStatus()){
//            return o1.getType()-o2.getType();
//        }else{
//            return o2.getStatus()-o1.getStatus();
//        }
//    }

    @Override
    public int compareTo(peopple peopple) {
        if(status==peopple.getStatus()){

            return type-peopple.getType();
        }else{
            return peopple.status-status;
        }
    }
}
