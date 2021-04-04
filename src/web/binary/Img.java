package web.binary;

import java.net.URL;
import java.util.List;

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
}
