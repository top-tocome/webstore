package top.tocome.webstore.store.goods;

/**
 * 京东商品详情页  //item.jd.com
 * 京东图片api格式：
 * //img??.360buyimg.com/n[1-9]|??/s500x500_jfs/t1/150430/35/20924/941918/6037c409E4681a3dc/b1b1bc3470900618.jpg!cc_300x500.jpg
 * img??：??为任意数字，泛解析对图片无影响
 * n1-n9:大小从350x350到25x25   n0：有京东水印的原图   ??:imgzone,img,i,cc等，为原图大小
 * s500x500_:线性放大或缩小图片为500x500，可填任意尺寸（选填）
 * jfs.*?jpg:图片路径
 * !cc_300x500.jpg:裁剪图片（选填）
 */
public class JDGoods extends Goods {
    public static final String head = "//item.jd.com";

    public JDGoods(String url) {
        super(url, "imageList:", "]", "desc:", "'");
    }

    @Override
    public String getActionData() {
        return super.getActionData().replaceAll("jfs", "//img10.360buyimg.com/imgzone/jfs");
    }
}
