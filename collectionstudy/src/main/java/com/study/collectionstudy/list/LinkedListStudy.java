package com.study.collectionstudy.list;

import java.util.LinkedList;

/**
 * @author simonliang
 * @className LinkedListStudy
 * @description
 * @date 2020/11/3 10:37 下午
 */
public class LinkedListStudy {
    public static void main(String[] args) {
        //item的prev和prev里面的next是一样的，一个元素就是一个node有前后属性的node，所以前后的类型也是node,把各个都作为一个完整的来储存。
        //xyz y的pre=null，x的item还是x
        //final Node<E> newNode = new Node<>(l, e, null);更改前方 更改前方的后方l.next = newNode;
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("x");
        linkedList.add("y");
        linkedList.add("z");
        //通过index比根号size大还是小来判断从头还是从尾开始遍历，遍历到index提取出来
        linkedList.get(0);
        //把remove那个index的元素找出来，然后把这个元素的item和pre和next都置为空，因为要移除所以没用了，为了不要内存泄露，所以都得这个node三个属性都设置为空
        //然后设置后移除的那个元素的前一个元素的后面那个元素和那个元素的后一个元素的前元素，这个前一个元素的前面的元素继续保持不变，后面一个元素的后元素也保持原来的不变，这样就设置好把remove的元素变为空了，元素向前推移了一步
        linkedList.remove(1);

    }
}
