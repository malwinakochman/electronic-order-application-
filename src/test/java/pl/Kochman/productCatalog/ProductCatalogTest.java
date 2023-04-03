package pl.Kochman.productCatalog;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductCatalogTest {

    @Test
    void itExposeEmptyCollectionOfProduct() {

        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertListIsEmpty(products);
    }

    @Test
    void itAllowsToAddProduct() {

        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego set 8080", "nice one");
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct("lego set 8080", "nice one");

        Product loadedProduct = catalog.loadById(productId);
        assert loadedProduct.getId().equals(productId);
    }

    @Test
    void itAllowsToChangePrice() {

    }

    @Test
    void itAllowsToAssignImage() {

    }

    @Test
    void itAllowsToPublishProduct() {

    }

    @Test
    void publicationIsPossibleWhenPriceAndImageAreDefined() {

    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    private void assertListIsEmpty(List<Product> products) {
        assert 0 == products.size();
    }
}