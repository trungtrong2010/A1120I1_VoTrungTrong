package _thi;

public class PhoneXachTay extends SmartPhone {

    String quocGia;
    String trangThai;

    public PhoneXachTay(int id, String name, int value, int soLuong, String nhaSX, String quocGia, String trangThai) {
        super(id, name, value, soLuong, nhaSX);
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhoneXachTay{" +
                "quocGia='" + quocGia + '\'' +
                ", trangThai='" + trangThai + '\'' +
                super.toString() + '}';
    }

    public void showInfor() {
        System.out.println(this.toString());
    }
}
