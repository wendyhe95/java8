
package com.java.algorithm;

/**
 * Created by wendyhe on 2018/7/31.
 */
public class Method {

    public static void main(String[] args){
        Method method=new Method();
        //method.addFactorial();
        //method.add();
        //method.calculate();
        //method.test();
        method.test1();
    }

    /**
     *   1!+2!+3!+...+15!
     */

    /*void addFactorial(){
        long result=0;
        for (int i = 1; i <15 ; i++) {
            int temp=1;
            for( int j = 1; j< i; j++){
                temp*=j;
            }
            result +=temp;
        }
        System.out.println(result);
    }*/


    /**
     * 1+(1+2)+(1+2+3)+...+(1+2+3+...+100)
     */
//    void  add(){
//        int sum=0;
//        for (int i = 0; i < 100; i++) {
//            int tempSum=0;
//            for (int j = 1; j < i; j++) {
//                tempSum+=j;
//            }
//            sum+=tempSum;
//        }
//        System.out.println(sum);
//    }

    /**
     *  100以内的奇数和 偶数和
     */
//    void  calculate(){
//        int sOdd=0; //奇数
//        int sEven=0; //偶数
//        for (int i = 0; i < 100; i++) {
//            if(i % 2 == 0){
//                sEven +=i;
//            }else{
//                sOdd +=i;
//            }
//
//        }
//        System.out.println("100以内奇数和为："+sOdd);
//        System.out.println("100以内偶数和为："+sEven);
//   }

    /**
     * 输出1000以内所有能被5整除的数  每行只能输出10个
     */

//    void test(){
//        int j=0;
//        for (int i = 0; i < 1000; i++) {
//            if(i%5==0){
//                System.out.print(i+"\t");
//                j++;
//                if(j%10==0){
//                    System.out.println("\n");
//                }
//            }
//
//        }
//
//    }

    /**
     * 9*9乘法表
     */
    void test1(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }

}