package _14_sort._sort_all;

public class Proman implements Comparable<Proman> {
    private int number;

    public Proman(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number + "";
    }

    @Override
    public int compareTo(Proman proman) {
        return proman.number - this.number;
    }
}
