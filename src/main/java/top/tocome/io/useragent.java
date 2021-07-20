package top.tocome.io;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * 设置用户浏览器代理
 * 打开代理提示页面
 */

public class useragent {// 获取用户浏览器代理

    public static String agent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36";
    public final static String resourse = "resourse\\agent\\";

    public static InputStream setagent(URL site) throws Exception {// 设置用户浏览器代理
        // if (agent == null) {
        //     getagent();
        //     agent = Text.input("请输入浏览器代理:");
        // }

        HttpURLConnection connect = (HttpURLConnection) site.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("User-Agent", agent);
        return connect.getInputStream();
    }

    public static void getagent() throws Exception {// 打开代理提示页面
        Runtime.getRuntime().exec("cmd /c " + resourse + "getagent.html");
    }
}