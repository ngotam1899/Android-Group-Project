package hcmute.edu.vn.ngotam.sqliteimage;

public class Food {
    private int Id;
    private String Ten;
    private String DiaChi;
    private String KhoangCach;
    private String LoaiHinh;
    private byte[] Hinh;

    public Food(int id, String ten, String diaChi, String khoangCach, String loaiHinh, byte[] hinh) {
        Id = id;
        Ten = ten;
        DiaChi = diaChi;
        KhoangCach = khoangCach;
        LoaiHinh = loaiHinh;
        Hinh = hinh;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void setKhoangCach(String khoangCach) {
        KhoangCach = khoangCach;
    }

    public void setLoaiHinh(String loaiHinh) {
        LoaiHinh = loaiHinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public String getTen() {
        return Ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getKhoangCach() {
        return KhoangCach;
    }

    public String getLoaiHinh() {
        return LoaiHinh;
    }

    public byte[] getHinh() {
        return Hinh;
    }
}
