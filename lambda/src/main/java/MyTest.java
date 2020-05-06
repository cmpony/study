import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MyTest {
    private final static long MAX = 9_000_000_000L;
    public static void main(String[] args) throws Exception {

        int[] ints = IntStream.range(0, 10).toArray();
        System.out.println(AddressPrint.addressOf(ints));
        System.out.println(AddressPrint.addressOf(ints[0]));
        System.out.println(AddressPrint.addressOf(ints[1]));
        System.out.println(AddressPrint.addressOf(ints[2]));
    }
}
