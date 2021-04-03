package web.agent;

import java.net.HttpURLConnection;
import java.net.URL;

import web.info.Getinfo;

/*
 * 获取用户浏览器代理
 */

public class useragent {

    public static String agent = null;
    public final static String resourse = "resourse\\agent\\";

    public static HttpURLConnection setagent(URL site) throws Exception {
        if (agent == null) {
            getagent();
            agent = Getinfo.input("请输入浏览器代理:");
        }
        HttpURLConnection connect = (HttpURLConnection) site.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("User-Agent", agent);
        return connect;
    }

    public static void getagent() throws Exception {
        Runtime.getRuntime().exec("cmd /c " + resourse + "getagent.html");
    }
}