package work03.bi_onetoone;



import javax.persistence.*;

@Entity
@Table(name = "student03")
 class Student {

    @Id
    private int id;


    @Column(name = "std_name")
    private String name;


    private  int grade;

    @OneToOne(mappedBy = "student")//setleme student field'ine sahip entity clasından olacak.
    //setleme sahibi class da foreinkey olacak.yani diary de
    private Diary diary;



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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    //!!! toString() ***********************8

    @Override
    public String toString() {//StackOver hatası almamak için diary yi yazdırmıyoruz.
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }











}
