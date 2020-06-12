package map.room;

import character.NPC.dog;
import map.Room;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 前门
 * @date 2020/5/26 0026 19:00
 */
public class frontdoor extends Room {

    private frontdoor(){
        super();
        this.name = "前门";
        this.description = "一扇锈迹斑斑的铁栅门,藤蔓顺着围墙缠绕其上";
        this.next = new ArrayList<Room>();
        this.next.add(frontdoor.getInstance());
        this.npc= dog.getInstance();
    }

    private final static frontdoor INSTANCE = new frontdoor();
    public static frontdoor getInstance()
    {//显然要加static 不加就是成员方法,外部需要先实例化才能调用,但外部类又没有办法通过new构造函数实例化
        return INSTANCE;
    }

}
