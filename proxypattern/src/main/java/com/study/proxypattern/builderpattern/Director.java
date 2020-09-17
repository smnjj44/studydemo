package com.study.proxypattern.builderpattern;

/**
 * @author simonliang
 * @className Director
 * @description
 * @date 2020/9/17 11:15 上午
 */
public class Director {
    HouseBuilder houseBuilder = null;
    //通过构造器聚合
    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //通过setter方法聚合
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //指挥具体建造流程，先后顺序不由Builder决定
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}
