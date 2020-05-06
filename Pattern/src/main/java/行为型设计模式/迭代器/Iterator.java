package 行为型设计模式.迭代器;

public interface Iterator<Item> {
    Item next();

    boolean hasNext();
}