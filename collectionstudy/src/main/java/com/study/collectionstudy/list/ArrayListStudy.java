package com.study.collectionstudy.list;

import java.util.ArrayList;

/**
 * @author simonliang
 * @className ArrayListStudy
 * @description
 * @date 2020/11/3 10:37 下午
 */
public class ArrayListStudy {
    public static void main(String[] args) {
        //给elementData赋值一个空数组
        ArrayList<Integer> list = new ArrayList<>();
        //一开始没有元素的时候elementData的length为0，所以开始执行到grow方法再通过grow方法开拓10个空间里面为null的elementData，再给elementData[0]赋值
        list.add(1);
        //只要长度少于10就一直执行不到grow方法，elementData的size添加完后为2，但是elementData.length为10，每次添加完都会在elementData[size++]中size添加，但是length一直为10
        list.add(2);
        for (int i = 3; i < 11; i++) {
            list.add(i);
        }
        //elementData的大小每次以（10+10>>1）>>1+（10+10>>1）这种形式增长，除了一开始0的时候就以10为基础创建和最后比Integer.MAX_VALUE - 8大的时候最大只能取到Integer.MAX_VALUE - 8大小
        list.add(11);
        list.add(12);
        System.out.println(list);;

        //直接elementData[0]获取
        Integer integer = list.get(0);
        System.out.println(integer);

        //从index下一个元素开始，把这个元素后面的包括这个元素的所有数据替换到原来的从index开始的元素，替换size - index - 1这么多位，然后剩余最后的没被替换就置为空像add一开始初始化一样，其余为空只有elementData[0]有值
        //例如remove(1)：01234，从2开始后3位(5-1-1)复制到原来01234从1开始后面包括1，复制3位，变成02344，再把最后一位置为null，0234null，这样就顺利remove了原本的1
        list.remove(0);
    }
}
