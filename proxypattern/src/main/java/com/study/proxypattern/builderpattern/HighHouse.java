package com.study.proxypattern.builderpattern;

/**
 * @author simonliang
 * @className HighHouse
 * @description
 * @date 2020/9/17 11:14 上午
 */
public class HighHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼：建造地基。。。");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼：砌墙。。。");
    }

    @Override
    public void buildRoof() {
        System.out.println("高楼：盖屋顶。。。");
    }
}
