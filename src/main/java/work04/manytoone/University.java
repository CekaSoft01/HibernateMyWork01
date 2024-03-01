package work04.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 class University {
    @Id
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    // * Getter-Setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //tostring


    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
