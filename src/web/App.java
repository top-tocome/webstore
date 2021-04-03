package web;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import web.agent.useragent;
import web.img.img;
import web.info.Getinfo;

public class App {
    public static void main(String[] args) {
        final String resourse = "resourse\\";//资源文件夹
        while (true) {//循环主程序
            try {
                String in = Getinfo.input("请输入正确的网址:");//获取控制台输入
                if (in.equals("exit")) {//输入exit退出主循环
                    break;
                }
                new File("temp").mkdirs();//新建temp文件夹
                File html = new File(resourse+"site.html");//在resource下新建site.html文件
                URL site = new URL(in);//将输入转为url
                HttpURLConnection con = useragent.setagent(site);//
                Getinfo.gethtml(con.getInputStream(), html);//
                String str = Getinfo.txtread(html);//
                List<String> arr = Getinfo.apitoimgArray(str);//
                img.downloadall(arr,"temp\\");//下载arr中所有图片url到本地文件夹temp中
                
                String content="{\"a\":"+arr.size()+"}";//
                Getinfo.txtwrite("num.txt",content, false);//
                img.imgpreview();//
            } catch (Exception e) {
                System.out.println("错误："+e);
                // e.printStackTrace();
            }
        }
    }
}
