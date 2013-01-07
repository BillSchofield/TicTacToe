package org.bill.tictactoe;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Lists2 {
    public static <T>List<T> filter(List<T> list, Predicate<T> predicate){
        return newArrayList(Collections2.filter(list, predicate));
    }
}
