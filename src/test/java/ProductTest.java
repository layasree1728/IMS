import org.example.*;

import java.util.*;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest{
    Product product1;
    Product product2;
    @Before
    public void setUp(){
        product1=new Product(1,"charger","gadget",200.00,3000);
        product2=new Product(2,"bluetooth","gadget",999.99,1000);
        inventoryManagement.add_or_updateProduct(product1);
        inventoryManagement.add_or_updateProduct(product2);
    }
    @Test
    public void testAddOrUpdateProduct(){
        Product newProduct=new Product(1,"updated_Chargers","gadget",300.00,3000);
        inventoryManagement.add_or_updateProduct(newProduct);
        Product updatedProduct = inventoryManagement.searchProduct(1);
        assertNotNull("Product should not be null", updatedProduct);
        assertEquals("Product name should be 'updated_chargers'", "updated_Chargers", updatedProduct.getName());
        assertEquals("Product price should be 300.00", (Object)300.00, (Object)updatedProduct.getPrice());
        assertEquals("Product quantity should be 3000", 3000, updatedProduct.getQuantity());
    }
 
    @Test
    public void testRemoveProduct(){
       inventoryManagement.removeProduct(1);
        Product removedProduct = inventoryManagement.searchProduct(1);
        assertNull("Product should be null after removal", removedProduct);
    }
    @Test
    public void testSearchProduct() {
        Product foundProduct = inventoryManagement.searchProduct(1);
        assertNotNull("Product should be found", foundProduct);
        assertEquals("Product name should be 'charger'", "charger", foundProduct.getName());
    }

    @Test
    public void testListProducts() {
        assertEquals("Product list size should be 1", 4, inventoryManagement.listingProduct().size());
    }
    @Test
    public void testCategories() {
        // Test the unique categories
        Product product1 = new Product(3, "new_widget", "gadget", 150.00, 1500);
        Product product2 = new Product(4, "another_widget", "appliance", 250.00, 2500);
        inventoryManagement.add_or_updateProduct(product1);
        inventoryManagement.add_or_updateProduct(product2);
        assertTrue("Categories should contain 'gadget'", inventoryManagement.getCategories().contains("gadget"));
        assertTrue("Categories should contain 'appliance'", inventoryManagement.getCategories().contains("appliance"));
        assertFalse("Categories should not contain 'nonexistent'", inventoryManagement.getCategories().contains("nonexistent"));
    }
    @Test
    public void testsortingByName(){
        inventoryManagement.setSorting(new NameComparator());
        List<Product> products=inventoryManagement.listingProduct();
        assertEquals("First Product name should be charger","charger",products.get(0).getName());
        assertEquals("Second Product name should be bluetooth","bluetooth",products.get(1).getName());

    }
    @Test
    public void testsortingByID(){
        inventoryManagement.setSorting(new IdComparator());
        List<Product> products=inventoryManagement.listingProduct();
        assertEquals("First Product ID should be 1",1,products.get(0).getProduct_id());
        assertEquals("Second Product ID should be 2",2,products.get(1).getProduct_id());

    }
    @Test
    public void testsortingByquantity(){
        inventoryManagement.setSorting(new QuantityComparator());
        List<Product> products=inventoryManagement.listingProduct();
        assertEquals("First Product quantity should be 3000",3000,products.get(0).getQuantity());
        assertEquals("Second Product quantity should be 1000",1000,products.get(1).getQuantity());

    }
}