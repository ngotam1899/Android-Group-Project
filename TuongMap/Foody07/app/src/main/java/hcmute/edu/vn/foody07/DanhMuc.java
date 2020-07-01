package hcmute.edu.vn.foody07;

public class DanhMuc {
    public int IdMenu;
    public String NameMenu;
    public int IdShopFood;

    public DanhMuc(int idMenu, String nameMenu) {
        IdMenu = idMenu;
        NameMenu = nameMenu;
    }

    public int getIdMenu() {
        return IdMenu;
    }

    public String getNameMenu() {
        return NameMenu;
    }

    public int getIdShopFood() {
        return IdShopFood;
    }

    public void setIdMenu(int idMenu) {
        IdMenu = idMenu;
    }

    public void setNameMenu(String nameMenu) {
        NameMenu = nameMenu;
    }

    public void setIdShopFood(int idShopFood) {
        IdShopFood = idShopFood;
    }
}
