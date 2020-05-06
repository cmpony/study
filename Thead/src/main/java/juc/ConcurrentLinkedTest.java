package juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ConcurrentLinkedTest {
//    static final Unsafe UNSAFE = Unsafe.getUnsafe();
    static Unsafe UNSAFE = null;
    static {
        try {

            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    String head;
    String tail;
    public static void main(String[] args) throws NoSuchFieldException {

        Class<?> k = ConcurrentLinkedTest.class;
        long head = UNSAFE.objectFieldOffset(k.getDeclaredField("head"));
        long tail = UNSAFE.objectFieldOffset(k.getDeclaredField("tail"));
        System.out.println(head);
        System.out.println(tail);
    }
}
