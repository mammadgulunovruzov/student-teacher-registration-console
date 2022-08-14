public class StudentService extends ManagementService{


    public static Student[] students;

    public  void process() {
        int studentOperation = InputUtility.askInt("Enter an operation:\n" +
                "(1) for Creating a Student\n" +
                "(2) for Searching a Student\n" +
                "(3) for Deleting a Student\n" +
                "(4) for Updating a Student\n" +
                "(5) for Showing all Students");
        if (studentOperation == 1) {
            register();

        } else if (studentOperation == 2) {
            search();
        } else if (studentOperation == 3) {
            delete();

        } else if (studentOperation == 4) {
            update();

        } else if (studentOperation == 5) {
            showAll();


        }
    }
    public static Student prepareStudent() {
        String name = InputUtility.askStirng("Enter student name");
        String surname = InputUtility.askStirng("Enter student surname");
        Integer age = InputUtility.askInt("Enter student age");
        Double scholarship = InputUtility.askDouble("Enter student scholarship");
        Student student = new Student(name, surname, age, scholarship);


        String universityName = InputUtility.askStirng("Enter student university");
        University university = new University(universityName);
        student.setUniversity(university);

        return student;
    }



    public  void register(){
        int numberOfStudents = InputUtility.askInt("Enter the number of students");
        students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = prepareStudent();
        }



    }

    public  void search(){
        String search = InputUtility.askStirng("Enter name || surname || age ||scholarship || university of a Student").toLowerCase();
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            String studentName = students[i].getName();
            String studentSurname = students[i].getSurname();
            String studentAge = students[i].getAge().toString();
            String studentScholarship = students[i].getScholarship().toString();
            String studentUniversity = students[i].getUniversity().getName();

            if (StringUtility.containsIgnoreCase(studentName, search) ||
                    StringUtility.containsIgnoreCase(studentSurname, search) ||
                    StringUtility.containsIgnoreCase(studentAge, search) ||
                    StringUtility.containsIgnoreCase(studentScholarship, search) ||
                    StringUtility.containsIgnoreCase(studentUniversity, search)) {
                System.out.println(i+"."+student);
            }

        }

    }

    public  void delete(){

        showAll();
        int deletedStudentNumber = InputUtility.askInt("Enter the number of student to be deleted");
        students[deletedStudentNumber] = null;

        Student [] newStudents =  new Student[students.length-1];
        int j=0;
        for (int i=0; i<students.length; i++){
            if(students[i]!=null){
                newStudents[j]=students[i];
                j++;
            }
        }

        students=newStudents;


    }

    public  void update(){
        showAll();

        int studentNumber = InputUtility.askInt("Enter the number of student to be updated");

        Student updatedStudent = students[studentNumber];

        while (true){
            String field = InputUtility.askStirng("Which field do you want to update: name, surname, age, scholarship or university");
            if(field.equalsIgnoreCase("name")){
                updatedStudent.setName(InputUtility.askStirng("Enter new student name"));
            } else if (field.equalsIgnoreCase("surname")) {
                updatedStudent.setSurname(InputUtility.askStirng("Enter newstudent surname"));
            } else if (field.equalsIgnoreCase("age")) {
                updatedStudent.setAge(InputUtility.askInt("Enter new student age"));
            } else if (field.equalsIgnoreCase("scholarship")) {
                updatedStudent.setScholarship(InputUtility.askDouble("Enter new student scholarship"));
            } else if (field.equalsIgnoreCase("university")) {
                String universityName = InputUtility.askStirng("Enter new student university");
                University university = new University(universityName);
                updatedStudent.setUniversity(university);
            } else if (field.equalsIgnoreCase("done")) {
                break;
            }else {
                System.out.println("Wrong operation");
            }

        }





    }
    public  void showAll(){
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println(i+"."+student);
        }
    }

}
