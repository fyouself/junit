import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class testShop {
    @Test
    public void sumPriceCart (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);

        Assertions.assertEquals(620.00d,cart.getTotalPrice());
    }
    @Test
    public void sumPriceMiltiCart (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);

        Assertions.assertEquals(510.00d,cart.getTotalPrice());
    }

    @Test
    public void sumPriceDeltiCart (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);

        Assertions.assertEquals(340.00d,cart.getTotalPrice());
    }

    @Test
    public void test4 (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);

        Assertions.assertEquals(7,shop.getProductsShop().get(0).getQuantity());
    }

    @Test
    public void test5 (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        Assertions.assertEquals(0,shop.getProductsShop().get(0).getQuantity());
        Assertions.assertEquals(10,cart.cartItems.get(0).getQuantity());
    }

    @Test
    public void test6 (){
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.removeProductByID(1);
        Assertions.assertEquals(1,shop.getProductsShop().get(0).getQuantity());
        Assertions.assertEquals(9,cart.cartItems.get(0).getQuantity());
    }

    @ParameterizedTest
    @ValueSource ( ints = {-1,0,100})
    public void test7 (int id) {
        Shop shop = new Shop(Main.getStoreItems());
        Cart cart = new Cart(shop);

        Assertions.assertThrows(RuntimeException.class, ()-> { cart.addProductToCartByID(id);});
    }


}
