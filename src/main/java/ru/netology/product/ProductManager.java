package ru.netology.product;
public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }
    public void add(Product item) {
        repo.save(item);
    }

    public Product[] getProducts() {
        Product[] all = repo.getProducts();

        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repo.getProducts()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
            Product tmp[] = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
    }
    // метод определения соответствия товара product запросу search
//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//        // или в одну строку:
//        // return product.getName().contains(search);
//    }
}
