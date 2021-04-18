package web.binary;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * 二进制文件类
 *
 * 批量下载网络图片
 * 打开图片浏览页面
 */

public class Img {
    public final static String resourse = "resourse\\img\\";

    public static void downloadall(List<String> arr, String filepath) {// 下载arr中所有图片url到本地文件夹filepath中

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("下载中...第" + (i + 1) + "/" + arr.size() + "张");
            try {
                URL url = new URL(arr.get(i));
                // String format = url.toString().substring(url.toString().lastIndexOf("."));
                Binary.download(url, filepath + i + ".jpg"/* format */);
            } catch (Exception e) {
                arr.remove(i--);
                System.out.println("下载错误：" + e);
            }
        }
        System.out.println("下载完成共" + arr.size() + "张");
    }

    public static void imgpreview() throws Exception {// 打开图片浏览页面
        Runtime.getRuntime().exec("cmd /c " + resourse + "preview.html");
    }
    public static void imgpreview2() throws Exception {// 打开图片浏览页面
        Runtime.getRuntime().exec("cmd /c " + resourse + "preview2.html");
    }

    public static List<String> toImgArray(String str) {// 将字符串切分为数组
        List<String> strarr = new ArrayList<String>();
    
        Pattern pattern = Pattern.compile("//[^><{}(),;:\'\"]+?\\.(?:jpg|png)");
        Matcher matcher = pattern.matcher(str);
        System.out.println("截获的图片：");
        while (matcher.find()) {
            strarr.add("http:" + matcher.group());
            System.out.println("http:" + matcher.group());
        }
        System.out.println("长度：" + strarr.size());
        return strarr;
    }
}
