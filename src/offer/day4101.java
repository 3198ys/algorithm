package offer;

/**
 *求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 这道题的做法就是利用短路与 和  递归来做 递归就是 n+solition(n-1)来打带  数据相加的效果
 */
public class day4101 {

    public int Sum_Solution(int n) {

        int ans=n;
        boolean t=(ans!=0) && ((ans+=Sum_Solution(n-1))!=0);
        return ans;
    }
}
