package 创建型设计模式.factory.抽象工厂模式;

public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}