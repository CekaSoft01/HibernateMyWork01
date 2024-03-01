package work04.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
class Student {
    @Id
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;


    private LocalDateTime createOn;


    @ManyToOne
    @JoinColumn(name="university_id")//default olarak many tarafına forein key atıkır.
    private University university;

    @PrePersist//bu class dan obje save edildiğinde çalışir
    public void prePersist(){
        createOn=LocalDateTime.now();
    }




    // * getter


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public University getUniversity() {
        return university;
    }

    // *setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    /*   public void setCreateOn(LocalDateTime createOn) {
           this.createOn = createOn;
       }
   */
    public void setUniversity(University universty) {
        this.university = universty;
    }


    //tostring

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", universty=" + university +
                '}';
    }
}
