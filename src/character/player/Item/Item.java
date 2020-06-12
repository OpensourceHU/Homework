package character.player.Item;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 背包物品类
 * @date 2020/5/26 0026 19:14
 */
public abstract class Item {
    public String name;
    public String desc;
    public void invoke(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
