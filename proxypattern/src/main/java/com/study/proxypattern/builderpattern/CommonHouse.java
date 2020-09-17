package com.study.proxypattern.builderpattern;

/**
 * @author simonliang
 * @className CommonHouse
 * @description
 * @date 2020/9/17 11:13 上午
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子：建造地基。。。");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子：砌墙。。。");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通房子：盖屋顶。。。");
    }
}
