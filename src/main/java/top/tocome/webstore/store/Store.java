package top.tocome.webstore.store;

import top.tocome.webstore.store.goods.Goods;

import java.util.ArrayList;

public class Store {
    protected String name;

    public Store(String name) {
        this.name = name;
    }

    protected ArrayList<Goods> goods = new ArrayList<>();

    public void addGoods(Goods newGoods) {
        goods.add(newGoods);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }
}
