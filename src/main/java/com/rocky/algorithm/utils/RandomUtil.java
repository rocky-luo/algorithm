package com.rocky.algorithm.utils;

import java.util.List;
import java.util.Random;

/**
 * Created by yahto on 26/10/2017
 */
public class RandomUtil {
    /**
     * 生成一个int随机数
     * @param min
     * @param max
     * @return
     */
    public static int intRandom(int min, int max) {
        if (min > max) throw new IllegalArgumentException("min can not bigger than max");
        if (max == min) return max;
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * 随机挑选一个
     * @param list
     * @param <T>
     * @return
     */
    public static<T> T chooseOne(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }else {
            return list.get(intRandom(0, list.size() -1 ));
        }
    }
}
