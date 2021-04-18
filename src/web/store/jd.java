package web.store;

import java.net.URL;

import web.text.Text;

/**
 * 京东商品详情页  //item.jd.com 
 * 京东图片api格式：
 * //img??.360buyimg.com/n[1-9]|??/s500x500_jfs/t1/150430/35/20924/941918/6037c409E4681a3dc/b1b1bc3470900618.jpg!cc_300x500.jpg
 * img??：??为任意数字，泛解析对图片无影响
 * n1-n9:大小从350x350到25x25   n0：有京东水印的原图   ??:imgzone,img,i,cc等，为原图大小
 * s500x500_:线性放大或缩小图片为500x500，可填任意尺寸（选填）
 * jfs.*?jpg:图片路径
 * !cc_300x500.jpg:裁剪图片（选填）
 */
public class jd implements Store {
    final String action = "imageList:";
    final String describe = "desc:";

    public String getactimg(String page) {
        int start = page.indexOf(action);
        int end = page.indexOf("]", start);
        String str = page.substring(start, end + 1);
        str = str.replaceAll("jfs", "//img10.360buyimg.com/imgzone/jfs");
        System.out.println(str);
        return str;
    }

    public String getdescimg(String page) throws Exception {
        int i = page.indexOf(describe);
        int start = page.indexOf("//", i);
        int end = page.indexOf("\'", start);
        String str = "http:" + page.substring(start, end);
        System.out.println(str);
        URL desc = new URL(str);
        Text.save(desc.openStream(), "desc.json");
        str = Text.readtxt("desc");
        return str;
    }
}
