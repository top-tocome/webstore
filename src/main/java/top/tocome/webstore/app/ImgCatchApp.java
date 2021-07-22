package top.tocome.webstore.app;

import java.util.ArrayList;

import top.tocome.io.File;
import top.tocome.io.Http;
import top.tocome.io.Stream;
import top.tocome.webstore.Data;
import top.tocome.webstore.Img;

public class ImgCatchApp {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.print("请输入正确的网址:");
                String in = Stream.readLine();
                if ("exit".equals(in)) {
                    break;
                }
                new java.io.File(Data.cachePath).mkdirs();
                String html = Http.get(in);

                ArrayList<String> arr = Img.toImgArray(html);
                Img.downloadAll(arr, Data.cachePath);

                String content = "var maximg =" + arr.size();
                File.write(Data.cachePath + "/setting.js", content.getBytes(), false);

                Img.imgPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
