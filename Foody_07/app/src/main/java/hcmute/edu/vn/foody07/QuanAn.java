package hcmute.edu.vn.foody07;

public class QuanAn {
    public int IdShopFood;
    public String NameShopFood;
    public String DiaChi;
    public String TypeShop;
    public byte[] Image;
    public String Prices;

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

    public void setPrices(String prices) {
        Prices = prices;
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

    public String getPrices() {
        return Prices;
    }

    public QuanAn(String nameShopFood, String diaChi,byte[] image) {

        NameShopFood = nameShopFood;
        DiaChi = diaChi;
        Image = image;
    }
}
