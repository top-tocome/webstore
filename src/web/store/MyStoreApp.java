package web.store;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import web.binary.Img;
import web.text.Text;
/**
 * 我的商城
 * 
 */
public class MyStoreApp {

    public static void main(String[] args) {
        File html = new File("site.html");// 在resource下新建site.html文件
        taobao taobao = new taobao();
        tmall tmall = new tmall();
        jd jd = new jd();
        while (true) {// 循环主程序
            try {
                new File("temp").mkdirs();// 新建temp文件夹
                String in = Text.input("请输入正确的网址:");// 获取控制台输入
                if (in.equals("exit")) {// 输入exit退出程序
                    System.out.println("退出");
                    break;
                }
                if (in.matches(".+//item.taobao.com.+")) {
                    String page = getpage(html, in);
                    goods(page, taobao);
                } else if (in.matches(".+//detail.tmall.com.+")) {
                    String page = getpage(html, in);
                    goods(page, tmall);
                } else if (in.matches(".+//item.jd.com.+")) {
                    String page = getpage(html, in);
                    goods(page, jd);
                } else {
                    System.out.println("不支持的网页");
                }
            } catch (Exception e) {
                System.out.println("错误：" + e);
                // e.printStackTrace();
            }
        }
    }

    private static void goods(String page, Store store) throws Exception {//获取商品主要图片
        String actimg = store.getactimg(page);
        List<String> arr = Img.toImgArray(actimg);
        Img.downloadall(arr, "temp\\a");
        String content = "var actimg =" + arr.size() + ";\n";
        Text.writetxt(Img.resourse + "setting.js", content, false);

        String descimg = store.getdescimg(page);
        arr = Img.toImgArray(descimg);
        Img.downloadall(arr, "temp\\d");
        content = "var descimg =" + arr.size() + ";";
        Text.writetxt(Img.resourse + "setting.js", content, true);

        Img.imgpreview2();
    }

    private static String getpage(File html, String in) throws MalformedURLException, Exception, IOException {//获取商品页面源码
        URL site = new URL(in);// 将输入转为url
        Text.save(site.openStream(), html);
        String page = Text.readtxt(html);
        return page;
    }
}
