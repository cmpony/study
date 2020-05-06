package 创建型设计模式.factory.抽象工厂模式;

public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}