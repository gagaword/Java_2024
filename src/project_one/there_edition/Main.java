package project_one.there_edition;


public class Main {
//    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println("--------学生信息管理系统--------");
        StudentManager studentManager = new StudentManager();
        UserInterface userInterface = new UserInterface(studentManager);

        int result = Integer.MAX_VALUE;
        final int EXIT = 0;
        while (result != EXIT) {
            result = userInterface.getUserInput();
            switch (result) {
                case 1:
                    userInterface.addStudent();
                    break;
                case 2:
                    userInterface.viewStudent();
                    break;
                case 3:
                    userInterface.editStudent();
                    break;
                case 4:
                    userInterface.delStudent();
                    break;
                case 0:
                    System.out.println("Good By");
                    userInterface.closeScanner();
                    break;
                default:
                    System.out.println("无效输入");
            }
        }
    }
}
