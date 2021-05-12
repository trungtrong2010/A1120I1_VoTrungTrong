package _10_ads_arraylist_linkedlist._bt_add;

public class Bao extends TaiLieu {
    private int ngayPhatHanh;

    public Bao(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao(int maTaiLieu, String nameNhaSX, int soBangPhatHanh, int ngayPhatHanh) {
        super(maTaiLieu, nameNhaSX, soBangPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String toString() {
        return "Bao{" +
                "ngayPhatHanh=" + ngayPhatHanh +
                '}';
    }
}
