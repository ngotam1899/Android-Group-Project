package hcmute.edu.vn.foody07;

public class Wifi {
    public int IdWifi;
    public String NameWifi;
    public String PassWifi;
    public int IdShopFood;

    public Wifi(int idWifi, String nameWifi, String passWifi, int idShopFood) {
        IdWifi = idWifi;
        NameWifi = nameWifi;
        PassWifi = passWifi;
        IdShopFood = idShopFood;
    }

    public int getIdWifi() {
        return IdWifi;
    }

    public String getNameWifi() {
        return NameWifi;
    }

    public String getPassWifi() {
        return PassWifi;
    }

    public int getIdShopFood() {
        return IdShopFood;
    }

    public void setIdWifi(int idWifi) {
        IdWifi = idWifi;
    }

    public void setNameWifi(String nameWifi) {
        NameWifi = nameWifi;
    }

    public void setPassWifi(String passWifi) {
        PassWifi = passWifi;
    }

    public void setIdShopFood(int idShopFood) {
        IdShopFood = idShopFood;
    }
}
