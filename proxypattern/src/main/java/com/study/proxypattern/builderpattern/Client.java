package com.study.proxypattern.builderpattern;

/**
 * @author simonliang
 * @className Client
 * @description 建筑者模式
 * @date 2020/9/17 11:16 上午
 */
public class Client {
    public static void main(String[] args) {
        //new房子
        CommonHouse commonHouse = new CommonHouse();
        //new指挥者
        Director director = new Director(commonHouse);
        //完成盖房
        House house = director.constructHouse();
        //重置建造者
        HighHouse highHouse = new HighHouse();
        director.setHouseBuilder(highHouse);
        House house1 = director.constructHouse();
    }
}
