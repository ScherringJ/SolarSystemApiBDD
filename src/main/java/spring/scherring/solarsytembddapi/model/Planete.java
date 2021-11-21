package spring.scherring.solarsytembddapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String discovery;
    private String type;

    protected Planete() {}

    public Planete(Integer id, String name, String discovery, String type) {
        this.id = id;
        this.name = name;
        this.discovery = discovery;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscovery() {
        return discovery;
    }

    public void setDiscovery(String discovery) {
        this.discovery = discovery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Planete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discovery='" + discovery + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
