package top.tocome.webstore.store;

import java.net.URL;

import top.tocome.io.Text;

/**
 * 天猫商品详情页  //detail.tmall.com
 * 天猫图片api格式：同淘宝
 * 
 * 
 */
public class tmall implements Store {
    final String action = "\"default\":";
    final String describe = "\"descUrl\":";

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
        int end = page.indexOf("\"", start);
        String str = "http:" + page.substring(start, end);
        System.out.println(str);
        URL desc = new URL(str);
        Text.save(desc.openStream(), "desc.json");
        str = Text.readtxt("desc");
        return str;
    }
}
