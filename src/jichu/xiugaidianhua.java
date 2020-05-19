package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 * @date:2020/5/19
 */
public class xiugaidianhua {
    public static void main(String[] args) {
        String phone="18712782695";
        phone=phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }
}
