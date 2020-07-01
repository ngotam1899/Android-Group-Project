package hcmute.edu.vn.foody07;

public class MonAn {
    public int IdDishes;
    public String NameDishes;
    public byte[] Image;
    public int Price;
    public int IdMenu;

    public MonAn( String nameDishes, byte[] image, int price) {
        NameDishes = nameDishes;
        Image = image;
        Price = price;
    }

    public int getIdDishes() {
        return IdDishes;
    }

    public String getNameDishes() {
        return NameDishes;
    }

    public byte[] getImage() {
        return Image;
    }

    public int getPrice() {
        return Price;
    }

    public int getIdMenu() {
        return IdMenu;
    }

    public void setIdDishes(int idDishes) {
        IdDishes = idDishes;
    }

    public void setNameDishes(String nameDishes) {
        NameDishes = nameDishes;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setIdMenu(int idMenu) {
        IdMenu = idMenu;
    }
}
