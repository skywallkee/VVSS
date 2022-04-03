package inventory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Inventory inventory;
    Inventory emptyInventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        emptyInventory = new Inventory();
        inventory.addProduct(new Product(1, "Clock", 1.01, 5, 1, 10, null));
        inventory.addProduct(new Product(2, "product2", 1.01, 5, 1, 10, null));
        inventory.addProduct(new Product(4, "products4", 1.01, 5, 1, 10, null));
    }

    @Test
    @Tag("Valid")
    @DisplayName("test for the found case, when the lookup name is in the Product Name")
    void foundProductByName(){
        assertEquals(1, inventory.lookupProduct("Clock").getProductId());
    }

    @Test
    @Tag("Valid")
    @DisplayName("test for the found case, when the lookup name is in the Product ID")
    void foundProductByName2(){
        assertEquals(2, inventory.lookupProduct("product2").getProductId());
    }

    @Test
    @Tag("Valid")
    @DisplayName("test for the found case, when the lookup name is in the Product ID")
    void foundProductById(){
        assertEquals(4, inventory.lookupProduct("4").getProductId());
    }

    @Test
    @Tag("Invalid")
    @DisplayName("test for the not found case")
    void productNotFound(){
        assertEquals(0, inventory.lookupProduct("NuExista").getProductId());
    }

    @Test
    @Tag("Invalid")
    @DisplayName("test for the not found case")
    void emptyListNotFound(){
        assertEquals(0, emptyInventory.lookupProduct("ListaGoala").getProductId());
    }

}