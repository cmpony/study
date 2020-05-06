package juc.forkjoin;

import java.math.BigDecimal;

public class MyAdd {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        BigDecimal a =new BigDecimal(0);
        for (long i = 0; i < 10000000000l; i++){
            a=a.add(new BigDecimal(i));
        }
        System.out.println(a);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
    }
}
