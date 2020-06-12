package map.room;


import character.player.Item.herb;
import map.Room;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 花园
 * @date 2020/5/26 0026 19:04
 */
public class garden extends Room {

    private garden(){
        super();
        this.name = "花园";
        this.description = "种满了不知名的草药";
        this.next = new ArrayList<Room>();
        this.next.add(garden.getInstance());
        this.item = herb.getINSTANCE();
    }

    private final static garden INSTANCE = new garden();
    public static garden getInstance()
    {//显然要加static 不加就是成员方法,外部需要先实例化才能调用,但外部类又没有办法通过new构造函数实例化
        return INSTANCE;
    }

}
