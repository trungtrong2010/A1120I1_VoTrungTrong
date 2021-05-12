package _06_ke_thua._th;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 2.0;

    public Rectangle() {
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    public double getWdith() {
        return width;
    }

    public void setWith(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.length * this.width;
    }

    public double getPerimeter() {
        return (this.length + this.width) * 2;
    }

    @Override
    public String toString() {
        return "Width = "
                + getWdith()
                + " Length = "
                + getLength()
                + " Area = "
                + getArea()
                + " Perimeter "
                + getPerimeter();
    }
}
