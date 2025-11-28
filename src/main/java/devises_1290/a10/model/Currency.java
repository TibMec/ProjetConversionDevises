package devises_1290.a10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Currency")
@NamedQuery(
        name = "Currency.findByName",
        query = " SELECT c\n FROM Currency c\n WHERE c.name = :name\n"
)
public class Currency {
    private static int AUTOGEN_ID = 0;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "name",
            length = 150,
            nullable = false
    )
    private String name;
    @Column(
            name = "country",
            length = 150,
            nullable = false
    )
    private String country;
    @OneToMany(
            mappedBy = "currency",
            fetch = FetchType.EAGER
    )
    private List<Rate> rates = new ArrayList();

    public Currency() {
    }

    public Currency(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Currency(String name, String country) {
        this.id = AUTOGEN_ID++;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Rate> getRates() {
        return this.rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String toString() {
        return String.format("ID: %d, Name: %s, Country: %s", this.id, this.name, this.country);
    }

    public Rate getRate() {
        return this.rates != null && !this.rates.isEmpty() ? (Rate)this.rates.get(0) : null;
    }
}
