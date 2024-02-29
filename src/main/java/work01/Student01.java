package work01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student_01")
public class Student01 {
    @Id
    public Long id;

}
