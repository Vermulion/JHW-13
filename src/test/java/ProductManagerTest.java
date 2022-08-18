import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(   1, "Книги", 200, "Кошмары Аиста Марабу", "Ирвин Уэлш");
    Product smartphone1 = new Smartphone(11, "Phones", 70990, "iPhone 15Pro", "Apple");

    Product book2 = new Book(2, "Книги", 899, "Атлант расправил плечи", "Айрен Ренд");

    @BeforeEach
    public void test() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
    }
    @Test
    public void shouldAddProduct() {
        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = manager.getProducts();


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProduct() {
    Product[] expected = {smartphone1};
    Product[] actual = manager.searchBy("Phones");

    Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnyProduct() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Смартфоны");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSeveralProducts() {
        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Книги");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthor() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Айрен Ренд");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByManufacturer() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);
    }
}
