package character.player.Item;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/5/27 0027 21:28
 */
public class book extends Item {

    private book() {
        this.name = "魔法书";
        this.desc = "记载着失传魔法的古书,正是你这次要拿的东西";
    }
    private static final book INSTANCE = new book();

    public static book getINSTANCE() {
        return INSTANCE;
    }
}
