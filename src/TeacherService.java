public class TeacherService extends ManagementService{


    public static Student[] students;


    public static Teacher prepareTeacher(){
        Teacher teacher = new Teacher();

        teacher.setName(InputUtility.askStirng("Enter teacher name"));
        teacher.setSurname(InputUtility.askStirng("Enter teacher surname"));
        teacher.setAge(InputUtility.askInt("Enter teacher age"));
        teacher.setSalary(InputUtility.askDouble("Enter teacher salary"));

        String universityName = InputUtility.askStirng("Enter University name");
        University university =  new University(universityName  );
        teacher.setUniversity(university);



        int numberOfStudents = InputUtility.askInt("Enter the number of students");
        students = new Student[numberOfStudents];
        for (int i=0; i< students.length;i++) {
            String studentName = InputUtility.askStirng("Enter Student name");
            String studentSurname = InputUtility.askStirng("Enter Student surname");
            students[i] = new Student(studentName,studentSurname);
        }
        teacher.setStudents(students);

        return teacher;

    }

    public  void process() {

        int teacherOperation = InputUtility.askInt("Enter an operation:\n" +
                "(1) for Creating a Teacher\n" +
                "(2) for Searching a Teacher\n" +
                "(3) for Deleting a Teacher\n" +
                "(4) for Updating a Teacher\n" +
                "(5) for Showing all Teacher");
        if (teacherOperation == 1) {
            register();
            DB.save();
        } else if (teacherOperation == 2) {
            search();
        } else if (teacherOperation == 3) {
            delete();
            DB.save();
        } else if (teacherOperation == 4) {
           update();
            DB.save();
        } else if (teacherOperation == 5) {
            showAll();


        }



    }


    @Override
    public void register() {
        Integer numberOfTeachers = InputUtility.askInt("Enter the number of teachers");
        Teacher[] oldTeachers = DB.teachers;
        Teacher[] newTeachers = new Teacher[numberOfTeachers];

        for (int i=0; i<DB.teachers.length;i++ ){
            newTeachers[i]= prepareTeacher();
        }

        Teacher[] result = new Teacher[oldTeachers.length + newTeachers.length];

        System.arraycopy(oldTeachers, 0, result, 0, oldTeachers.length);
        System.arraycopy(newTeachers, 0, result, oldTeachers.length, newTeachers.length);

        DB.teachers = result;


    }


    @Override
    public void showAll() {
        if(DB.teachers == null){
            System.out.println("There is no any teacher to show");
        }
        for (int i=0; i< DB.teachers.length;i++){
            Teacher teacher = DB.teachers[i]   ;
            System.out.println(i+"."+ teacher);
        }

    }

    @Override
    public void delete(){
        showAll();

        int deletedTeacher = InputUtility.askInt("Enter the number of teacher to be deleted");
        DB.teachers[deletedTeacher]=null;


        Teacher[] newTeachers =  new Teacher[DB.teachers.length-1];
        int j=0;
        for (int i=0; i<DB.teachers.length;i++){
           if(DB.teachers[i]!=null) {
                newTeachers[j] = DB.teachers[i];
                j++;
            }
        }
        DB.teachers=newTeachers;


    }

    @Override
    public void update(){
        showAll();

        int numberOfUpdatedTeacher = InputUtility.askInt("Enter the number of teacher to be updated");
        Teacher updatedTeacher = DB.teachers[numberOfUpdatedTeacher];

      while (true)  {
            String field = InputUtility.askStirng("Which field do you want to update: name, surname, age, salary or university");
            if (field.equalsIgnoreCase("name")) {
                updatedTeacher.setName(InputUtility.askStirng("Enter new teacher name"));
            } else if (field.equalsIgnoreCase("surname")) {
                updatedTeacher.setSurname(InputUtility.askStirng("Enter new teacher surname"));
            } else if (field.equalsIgnoreCase("age")) {
                updatedTeacher.setAge(InputUtility.askInt("Enter new teacher age"));
            } else if (field.equalsIgnoreCase("salary")) {
                updatedTeacher.setSalary(InputUtility.askDouble("Enter new teacher salary"));
            } else if (field.equalsIgnoreCase("university")) {
                String teacherNewUniversity = InputUtility.askStirng("Enter new teacher university");
                University university = new University(teacherNewUniversity);
                updatedTeacher.setUniversity(university);
            } else if (field.equalsIgnoreCase("done")) {
                break;

            } else {
                System.out.println("wrong operation");
            }
        }


    }


    @Override
    public void search() {

        String search = InputUtility.askStirng("Enter name || surname || age ||salary || university of a Teacher").toLowerCase();
        for (int i =0; i<DB.teachers.length;i++){
            Teacher teacher = DB.teachers[i];
            String teacherName = DB.teachers[i].getName();
            String teacherSurname = DB.teachers[i].getSurname();
            String  teacherAge = DB.teachers[i].getAge().toString();
            String teacherSalary = DB.teachers[i].getSalary().toString();
            String  teacherUniversity = DB.teachers[i].getUniversity().getName();

            String teachersStudentName = null;
            String teachersStudentSurname = null;
            for (int j =0; j< students.length;j++){
                teachersStudentName = students[i].getName();
                teachersStudentSurname = students[i].getSurname();

            }

            if (StringUtility.containsIgnoreCase(teacherName,search) ||
                StringUtility.containsIgnoreCase(teacherSurname, search) ||
                StringUtility.containsIgnoreCase(teacherAge, search) ||
                StringUtility.containsIgnoreCase(teacherSalary, search) ||
                StringUtility.containsIgnoreCase(teacherUniversity, search) ||
                StringUtility.containsIgnoreCase(teachersStudentName, search) ||
            StringUtility.containsIgnoreCase(teachersStudentSurname, search)){
                System.out.println(i+"."+teacher);
            }


        }
    }

    public void myMethod(int i){

    }
    public void myMethod(String str){

    }
}
