package filecoding;

import web.text.Text;

/*
 * 文件加密主类
 */
public class CodingApp {
   public static void main(String[] args) {
      try {
         String file = Text.input("拖入要加密文件.....:");

         String s = Text.input("设置密码:");

         Code.coding(file, "已加密" + Code.getformat(file), s.hashCode());

         System.out.println("加密成功.....");
      } catch (Exception e) {
         System.out.println("错误: " + e);
      }

   }

}
