package _06_ke_thua._th;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWdith();
    }

    public void setSide(double side) {
        setWith(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "Side = "
                + getSide()
                + " offfff"
                + super.toString();
    }
}
