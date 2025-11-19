package devises_1290.a10.model;

import jakarta.persistence.*;

@Entity

public class Rate {
    private static int AUTOGEN_ID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="value", nullable = false, scale = 18 , precision = 6 )
    // changer type pour BigDecimal
    private double value;

    @ManyToOne
    @JoinColumn(name="id_currency")
    Currency curr;

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Value: %.2f", id, value);
    }
}
