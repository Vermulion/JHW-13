package ru.netology.product;
public class Smartphone extends Product {
    private String model;
    private String manufacturer;


    public Smartphone(int id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    // ваши поля, конструкторы, методы
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getManufacturer().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
