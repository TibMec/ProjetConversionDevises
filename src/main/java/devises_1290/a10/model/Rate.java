package devises_1290.a10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rate")
@NamedQuery(
        name = "Rate.findRateByCurrencyName",
        query = " SELECT r\n FROM Rate r\n JOIN r.currency c\n WHERE c.name = :name\n"
)
public class Rate {
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
            name = "rate_value",
            nullable = false
    )
    private double value;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "id_currency"
    )
    Currency currency;

    public Rate() {
    }

    public Rate(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public Rate(double value) {
        this.id = AUTOGEN_ID++;
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String toString() {
        return String.format("ID: %d, Value: %.2f", this.id, this.value);
    }
}
