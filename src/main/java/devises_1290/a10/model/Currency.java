package devises_1290.a10.model;

import jakarta.persistence.*;

@Entity
@Table(name="Currency")
public class Currency {
    private static int AUTOGEN_ID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length = 100, nullable = false)
    private String name;

    @Column(name="country", length = 100, nullable = false)
    private String country;

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Country: %s", id, name, country);
    }
}
