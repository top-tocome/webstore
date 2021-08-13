package top.tocome.webstore.utils;

import top.tocome.io.Http;
import top.tocome.webstore.Data;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 二进制文件类
 * 批量下载网络图片
 * 打开图片浏览页面
 */

public class Img {

    /**
     * 下载所有图片到本地
     *
     * @param imageUrls     图片链接数组
     * @param directoryPath 保存文件的目录
     */
    public static void downloadAll(ArrayList<String> imageUrls, String directoryPath) {
        for (int i = 0; i < imageUrls.size(); i++) {
            System.out.println("下载中...第" + (i + 1) + "/" + imageUrls.size() + "张");
            if (!Http.download(imageUrls.get(i), directoryPath + "/" + i + ".jpg"/* format */)) {
                imageUrls.remove(i--);
                System.out.println("下载错误");
            }
        }
        System.out.println("下载完成共" + imageUrls.size() + "张");
    }

    public static void imgPreview() throws Exception {// 打开图片浏览页面
        Runtime.getRuntime().exec("cmd /c " + Data.dataPath.replaceAll("/", "\\\\") + "\\img\\preview.html");
    }

    /**
     * 从字符串中截取图片链接
     *
     * @param str 字符串
     * @return 图片链接列表
     */
    public static ArrayList<String> toImgArray(String str) {
        ArrayList<String> imageUrls = new ArrayList<>();
        Pattern pattern = Pattern.compile("//[^><{}(),;:'\"]+?\\.(?:jpg|png)");
        Matcher matcher = pattern.matcher(str);
        System.out.println("截获的图片：");
        while (matcher.find()) {
            imageUrls.add("https:" + matcher.group());
            System.out.println("https:" + matcher.group());
        }
        System.out.println("图片数量：" + imageUrls.size());
        return imageUrls;
    }
}
