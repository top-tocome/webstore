package filecoding;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* 二进制文件类
 *
 * 文件加密和解密
 * 获取文件格式
 */
public class Code {

    public static void coding(String filepath, String filename, int x) throws Exception {// 文件加密或解密

        BufferedInputStream read = new BufferedInputStream(new FileInputStream(filepath));
        BufferedOutputStream write = new BufferedOutputStream(new FileOutputStream(filename));

        while (true) {
            int t = read.read();
            if (t == -1) {
                break;
            } else {
                write.write(t - x);
            }
        }
        read.close();
        write.close();
    }

    public static String getformat(String filename) {// 获取文件格式

        String format = filename.toString().substring(filename.toString().lastIndexOf("."));

        return format;
    }

}
