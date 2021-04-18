package web.store;

import java.net.URL;

import web.text.Text;

/**
 * 淘宝商品详情页  //item.taobao.com
 * 淘宝图片api格式：
 * //img.alicdn.com/??/O1CN01GoprA71e9jCdSFgeX_!!3407743829.jpg_430x430.jpg
 * ??:任意，一般为图片信息
 * .*?jpg：图片名称
 * _430x430.jpg:图片大小430x430（选填，不填为原图大小）
 */
public class taobao implements Store {

    final String action = "auctionImages";
    final String describe = "descUrl";

    public String getactimg(String page) {
        int start = page.indexOf(action);
        int end = page.indexOf("]", start);
        String str = page.substring(start, end + 1);
        System.out.println(str);
        return str;
    }

    public String getdescimg(String page) throws Exception {
        int i = page.indexOf(describe);
        int start = page.indexOf("//", i);
        int end = page.indexOf("\'", start);
        String str = "http:" + page.substring(start, end);
        System.out.println(str);
        URL desc = new URL(str);
        Text.save(desc.openStream(), "desc.json");
        str = Text.readtxt("desc");
        return str;
    }
}
