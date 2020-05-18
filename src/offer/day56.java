package offer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class day56 {


    private int index;
    int[] hash=new int[256];

    public day56(){
        for(int i=0;i<256;i++){
        hash[i]=-1;
         }
        index=0;
    }

    /**
     * 插入的时候如果该位置的值==-1说明是第一次出现 直接赋给index的值 这时候index代表他是出现的下表 如果已经大于0说明他已经出现过了 则变为-2就行
     *
     */
    public void Insert(char ch)
    {

        if(hash[ch]==-1){
            hash[ch]=index;
        }else if(hash[ch]>=0){
            hash[ch]=-2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        char tmq='\0';
        int min=Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(hash[i]>=0&& hash[i]<min){
                tmq=(char)i;
                min=hash[i];
            }
        }
        if(tmq=='\0'){
            return '#';
        }
        return tmq;
    }
}
