package _10_ads_arraylist_linkedlist._bt_add;

public class Sach extends TaiLieu {
    private String nameTacGia;
    private int soTrang;

    public Sach(String nameTacGia, int soTrang) {
        this.nameTacGia = nameTacGia;
        this.soTrang = soTrang;
    }

    public Sach(int maTaiLieu, String nameNhaSX, int soBanPhatHanh, String nameTacGia, int soTrang) {
        super(maTaiLieu, nameNhaSX, soBanPhatHanh);
        this.nameTacGia = nameTacGia;
        this.soTrang = soTrang;
    }

    public String getNameTacGia() {
        return nameTacGia;
    }

    public void setNameTacGia(String nameTacGia) {
        this.nameTacGia = nameTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "nameTacGia='" + nameTacGia + '\'' +
                ", soTrang=" + soTrang +
                '}';
    }
}
