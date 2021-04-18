package web.agent;

import java.net.HttpURLConnection;
import java.net.URL;

/*
 * 设置用户浏览器代理
 * 打开代理提示页面
 */

public class useragent {// 获取用户浏览器代理

    public static String agent = null;
    public final static String resourse = "resourse\\agent\\";

    public static HttpURLConnection setagent(URL site) throws Exception {// 设置用户浏览器代理
        // if (agent == null) {
        //     getagent();
        //     agent = Text.input("请输入浏览器代理:");
        // }
        HttpURLConnection connect = (HttpURLConnection) site.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("User-Agent", agent);
        return connect;
    }

    public static void getagent() throws Exception {// 打开代理提示页面
        Runtime.getRuntime().exec("cmd /c " + resourse + "getagent.html");
    }
}