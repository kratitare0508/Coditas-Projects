import javax.persistence.*;

@Entity
@Table(name="newproduct")
public class Product {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productid;
    private String productname;
    private int availibility;
    private int price;

   private int addedquantity;


    public Product(String productname, int availibility, int price, int addedquantity) {
        this.productname = productname;
        this.availibility = availibility;
        this.price = price;
        this.addedquantity = addedquantity;
    }

    public int getAvailibility() {
        return availibility;
    }

    public void setAvailibility(int availibility) {
        this.availibility = availibility;
    }

    public int getAddedquantity() {
        return addedquantity;
    }

    public void setAddedquantity(int addedquantity) {
        this.addedquantity = addedquantity;
    }

    @ManyToOne
    private Customer customer;

     public Product()
     {
         super();
     }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }





    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public int getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product(int productid, String productname, int availibility, int price, int addedquantity) {
        this.productid = productid;
        this.productname = productname;
        this.availibility = availibility;
        this.price = price;
        this.addedquantity = addedquantity;
    }
}
