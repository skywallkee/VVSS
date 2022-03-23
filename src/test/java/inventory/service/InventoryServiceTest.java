package inventory.service;

import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    InventoryRepository inventoryRepository;
    InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InventoryRepository("data/items.txt");
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Tag("price tests")
    @DisplayName("parametrized test for invalid price value")
    @ParameterizedTest
    @ValueSource(doubles = { 0.00 })
    void invalidPriceValueAddInhousePart(Double price) {
        try{
            inventoryService.addInhousePart("Produs1", price, 5, 1, 10, 1);
            fail();
        }
        catch(InventoryService.ServiceException serviceException){
            assertTrue(true);
        }
    }

    @Tag("price tests")
    @DisplayName("parametrized test for invalid price type")
    @ParameterizedTest
    @ValueSource(strings = { "cinci" })
    void invalidPriceTypeAddInhousePart(Double price) {
        try{
            inventoryService.addInhousePart("Produs2", price, 5, 1, 10, 1);
            fail();
        }
        catch(Exception typeException){
            assertTrue(true);
        }
    }

    @Tag("price tests")
    @DisplayName("parametrized test for valid price")
    @ParameterizedTest
    @ValueSource(doubles = { 0.01 })
    void validPriceAddInhousePart(Double price) {
        try{
            inventoryService.addInhousePart("Produs3", price, 5, 1, 10, 1);
            assertTrue(true);
        }
        catch(InventoryService.ServiceException serviceException){
            fail();
        }
    }

    @Tag("inStock_tests")
    @DisplayName("parametrized test for valid inStock")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 10 })
    void validInStockAddInhousePart(Integer inStock) {
        try{
            inventoryService.addInhousePart("Produs4", 5, inStock, 1, 10, 1);
            assertTrue(true);
        }
        catch(InventoryService.ServiceException serviceException){
            fail();
        }
    }

    @Tag("inStock_tests")
    @DisplayName("parametrized test for invalid inStock value")
    @ParameterizedTest
    @ValueSource(ints = { -5, 0, 11, 50 })
    void invalidInStockValueAddInhousePart(Integer inStock) {
        try{
            inventoryService.addInhousePart("Produs5", 5, inStock, 1, 10, 1);
            fail();
        }
        catch(InventoryService.ServiceException serviceException){
            assertTrue(true);
        }
    }

    @Tag("inStock_tests")
    @DisplayName("parametrized test for invalid inStock type")
    @ParameterizedTest
    @ValueSource(doubles = { 5.5 })
    void invalidInStockTypeAddInhousePart(Double inStock) {
        try{
            inventoryService.addInhousePart("Produs6", 5, Integer.parseInt(inStock.toString()), 1, 10, 1);
            fail();
        }
        catch(Exception exception){
            assertTrue(true);
        }
    }
}