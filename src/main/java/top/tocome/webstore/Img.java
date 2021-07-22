package top.tocome.webstore;

import top.tocome.io.Http;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 二进制文件类
 * 批量下载网络图片
 * 打开图片浏览页面
 */

public class Img {
    public final static String path = Data.dataPath + "/img";

    public static void downloadAll(ArrayList<String> arr, String filePath) {// 下载arr中所有图片url到本地文件夹filepath中

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("下载中...第" + (i + 1) + "/" + arr.size() + "张");
            if (!Http.download(arr.get(i), filePath + "/" + i + ".jpg"/* format */, false)) {
                arr.remove(i--);
                System.out.println("下载错误");
            }
        }
        System.out.println("下载完成共" + arr.size() + "张");
    }

    public static void imgPreview() throws Exception {// 打开图片浏览页面
        Runtime.getRuntime().exec("cmd /c " + Data.dataPath.replaceAll("/", "\\\\") + "\\img\\preview.html");
    }

    public static ArrayList<String> toImgArray(String str) {// 将字符串切分为数组
        ArrayList<String> arr = new ArrayList<>();

        Pattern pattern = Pattern.compile("//[^><{}(),;:'\"]+?\\.(?:jpg|png)");
        Matcher matcher = pattern.matcher(str);
        System.out.println("截获的图片：");
        while (matcher.find()) {
            arr.add("https:" + matcher.group());
            System.out.println("http:" + matcher.group());
        }
        System.out.println("长度：" + arr.size());
        return arr;
    }
}
