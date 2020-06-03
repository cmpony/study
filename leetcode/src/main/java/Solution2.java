import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2 {
    public static void main(String[] args) {
        ClassLoader ctxClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(ctxClassLoader);

    }
}