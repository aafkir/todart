package ma.todart.entities;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor
public class Category implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    private String photo;
    private String descripton;

    @OneToMany (mappedBy = "category")
    private Collection<Product> products;


    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Category( String name, String photo, String descripton, Collection<Product> products) {

        this.name = name;
        this.photo = photo;
        this.descripton = descripton;
        this.products = products;
    }
}
