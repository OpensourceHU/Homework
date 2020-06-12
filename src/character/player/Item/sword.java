package character.player.Item;

import character.player.player;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/5/27 0027 21:19
 */
public class sword extends Item {
    @Override
    public void invoke() {
        super.invoke();
        System.out.println("你装备上了村里最好的剑");
        player.AD += 30;
    }

    private sword() {
        name = "霜之哀伤";
        desc = "巫妖王的霜之哀伤大宝剑,不知道为什么出现在这里,装备可加30攻击力";
        player.getInstance().AD+=30;
    }
    private static final sword INSTANCE = new sword();

    public static sword getINSTANCE() {
        return INSTANCE;
    }


}
