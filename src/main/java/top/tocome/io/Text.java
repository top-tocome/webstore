package top.tocome.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 文本文件类
 * 
 * 系统控制台输入
 * 下载保存文本文件
 * 文本读取
 * 文本写入
 * 
 */

public class Text {

    public static String input(String hint) throws IOException {// 从控制台获取url输入,并返回
        System.out.print(hint);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 读取控制台输入
        String sysin = br.readLine();
        return sysin;
    }

    public static void save(InputStream urlstream, String filepath) throws Exception {// 将获得的内容保存到文件filename中
        System.out.println("保存中...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlstream));
        BufferedWriter html = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath)));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            } else {
                html.write(line);
                html.newLine();
            }
        }
        reader.close();
        html.close();
        System.out.println("已保存至" + filepath);
    }

    public static void save(InputStream urlstream, File filepath) throws Exception {// override
        save(urlstream, filepath.toString());
    }

    public static String readtxt(InputStream stream) throws Exception {// 打开文件，返回文件内容字符串
        InputStreamReader reader = new InputStreamReader(stream);
        StringBuffer sb = new StringBuffer();
        while (true) {
            int c = reader.read();
            if (c == -1) {
                break;
            } else {
                sb.append((char) c);
            }
        }
        reader.close();
        return sb.toString();
    }

    public static String readtxt(File filepath) throws Exception {// override
        return readtxt(new FileInputStream(filepath));
    }

    public static String readtxt(String filepath) throws Exception {// override
        return readtxt(new FileInputStream(filepath));
    }

    public static void writetxt(String filepath, String content, boolean append) throws Exception {// 写content到filepath中
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath, append)));
        writer.write(content);
        writer.close();
    }

}
