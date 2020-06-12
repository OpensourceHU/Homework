package map.room;

import character.NPC.witcher;
import character.player.Item.book;
import map.Room;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 卧室
 * @date 2020/5/26 0026 20:40
 */
public class bedroom extends Room{

    private bedroom(){
        super();
        this.name = "卧室";
        this.description = "女巫的卧室,门窗紧闭,角落用蜡烛摆放成的六芒星阵,散发出微光";
        this.next = new ArrayList<Room>();
        this.next.add(null);
        this.npc = witcher.getInstance();
        this.item = book.getINSTANCE();
    }

    private final static bedroom INSTANCE = new bedroom();
    public static bedroom getInstance()
    {//显然要加static 不加就是成员方法,外部需要先实例化才能调用,但外部类又没有办法通过new构造函数实例化
        return INSTANCE;
    }
}
