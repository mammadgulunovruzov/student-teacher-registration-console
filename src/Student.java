import java.io.Serializable;

public class Student implements Serializable {


    public static final long serialVersionUID =1;

    private String name;
    private String surname;
    private Integer age;
    private Double scholarship;
    private University university;

    public Student(String name, String surname, Integer age, Double scholarship) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.scholarship = scholarship;
    }
    public Student(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public Student[] setName(String name) {
        this.name = name;
        return new Student[0];
    }

    public String getSurname() {
        return surname;
    }

    public Student[] setSurname(String surname) {
        this.surname = surname;
        return new Student[0];
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", scholarship=" + scholarship +
                ", university_" + university ;
    }


}
