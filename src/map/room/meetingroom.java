package map.room;

import character.NPC.black;
import character.player.Item.sword;
import map.Room;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 大厅
 * @date 2020/5/26 0026 19:01
 */
public class meetingroom extends Room {

    private meetingroom(){
        super();
        this.name = "客厅";
        this.description = "深远昏暗的大厅内,摆放着一张望不到头的木质长桌,你的脚步声在大厅内回荡";
        this.next = new ArrayList<Room>();
        this.next.add(meetingroom.getInstance());
        this.item = sword.getINSTANCE();
        this.npc = black.getInstance();
    }

    private final static meetingroom INSTANCE = new meetingroom();
    public static meetingroom getInstance()
    {//显然要加static 不加就是成员方法,外部需要先实例化才能调用,但外部类又没有办法通过new构造函数实例化
        return INSTANCE;
    }
}
