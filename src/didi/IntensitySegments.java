package didi;
import java.util.*;


/**
 * 强度管理器
 */
public class IntensitySegments {

    private TreeMap<Integer, Integer> segments;

    public IntensitySegments() {
        segments = new TreeMap<>();
        segments.put(Integer.MIN_VALUE, 0);
    }

    /**
     * 在指定区间内增加value
     * @param from 区间开始(包含)
     * @param to 区间结束(不包含)
     * @param amount 增加的强度值
     */
    public void add(int from, int to, int amount) {
        //1.1 参数校验
        if (from >= to) return;

        //1.2 分别插入起始分段点和结束分段点
        addSegmentPoint(from);
        addSegmentPoint(to);

        // 1.3增加区间分段点value值 sub [)
        for (Map.Entry<Integer, Integer> entry : segments.subMap(from, to).entrySet()) {
            entry.setValue(entry.getValue() + amount);
        }

        //1.4 合并相邻相同强度的分段点
        mergeAdjacentSegmentWithSameValue();
    }

    /**
     * 设置指定区间内的value
     * @param from 区间开始(包含)
     * @param to 区间结束(不包含)
     * @param amount 设置的强度值
     */
    public void set(int from, int to, int amount) {
        //1.1 参数校验
        if (from >= to) return;

        //1.2 分别插入起始分段点和结束分段点
        addSegmentPoint(from);
        addSegmentPoint(to);

        // 1.3设置区间分段点value值
        for (Map.Entry<Integer, Integer> entry : segments.subMap(from, to).entrySet()) {
            entry.setValue(amount);
        }

        //1.4 合并相邻相同强度的分段点
        mergeAdjacentSegmentWithSameValue();
    }

    /**
     * 转换为字符串输出
     * @return 格式如"[[10,1],[30,0]]"的字符串
     */
    @Override
    public String toString() {
        List<int[]> result = new ArrayList<>();

        int i=0;
        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            int point = entry.getKey();
            int value = entry.getValue();
            i++;
            //1.1 起始值跳过
            if (point == Integer.MIN_VALUE) {
                continue;
            }
            //1.2 结束值插入0
            if(i == segments.size()){
                result.add(new int[]{point, 0});
            }else{
                //1.3 插入结果数组
                result.add(new int[]{point, value});

            }

        }
        return Arrays.deepToString(result.toArray());
    }


    /**
     * 插入分段点
     * @param point
     */
    private void addSegmentPoint(int point) {
        //1.1 判断是否已经存在分段点
        if (!segments.containsKey(point)) {
            //1.2取出分段点上一个分段点，并赋予当前分段点强度值
            int lowerValue = segments.floorEntry(point).getValue();
            segments.put(point, lowerValue);
        }
    }

    /**
     * 合并相邻的并且value值相同的分段点
     */
    private void mergeAdjacentSegmentWithSameValue() {
        List<Integer> toRemove = new ArrayList<>();
        Integer prevValue = null;

        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            //1.1 当前value与前一个value相同，插入待移除队列
            if (prevValue != null && entry.getValue().equals(prevValue)) {
                toRemove.add(entry.getKey());
            }
            //1.2当前值设置成前一个值
            prevValue = entry.getValue();
        }


        //1.3从map中移除
        for (Integer point : toRemove) {
            segments.remove(point);
        }
    }

    public static void main(String[] args) {
        // 第一个测试序列
        System.out.println("test demo1");
        IntensitySegments seg1 = new IntensitySegments();
        System.out.println(seg1.toString()); // []

        seg1.add(10, 30, 1);
        System.out.println(seg1.toString()); // [[10,1],[30,0]]

        seg1.add(20, 40, 1);
        System.out.println(seg1.toString()); // [[10,1],[20,2],[30,1],[40,0]]

        seg1.add(10, 40, -2);
        System.out.println(seg1.toString()); // [[10,-1],[20,0],[30,-1],[40,0]]

        // 第二个测试序列
        System.out.println("test demo2");
        IntensitySegments seg2 = new IntensitySegments();
        System.out.println(seg2.toString()); // []

        seg2.add(10, 30, 1);
        System.out.println(seg2.toString()); // [[10,1],[30,0]]

        seg2.add(20, 40, 1);
        System.out.println(seg2.toString()); // [[10,1],[20,2],[30,1],[40,0]]

        seg2.add(10, 40, -1);
        System.out.println(seg2.toString()); // [[20,1],[30,0]]

        seg2.add(10, 40, -1);
        System.out.println(seg2.toString()); // [[10,-1],[20,0],[30,-1],[40,0]]

        //  add时候在原来分段点两边
        System.out.println("test demo3");
        IntensitySegments seg3 = new IntensitySegments();
        System.out.println(seg3.toString()); // []

        seg3.add(10, 30, 1);
        System.out.println(seg3.toString()); // [[10,1],[30,0]]

        seg3.add(5, 40, 1);
        System.out.println(seg3.toString()); // [[5, 1], [10, 2], [30, 1], [40, 0]]

        //  add时候再原来分段点内部
        System.out.println("test demo4");
        IntensitySegments seg4 = new IntensitySegments();
        System.out.println(seg4.toString()); // []

        seg4.add(10, 30, 1);
        System.out.println(seg4.toString()); // [[10,1],[30,0]]

        seg4.add(15, 20, 1);
        System.out.println(seg4.toString()); // [[5, 1], [10, 2], [30, 1], [40, 0]]

        // set 测试
        System.out.println("test demo5");
        IntensitySegments seg5 = new IntensitySegments();
        System.out.println(seg5.toString()); // []

        seg5.set(10, 30, 1);
        System.out.println(seg5.toString()); // [[10,1],[30,0]]

        seg5.set(20, 40, 1);
        System.out.println(seg5.toString()); // [[10,1],[20,2],[30,1],[40,0]]



    }
}