package top.tocome.webstore.app;

import top.tocome.io.Stream;
import top.tocome.webstore.Data;
import top.tocome.webstore.store.Store;
import top.tocome.webstore.store.goods.Goods;
import top.tocome.webstore.utils.Img;

public class WebStoreApp {
    public static void main(String[] args) {
        Store store = new Store("my");

        while (true) {
            try {
                System.out.print("请输入商品链接:");
                String in = Stream.readLine();
                if ("exit".equals(in)) {
                    break;
                }
                new java.io.File(Data.cachePath).mkdirs();
                Goods goods = Goods.newGoods(in);
                if (goods == null) {
                    System.out.println("错误的链接");
                    continue;
                }
                store.addGoods(goods);
                Img.downloadAll(goods.getActionImages(), Data.cachePath + "/action/");
                Img.downloadAll(goods.getActionImages(), Data.cachePath + "/desc/");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
