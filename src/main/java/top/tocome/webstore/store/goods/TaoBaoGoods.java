package top.tocome.webstore.store.goods;

/**
 * 淘宝商品详情页  //item.taobao.com
 * 淘宝图片api格式：
 * //img.alicdn.com/??/O1CN01GoprA71e9jCdSFgeX_!!3407743829.jpg_430x430.jpg
 * ??:任意，一般为图片信息
 * .*?jpg：图片名称
 * _430x430.jpg:图片大小430x430（选填，不填为原图大小）
 */
public class TaoBaoGoods extends Goods {

    public TaoBaoGoods(String url) {
        super(url, "auctionImages", "]","descUrl", "'");
    }
}
