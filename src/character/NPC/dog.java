package character.NPC;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 黑狗
 * @date 2020/5/26 0026 19:20
 */
public class dog extends NPC{
    @Override
    public void attack() {
        System.out.print(this.name + " 狂吠着冲撞上来");
        for(int i=0;i<10;i++){
            System.out.println("对你造成了"+this.AD+"点伤害");
        }
    }

    private dog() {
        super();
        this.name = "狗群";
        this.AD = 4;
        this.HP = 10;
    }
    private final static dog INSTANCE = new dog();
    public static dog getInstance()
    {return INSTANCE;}
}
