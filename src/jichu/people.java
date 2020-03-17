package jichu;

public class people {
    private String name;
    public String age;

    public people(String name,String age){
        this.age=age;
        this.name=name;
    }

    public void sayHi(String name){
        System.out.printf("你好"+name);
    }

    private String saya(String age){
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
