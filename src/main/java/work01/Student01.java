package work01;

import javax.persistence.*;

@Entity
@Table(name = "t_student_01")
public class Student01 {
    @Id
    @Column(name = "std_id")
    private int id;

    @Column(name = "student_name",length = 100,nullable = false,unique = false)
    private  String name;

    private int grade;

    @Transient//sql de row eklemez.
    private int grade1;


    //!!! Getter- Setter  *********************************************

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // !!! toString() ***********************************
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
