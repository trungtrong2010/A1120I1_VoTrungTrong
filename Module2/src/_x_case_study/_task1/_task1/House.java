package _x_case_study._task1._task1;

public class House extends Services {

    private String tieuChuanPhong;
    private String paintedTienNghi;
    private int soTang;

    public House(String nameServices, int area, int money, int peopleMax, String rentalType,
                 String id, String dvPlus, String tieuChuanPhong, String paintedTienNghi, int soTang) {
        super(nameServices, area, money, peopleMax, rentalType, id, dvPlus);
        this.tieuChuanPhong = tieuChuanPhong;
        this.paintedTienNghi = paintedTienNghi;
        this.soTang = soTang;
    }

    public House() {
    }

    public String getTieuChuanPhong() {
        this.House();
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getPaintedTienNghi() {
        return paintedTienNghi;
    }

    public void setPaintedTienNghi(String paintedTienNghi) {
        this.paintedTienNghi = paintedTienNghi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "\n" + "House{" +
                "nameServices='" + super.getNameServices() + '\'' +
                ", area=" + super.getArea() +
                ", money=" + super.getMoney() +
                ", peopleMax=" + super.getPeopleMax() +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", id='" + super.getId() + '\'' +
                ", dvPlus='" + super.getDvPlus() + '\'' +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", paintedTienNghi='" + paintedTienNghi + '\'' +
                ", soTang=" + soTang +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }


}
