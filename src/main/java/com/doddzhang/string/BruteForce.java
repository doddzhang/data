package com.doddzhang.string;

import cn.hutool.core.util.StrUtil;

/**
 * BF算法 brute force
 *
 * @author doddzhang
 */
public class BruteForce {

    /**
     * 算法主体
     *
     * @param main
     * @param mode
     * @return
     */
    public static int search(String main, String mode) {

        if (StrUtil.isAllNotBlank(main, mode)) {
            for (int i = 0; i < main.length(); i++) {
                for (int m = 0; m < mode.length(); m++) {
                    if (main.charAt(i + m) != mode.charAt(m)) {
                        break;
                    }
                    if (m == mode.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String main = "abccd";
        String mode = "cd";

        System.out.println(search(main, mode));
    }
}
