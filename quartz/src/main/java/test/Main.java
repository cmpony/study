package test;

import java.util.*;

/**
 * 输入1~n个数组，用,分割
 * 输入示例：    2                    //截取的长度
 *              2,4,5
 *              9,4,8,8
 *              4,2
 *
 * 输出结果:     2,4,9,4,4,2,5,8,8
 */

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        int maxLength = 0;
        List<String> list = new ArrayList<>();
        String str;
        while (!(str = sc2.nextLine()).equals("")) {
            String s = str.replaceAll(",", "");
            list.add(s);
            if (s.length() > maxLength) {
                maxLength = s.length() / len + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (maxLength > 0) {
            for (int i = 0; i <list.size();i++) {
                if (list.get(i).length() > len) {
                    String sub = list.get(i).substring(0, len);
                    sb.append(sub);
                    list.set(i, list.get(i).substring(len));
                } else {
                    sb.append(list.get(i));
                    list.set(i, "");
                }
            }
            maxLength--;
        }

        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) {
                System.out.print(chars[i]);
            } else {
                System.out.print(chars[i] + ",");
            }
        }
    }
}