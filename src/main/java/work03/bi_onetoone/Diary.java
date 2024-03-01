package work03.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "diary03")
 class Diary {//öğrenci günlüğü
    @Id
    private int id;

    private String name;

    @OneToOne
   @JoinColumn(name = "std_id")
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

    //!!! toString() *************************

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
