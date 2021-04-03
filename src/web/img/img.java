package web.img;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

/*
 * 网络图片下载
 *
 */

public class img {
    public final static String resourse = "resourse\\img\\";

    public static void downloadall(List<String> arr,String filepath) {//下载arr中所有图片url到本地文件夹filepath中

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("下载中...第" + (i + 1) + "/" + arr.size() + "张");
            try {
                URL url = new URL(arr.get(i));
                // String format = url.toString().substring(url.toString().lastIndexOf("."));
                downloadimg(url, filepath + i + ".jpg"/*format*/);
            } catch (Exception e) {
                arr.remove(i--);
                System.out.println("下载错误：" + e);
            }
        }
        System.out.println("下载完成共"+arr.size()+"张");
    }

    public static void downloadimg(URL url, String filename) throws Exception {
        BufferedInputStream read = new BufferedInputStream(url.openStream());
        BufferedOutputStream write = new BufferedOutputStream(new FileOutputStream(filename));
        byte[] b = new byte[200];
        int t;
        while (true) {
            t = read.read(b);
            if (t == -1) {
                break;
            } else {
                write.write(b, 0, t);
            }

        }
        read.close();
        write.close();
    }

    public static void imgpreview() throws Exception{
        Runtime.getRuntime().exec("cmd /c " + resourse + "preview.html");
    }
}
