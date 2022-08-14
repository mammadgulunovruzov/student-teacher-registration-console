public class Main {


    public static void main(String[] args) {

        while (true) {
            int menu = InputUtility.askInt("Enter a person:\n" +
                    "(1) for Teacher \n" +
                    "(2) for Student \n" +
                    "(3) for Exit");

            ManagementService service = null;
            if (menu == 1) {
                service = new TeacherService();
            } else if (menu == 2) {
                service = new StudentService();
            } else if (menu == 3) {
                System.exit(0);
            } else {
                System.out.println("Wrong operation");
            }

            if (menu == 1 || menu == 2) {
                service.process();
            }
        }


    }


}