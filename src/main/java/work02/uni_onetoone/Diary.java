package work02.uni_onetoone;

import javax.persistence.*;

@Entity
public class Diary {//öğrenci günlüğü
    @Id
    private int id;
    @Column(nullable = false, length = 25)
    private String name;

    @OneToOne
    @JoinColumn(name = "std_id")//forein key row name
    private Student student;

    //!!! GETTER - SETTER

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // !!! toString() *****************************

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }

}
