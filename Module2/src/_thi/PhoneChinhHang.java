package _thi;

public class PhoneChinhHang extends SmartPhone {

    int time;
    String phamViBaoHanh;

    public PhoneChinhHang(int id, String name, int value, int soLuong, String nhaSX, int time, String phamViBaoHanh) {
        super(id, name, value, soLuong, nhaSX);
        this.time = time;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "PhoneChinhHang{" +
                "time='" + time + '\'' +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                super.toString() + '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
