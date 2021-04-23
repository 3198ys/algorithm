//package jichu;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author ys 2020/10/22
// * @description
// */
//public class test3 {
//  int size1 = 33;int size2 = 1;int size3 = 29;
//
//  public void test(){
//    long d1Max = maxBySize(size1);long d2Max = maxBySize(size2);long d3Max = maxBySize(size3);
//  }
//  public static void main(String[] args) {
//
//
//
//    // 计算 scorepublic
//    // 计算增加 value 值// 根据二进制长度计算最大值
//  }
//  long genScore(long d1, long d2, long d3) {    return ((d1 & d1Max) << (size2 + size3)) | ((d2 & d2Max) << size3) | (d3 & d3Max);}
//
//
//  private long maxBySize(int len) {    long r = 0;    while (len-- > 0) {        r = ((r << 1) | 1);    }    return r;}
//
//
//
//
////  int size1 = 33;int size2 = 1;int size3 = 29;
//  long d1Max = maxBySize(size1);
//  long d2Max = maxBySize(size2);
//  long d3Max = maxBySize(size3);// 计算 scorepublic long genScore(long d1, long d2, long d3) {    return ((d1 & d1Max) << (size2 + size3)) | ((d2 & d2Max) << size3) | (d3 & d3Max);}// 计算增加 value 值public void incValue(long d1) {        return ((d1 & d1Max) << (size2 + size3)) | ((0 & d2Max) << size3) | (0 & d3Max);}// 根据二进制长度计算最大值private long maxBySize(int len) {    long r = 0;    while (len-- > 0) {        r = ((r << 1) | 1);    }    return r;}
//}
