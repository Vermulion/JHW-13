import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductRepositoryTest {

    Product book1 = new Book(   1, "Книги", 200, "Кошмары Аиста Марабу", "Ирвин Уэлш");
    Product smartphone1 = new Smartphone(11, "Phones", 70990, "iPhone 15Pro", "Apple");

    @Test
    public void shouldAddProducts() { //Элементы добавляются успешно

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);

        repo.getProducts();

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.removeById(1);

        Product[] expected = {smartphone1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetNotFoundException() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }

    @Test
    public void shouldGetAlreadyExistsException() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(smartphone1);
        });
    }

}
