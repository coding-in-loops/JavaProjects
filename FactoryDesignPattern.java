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
public class FactoryDesignPattern {
    public static void main(String[] args) {
        //Using the factory to create products 
        ProductFactory productFactory=new ProductFactory();

        //Creation logic is abstract and managed
        Product product1=productFactory.createProduct("electronics");
        Product product2=productFactory.createProduct("clothing");
        product1.display();
        product2.display();
    }
}
