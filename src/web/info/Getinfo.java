package web.info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 各种信息的获取：
 * 系统输入
 *
 * 文件读取
 *
 */

public class Getinfo {

    public static String input(String hint) throws IOException {// 从控制台获取url输入,并返回
        System.out.print(hint);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 读取控制台输入
        String sysin = br.readLine();
        return sysin;
    }

    public static void gethtml(InputStream urlstream, String filepath) throws Exception {// 将获得的内容保存到文件filename中
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

    public static void gethtml(InputStream urlstream, File filepath) throws Exception {
        gethtml(urlstream, filepath.toString());
    }

    public static String txtread(File filepath) throws Exception {// 打开文件，返回文件内容字符串

        InputStreamReader reader = new InputStreamReader(new FileInputStream(filepath));
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

    public static void txtwrite(String filepath, String content, boolean append) throws Exception {// 写content到filepath中
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath, append)));
        writer.write(content);
        writer.close();
    }

    public static String getapi(File f, String apiname) throws Exception {

        String filecontent = txtread(f);
        int start = filecontent.indexOf(apiname);
        System.out.println("strat:" + start);
        int end = filecontent.indexOf("]", start);
        System.out.println("end:" + end);
        // filecontent = filecontent.substring(filecontent.indexOf("//"),
        // filecontent.indexOf("?var=desc"));

        // Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https:" +
        // filecontent);
        if (start != -1 && end != -1) {
            filecontent = filecontent.substring(start, end);
            System.out.println("已获取api：" + filecontent);
        } else {
            System.out.println("获取失败");
        }

        return filecontent;
    }

    public static List<String> apitoimgArray(String str) {// 将字符串切分为数组
        List<String> strarr = new ArrayList<String>();

        Pattern pattern = Pattern.compile("(?://|\\\\/\\\\/)[^><{},:]+?\\.(?:jpg|png)");
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
