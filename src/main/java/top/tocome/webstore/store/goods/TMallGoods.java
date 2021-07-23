package top.tocome.webstore.store.goods;

/**
 * 天猫商品详情页  //detail.tmall.com
 * 天猫图片api格式：同淘宝
 */
public class TMallGoods extends Goods {

    public TMallGoods(String url) {
        super(url, "\"default\":", "\"descUrl\":", "\"");
    }
}
