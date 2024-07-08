import java.util.ArrayList;
import java.util.List;

interface Product{
    void display();
}
class ClothingProduct implements Product{
    @Override
    public void display(){
        System.out.println("This is a clothing product");
    }
}
class ElectronicProduct implements Product{
    @Override
    public void display(){
        System.out.println("This is an electronic product");
    }
}
//ProductFactory should have control and logic to create Product object
class ProductFactory{
    public Product createProduct(String category){
        switch(category.toLowerCase()){
            case "electronics":
                return new ElectronicProduct();
            case "clothing":
                return new ClothingProduct();
            default:
                throw new IllegalArgumentException("Inavlid category asked: "+category);
        }
    }
}
//Builder Design Pattern
class UserAccount{
    private String username;
    private String password;
    private UserAccount(UserAccountBuilder builder){
        this.username=builder.username;
        this.password=builder.password;
    }
    public static class UserAccountBuilder{
        private final String username;
        private final String password;
        public UserAccountBuilder(String username,String password){
            this.username=username;
            this.password=password;
        }
        public UserAccount build(){
            return new UserAccount(this);
        }
    }
}
class Order{
    private String orderId;
    private List<Product> products;
    private Order(OrderBuilder builder){
        this.orderId=builder.orderId;
        this.products=builder.products;
    }
    static class OrderBuilder{
        private final String orderId;
        private final List<Product> products;
        public OrderBuilder(String orderId,List<Product> products){
            this.orderId=orderId;
            this.products=products;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
class UserDatabase{
    private static UserDatabase instance;
    //Make the constructor Private Because object is creating using constructor
    private UserDatabase(){

    }
    //synchronized -> ensure that in multithreaded environment single instance willl create
    public static synchronized UserDatabase getInstance(){
        if(instance==null){
            return instance=new UserDatabase();
        }else {
            return instance;
        }
    }
}
public class ShopWorld {
    public static void main(String[] args) {
        //create user database -> singleton
        UserDatabase userDatabase1=UserDatabase.getInstance();
        UserDatabase userDatabase2=UserDatabase.getInstance();
        System.out.println("Is reference of user database same? \n"+ (userDatabase1==userDatabase2));

        //Factory to produce products -> factory design pattern
        ProductFactory productFactory=new ProductFactory();
        Product electronicProduct=productFactory.createProduct("electronics");
        electronicProduct.display();
        Product clothingProduct=productFactory.createProduct("clothing");
        clothingProduct.display();

        //buid the user account -> builder design pattern
        UserAccount.UserAccountBuilder userBuilder=new UserAccount.UserAccountBuilder("username", "password");
        UserAccount userAccount=userBuilder.build();
        System.out.println("User account created: "+userAccount);

        List<Product> product=new ArrayList<>();
        product.add(electronicProduct);
        product.add(clothingProduct);

        //Build order account -> builder design pattern
        Order.OrderBuilder orderBuilder=new Order.OrderBuilder("orderId", product);
        Order order=orderBuilder.build();
        System.out.println("Order is placed: "+order);

    }
}
