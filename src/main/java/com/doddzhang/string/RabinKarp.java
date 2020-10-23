package com.doddzhang.string;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * RK算法 Rabin-Karp
 *
 * @author doddzhang
 */
public class RabinKarp {

    public static int search(String main, String mode) {
        if (mode.length() > main.length()) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>(main.length() - mode.length());
        for (int i = 0; i < main.length(); i++) {
            int end = i + mode.length();
            if (end > main.length()) {
                break;
            }

            String s = main.substring(i, end);
            map.put(hash(s), i);
        }

        return map.get(hash(mode));
    }

    /**
     * 自定义hash算法
     * 只允许a-z的26个英文字母
     * 通过26进制进行hash，不会产生hash冲突，且字符串不能太大
     * a->1 ...
     * z->26
     *
     * @param str
     * @return
     */
    public static int hash(String str) {

        if (!Pattern.matches("[a-z]+", str)) {
            return 0;
        }

        char[] st = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += ((int) st[i] - 96) * Math.pow(26, str.length() - 1 - i);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(search("asdfsdfasdfasd", "fa"));
    }
}



