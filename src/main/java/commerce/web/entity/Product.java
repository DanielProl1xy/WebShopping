package commerce.web.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column("productid")
    @JsonProperty
    private Long id;
    
    @Column("productname")
    @JsonProperty
    private String name;
    
    @Column("productdescription")    
    @JsonProperty
    private String description;
    
    @Column("imagesrc")
    @JsonProperty
    private String imageSrc;

    @Column("price")
    @JsonProperty
    private float price;

    public Product(String name, String description, String imageSrc, float price) {
        this.name = name;
        this.description = description;
        this.imageSrc = imageSrc;
        this.price = price;
    }

    @PersistenceCreator
    @JsonCreator
    public Product(Long id, String name, String description, String imageSrc, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageSrc = imageSrc;
        this.price = price;
    }

    public void setName(String name) {
        this.name = new String(name);
    }

    public void setDescription(String description) {
        this.description = new String(description);
    }

    public void setImageSrc(String src) {
        this.imageSrc = new String(src);
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public final Long getID() {
        return this.id;
    }

    public final String getName() {
        return new String(name);
    }

    public final String getDescription() {
        return new String(description);
    }

    public final String getImageSrc() {
        return new String(imageSrc);
    }

    public final float getPrice() {
        return price;
    }
}
