import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        long l = 99999999L;
        String k = "";
        while (l > 0) {
            k = l + "";
            map.put(k, k);
            l--;
        }
        System.out.println(map.size());

    }
}