package map;

import character.NPC.NPC;
import character.player.Item.Item;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 城堡房间的抽象类
 * @date 2020/5/26 0026 18:59
 */
public abstract class Room {
    public String name="";
    public String description="";
    public ArrayList<Room> next;
    public Item item = null;
    public NPC npc = null;

    public Room() {
    }
}
