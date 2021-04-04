package filecoding;

import web.text.Text;

/*
 * 文件解密主类
 */
public class ReCodingApp {
   public static void main(String[] args) throws Exception {
      try {
         String file = Text.input("拖入要解密文件.....:");

         String s = Text.input("输入密码:");

         Code.coding(file, "已解密" + Code.getformat(file), -s.hashCode());

         System.out.println("解密完毕.....");
      } catch (Exception e) {
         System.out.println("错误: " + e);
      }

   }
}
