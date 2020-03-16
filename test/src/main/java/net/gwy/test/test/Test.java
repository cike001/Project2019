package net.gwy.test.test;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gwy
 * @time 2020-02-03 11:52
 * @desc TODO
 **/
public class Test {


    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        BigDecimal a = BigDecimal.ZERO;

        list.forEach(r->{
            a.add(new BigDecimal(r.intValue()));
        });
        System.out.println(a);

    }

}
