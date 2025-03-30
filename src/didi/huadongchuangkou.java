package didi;

import java.util.LinkedList;
import java.util.Queue;

public class huadongchuangkou {

    private Queue<Long> queeue =new LinkedList<>();
    private long widowsTime;
    private int windowsize;
    public boolean huadongchuangkou(){
        long currentTime=System.currentTimeMillis();
        //只要当前时间和队列第一个比较在时间窗口之外 那就是没问题了  这个队列的队首就可以移出去了
        while(!queeue.isEmpty() && currentTime-queeue.peek()>widowsTime){
            queeue.poll();
        }
        //如果这时候的队列里面元素的数量小于 规定的那现在 当前这次登录就可以入队列了
        if(queeue.size()<windowsize){
            queeue.offer(currentTime);
            return true;
        }
        return false;
    }

    /**
     * local key = KEYS[1]
     * local now = tonumber(ARGV[1])
     * local windowStart = now - tonumber(ARGV[2]) * 1000
     * local maxAttempts = tonumber(ARGV[3])
     *
     * redis.call('ZADD', key, now, now)
     * redis.call('ZREMRANGEBYSCORE', key, 0, windowStart)
     * redis.call('EXPIRE', key, ARGV[2])
     *
     * local count = redis.call('ZCARD', key)
     *
     * return count <= maxAttempts
     * @return
     */

}
