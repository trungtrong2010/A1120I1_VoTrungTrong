package _06_ke_thua._bt._3_Point_MoveablePoint;

import _06_ke_thua._bt._2_point2d_point3d.Point2D;

import java.time.Year;

public class MoveablePoint extends Point2D {
    public float xSpeed;
    public float ySpeed;
    private Object MoveablePoint;

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{this.xSpeed, this.ySpeed};
    }


    public MoveablePoint move() {
        float newX = super.getX() + this.xSpeed;
        float newY = super.getY() + this.ySpeed;
        super.setX(newX);
        super.setY(newY);
        return this;
    }

    @Override
    public String toString() {
        return "Speed= {" +
                "xSpeed=" + this.xSpeed +
                ", ySpeed=" + this.ySpeed +
                ", MoveablePoint=" + (super.getX()+this.xSpeed)+
                '}';
    }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 3, 4);
        System.out.println(moveablePoint.move());
    }
}
