package jichu;

/**
 * @Author ys 2021/4/1
 * @description
 */
public class teacher {

  private int age;

  public teacher(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "teacher{" +
        "age=" + age +
        '}';
  }
}
