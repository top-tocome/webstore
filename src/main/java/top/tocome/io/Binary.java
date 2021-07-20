package top.tocome.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
/**
 * 二进制文件类
 * 
 * 从网络上下载二进制文件
 */
public class Binary {

    public static void download(URL url, String filename) throws Exception {//从网络上下载二进制文件
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
    
}
