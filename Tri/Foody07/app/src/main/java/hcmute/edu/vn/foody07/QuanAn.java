package hcmute.edu.vn.foody07;

import java.time.LocalTime;

public class QuanAn {
    public int IdShopFood;
    public String NameShopFood;
    public String DiaChi;
    public String TypeShop;
    public byte[] Image;
    public int Min;
    public int Max;
    public double Latitude;
    public double Longitude;
    public String open;
    public String close;
    public int CodeNumber;

    public void setMin(int min) {
        Min = min;
    }

    public void setMax(int max) {
        Max = max;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public int getMin() {
        return Min;
    }

    public int getMax() {
        return Max;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public String getOpen() {
        return open;
    }

    public String getClose() {
        return close;
    }

    public void setCodeNumber(int codeNumber) {
        CodeNumber = codeNumber;
    }

    public int getCodeNumber() {
        return CodeNumber;
    }

    public void setIdShopFood(int idShopFood) {
        IdShopFood = idShopFood;
    }

    public void setNameShopFood(String nameShopFood) {
        NameShopFood = nameShopFood;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void setTypeShop(String typeShop) {
        TypeShop = typeShop;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public int getIdShopFood() {
        return IdShopFood;
    }

    public String getNameShopFood() {
        return NameShopFood;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getTypeShop() {
        return TypeShop;
    }

    public byte[] getImage() {
        return Image;
    }

    public QuanAn(String nameShopFood, String diaChi,byte[] image) {

        NameShopFood = nameShopFood;
        DiaChi = diaChi;
        Image = image;
    }

    public QuanAn(int idShopFood ,String nameShopFood, String diaChi,byte[] image,String typeShop) {
        IdShopFood = idShopFood;
        NameShopFood = nameShopFood;
        DiaChi = diaChi;
        Image = image;
        TypeShop = typeShop;
    }

    public QuanAn(String nameShopFood, String diaChi,String typeShop,int min, int max,String open, String close) {

        NameShopFood = nameShopFood;
        DiaChi = diaChi;
        TypeShop = typeShop;
        Min = min;
        Max = max;
        this.open = open;
        this.close = close;
    }
}
