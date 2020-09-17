package com.study.proxypattern.builderpattern;

/**
 * @author simonliang
 * @className HouseBuilder
 * @description
 * @date 2020/9/17 11:10 上午
 */
public abstract class HouseBuilder {
    protected House house = new House();
    //写好流程的各个方法，但不约束具体执行
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();
    //建造方法，返回建造结果
    public House buildHouse(){
        return house;
    }
}
