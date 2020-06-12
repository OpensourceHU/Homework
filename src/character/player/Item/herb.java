package character.player.Item;

import character.player.player;


/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/5/27 0027 21:14
 */
public class herb extends Item {

    private herb() {
        this.name = "活力药水";
        this.desc = "玻璃瓶盛装的蓝色透明液体,服用可使生命值翻倍";
    }

    @Override
    public void invoke() {
        super.invoke();
        System.out.println("你喝下了药水,感觉从头到脚一身爽");
        player.getInstance().HP *= 2;
        System.out.println("一看当前生命值,ohhhhh  足足有: " + player.getInstance().HP+"点");
    }
    private static final herb INSTANCE = new herb();

    public static herb getINSTANCE() {
        return INSTANCE;
    }

}
