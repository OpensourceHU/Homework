package character.player;

import character.player.Item.Item;
import character.player.Item.sword;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 玩家类
 * @date 2020/5/26 0026 19:06
 */
public class player {
    public String name;
    public static int HP = 100;
    public static int AD = 20;
    public static ArrayList<Item> bag = new ArrayList<Item>();

    public void attack() {
        if (INSTANCE.bag.contains(sword.getINSTANCE()))
            System.out.println("你挥舞着<大宝剑>使出了  咸鱼冲刺!!!!!   造成了 " + AD + "点伤害");
        else
            System.out.println("你打了一套<王八拳> '佛山当然我 " + name + " 最能打'"
                    + "  造成了" + AD + "点伤害");
    }

    private player() {
    }

    private static final player INSTANCE = new player();

    public static player getInstance() {
        return INSTANCE;
    }
}
