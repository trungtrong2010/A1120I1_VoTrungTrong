package _10_ads_arraylist_linkedlist._bt_add;

public abstract class TaiLieu {
    private int maTaiLieu;
    private String nameNhaSX;
    private int soBanPhatHanh;

    public TaiLieu() {
    }

    public TaiLieu(int maTaiLieu, String nameNhaSX, int soBangPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nameNhaSX = nameNhaSX;
        this.soBanPhatHanh = soBangPhatHanh;
    }

    public int getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(int maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getNameNhaSX() {
        return nameNhaSX;
    }

    public void setNameNhaSX(String nameNhaSX) {
        this.nameNhaSX = nameNhaSX;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    @Override
    public String toString() {
        return "TaiLieu{" +
                "maTaiLieu=" + maTaiLieu +
                ", nameNhaSX='" + nameNhaSX + '\'' +
                ", soBangPhatHanh=" + soBanPhatHanh +
                '}';
    }
}
