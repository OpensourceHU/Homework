package character.NPC;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 黑衣人
 * @date 2020/5/26 0026 19:26
 */
public class black extends NPC {
    public black() {
        super();
        this.name = "阴阳人鲍勃";
        this.AD = 10;
        this.HP = 140;

    }

    static Stack<String> zuipao = new Stack<String>();
    static{
        zuipao.add("你真是个天才啊");
        zuipao.add("这游戏就是这么玩的");
        zuipao.add("现在你可能有点落后，但你肯定能慢慢赶上来的。");
        zuipao.add("没关系，人生难免不如意。");
        zuipao.add("看你打游戏是种享受。");
        zuipao.add("看看你如何应对这个局面。");
    }

    @Override
    public void attack() {
        System.out.println(this.name + "发动技能嘴炮");
        for(int i=0;i<2;i++)
        {
            System.out.println("鲍勃说:"+zuipao.pop());
        }
        System.out.println("因为鲍勃的阴阳怪气,你气出内伤 照成 " + this.AD + " 点伤害");
    }
    private final static black INSTANCE = new black();
    public static black getInstance()
    {return INSTANCE;}
}
