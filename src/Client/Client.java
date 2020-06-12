package Client;

import character.NPC.witcher;
import character.player.Item.Item;
import character.player.Item.book;
import character.player.player;
import map.Room;
import map.room.*;

import java.util.Scanner;

import static character.player.player.bag;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 客户端
 * @date 2020/5/26 0026 21:09
 */
public class Client {
    static Room cur;
    static player pl;

    //打印欢迎界面
    private static void hello() {
        System.out.println("如你所见,这是一个没有画面与声音的无聊游戏");
        System.out.println("你将扮演一名偷偷潜入女巫古堡的实习战士,寻找一本失传的魔法古书");
        System.out.println("请时刻留意自己的生命值,以及所处位置  探索地图吧!");
        System.out.println("<<========输入bag打开背包,status查看当前状态========>>");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的名字 回车结束");
        pl = player.getInstance();
        pl.getInstance().name = scan.nextLine();
        System.out.println(pl.name + " 欢迎来到古堡!");
    }

    private static void mapInit() {
        //4个房间的初始化
        bedroom ws = bedroom.getInstance();
        garden hy = garden.getInstance();
        meetingroom kt = meetingroom.getInstance();
        frontdoor dm = frontdoor.getInstance();

        //画地图(产生关联)
        cur = dm;
        dm.next.add(hy);
        hy.next.add(dm);
        hy.next.add(kt);

        kt.next.add(ws);
        kt.next.add(hy);

        ws.next.add(kt);
    }

    //打印状态
    public static void showStatus() {
        System.out.println("----------status----------");
        System.out.println("当前攻击力: " + player.getInstance().AD);
        System.out.println("当前血量: " + player.getInstance().HP);
        System.out.println("背包里的物品有");
        int i = 1;
        for (Item things : bag
        ) {
            System.out.print((i++) + "." + things.name + "  ");
        }
        System.out.println();
        System.out.println("-------------------------");
    }


    //切换地图
    private static void choose() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int i = 1;
            System.out.println("在你面前有这样几个房间");
            for (Room p : cur.next
            ) {
                if (p != null) {
                    System.out.println("第 " + (i++) + " 号房间是 " + p.name);
                }
            }
            System.out.println("请选择你要去到的房间(输入数字):");
            int index = scan.nextInt();
            if (index >= cur.next.size())
                System.out.println("那里没有门,请重新选择");
            else {
                cur = cur.next.get(index);
                break;
            }
        }
    }

    private static void Loot() {
        Scanner scan = new Scanner(System.in);
        System.out.println("这个房间的情景:" + cur.description);
        if (cur.item != null) {
            System.out.println("你惊讶地发现这里居然有" + cur.item.name);
            System.out.println((cur.item).getName() + "是" + cur.item.getDesc());
            System.out.println("你要把它放进背包吗?  1是  2不是");
            int choose = scan.nextInt();
            if (choose == 1) player.getInstance().bag.add(cur.item);
            {
                showStatus();
                cur.item = null;
            }
        }
    }

    private static void fight() {
        System.out.println("你的行为惊动了 " + cur.npc.name);
        while (cur.npc.HP > 0) {
            cur.npc.attack();
            pl.attack();
            player.getInstance().HP -= cur.npc.AD;
            cur.npc.HP -= player.getInstance().AD;
            System.out.println();
            System.out.println("你的 血量: " + player.getInstance().HP);
            System.out.println("Boss 血量: " + cur.npc.HP);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("费了好一番力气,终于战胜了" + cur.npc.name);
    }

    public static void prepare() {
        Scanner scan = new Scanner(System.in);
        System.out.println("战斗之前最好检查自己的装备");
        showStatus();
        System.out.println("如果要使用物品请相应输入序号 不使用请输入-1");
        int index = scan.nextInt();
        if (index == -1) return;
        if (index <= bag.size()) {
            bag.get(index - 1).invoke();
            bag.remove(index - 1);
        }
    }

    public static void main(String[] args) {
        hello();
        mapInit();

        while (!bag.contains(book.getINSTANCE())&&player.getInstance().HP>=0) {
            if (!bag.isEmpty())
                prepare();
            if (cur.npc != null)
                fight();
            if (cur.item != null)
                Loot();
            if (!bag.contains(book.getINSTANCE()))
                choose();
        }
        if(player.getInstance().HP>=0) System.out.println("恭喜你通关游戏,拿到了魔法书:)");
        else System.out.println("你已死亡,下次记得用道具0.0");
    }
}
