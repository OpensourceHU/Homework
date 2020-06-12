package character.NPC;

import java.util.Stack;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description BOSS
 * @date 2020/5/27 0027 20:29
 */
public class witcher extends NPC{
    private witcher()
    {
        super();
        this.name = "女巫";
        this.HP = 120 ;
        this.AD = 40;
    }

    private static class skill{
        int damage;
        String name;

        public skill(int damage, String name) {
            this.damage = damage;
            this.name = name;
        }
    }
    static Stack<skill> magic = new Stack<skill>();
    static {
        magic.add(new skill(0,"挂机空过"));
        magic.add(new skill(1,"火球冲击"));
        magic.add(new skill(30,"寒冰箭"));
        magic.add(new skill(60,"烈焰冲击"));
        magic.add(new skill(100,"炎爆术"));
    }

    @Override
    public void attack() {
        super.attack();
        while(!magic.isEmpty())
        {
            skill cur = magic.pop();
            System.out.println("女巫使用了"+cur.name+"造成 了"+cur.damage+" 点伤害");
        }
    }
    private final static witcher INSTANCE = new witcher();
    public static witcher getInstance()
    {return INSTANCE;}
}
