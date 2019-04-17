package com.interview.javalib;


import java.util.Arrays;

public class MyClass {


    public static void main(String[] args) {
        int index=search(67);
        System.out.print("sss="+index);
    }


    //传入两个有序数组合并为一个有序数组
    private void test1(){
        int[] arry1={1,3,5,7,9};
        int[] arry2={2,4,6,8,10};
        int[] data=new int[arry1.length+arry2.length];
        int a=0;int b=0;
        String s="aaa";
        s.indexOf("sss");
        for (int i = 0; i < data.length; i++) {
            if (a<arry1.length&&b<arry2.length){
                if (arry1[a]>arry2[b]){
                    data[i]=arry2[b];
                    b++;
                }else{
                    data[i]=arry1[a];
                    a++;
                }
            }else if (a>=arry1.length){
                data[i]=arry2[b];
                b++;
            }else{
                data[i]=arry1[b];
                a++;
            }
        }

        System.out.print(Arrays.toString(data));

    }

    //冒泡排序
    private void coll(){
        int[] arr={3,2,9,10,33,22,11,4,7,6};
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(arr));
    }

    public  static int search(int key){
        int[] arr={22,33,44,55,66,77,88,99,111};
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int middle=(start+end)/2;
            if (arr[middle]<key){
                start=middle+1;
            }else if (arr[middle]>key){
                end=middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }

}
