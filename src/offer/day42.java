package offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class day42 {

    public int Add(int num1, int num2) {

        /**
         * 求两个数字相加的和 首先就是求出他们两个数相加的个位  之后 求出他的进位  比如 十进制的时候进位 是1  就要 成10 变成 10  这样 进位和个位相加就是最后的结果了
         */
        while (num2 != 0) {
            int tmq = num1 ^ num2;//通过异或 可以求出两个数相加之后的各位的值
            num2 = (num1 & num2) << 1;  //通过 两个数字 与操作 之后左移一位可以求出 两个数相加的进位
            num1 = tmq;
        }
        return num1;
    }
}


