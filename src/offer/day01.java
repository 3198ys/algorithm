package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date:2020-01-03
 */
public class day01 {


  public  boolean Find(int target, int [][] array) {

    if(array==null || array.length==0 || array[0].length==0){
      return false;
    }
    int index=array[0].length-1;
    for(int i=0;i<array.length;i++){
      if(target<=array[i][index] && target>=array[i][0]){
        for(int j=0;j<=index;j++){
          if(target==array[i][j]){
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean find2(int target,int [][] array){
    if(array == null || array.length == 0 || array[0].length == 0){
      return false;
    }
    //先找到每行的长度
    int index = array[0].length-1;
    for(int i=0;i<array.length;i++){
      if(target >= array[0][0] && target <= array[0][index]){
        //找到 这个target所处的行之后遍历这一行
        for(int j=0;i<index;j++){
          if(target == array[i][j]){
            return true;
          }
        }
      }
    }
    return false;
  }

}
