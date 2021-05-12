package _14_sort._sort_all;

import java.util.Comparator;

public class TangGiam implements Comparator<Proman> {

    @Override
    public int compare(Proman proman, Proman t1) {
        return proman.getNumber() - t1.getNumber();
    }
}
