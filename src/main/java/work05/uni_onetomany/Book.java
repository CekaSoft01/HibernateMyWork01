package work05.uni_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 class Book {
    @Id
    private int id;

    private String name;


    // * getter-setter

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
    //tostring

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
