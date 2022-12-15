/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

/**
 *
 * @author deece
 */
public class CrossCA {

    /**
     * @param args the command line arguments
     */
<<<<<<< Updated upstream
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Heelloo");
=======
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        Admin admin = new Admin();
        admin.createAdmin();
        DBWriter dataOutput = new DBWriter();
<<<<<<< Updated upstream
        dataOutput.outputSetup();/////
=======
//        dataOutput.outputSetup();
>>>>>>> Stashed changes

        System.out.println("------MIRAE & TUMURTULGA------------");
        System.out.println("------LINEAR ALGEBRA----------------");
        System.out.println("------DATABASE: APPROACHES & SYSTEM-");
        System.out.println("------OBJECT-ORIENTED CONCEPTS------");
        System.out.println();

        boolean quit = false;

        while (!quit) {
            try {
                Scanner sc = new Scanner(System.in);
                mainMenu();
                int input = sc.nextInt();

                switch (input) {
                    case 1:
                        
                    menuAdmin();
//                        TwoVariables tv1 = new TwoVariables();
//                        SolveTwoVariables(tv1);
                        break;

//                    System.out.println("LOGIN AS AN ADMIN");
//                    menuAdmin();
                    case 2:
                        menuUser();
//                        ThreeVariables tv2 = new ThreeVariables();
//                        SolveThreeVariables(tv2);
//                    System.out.println("LOGIN AS AN USER");
//                    menuUser();
                        break;
                    case 3:
//                    System.out.println("SIGN-UP");
                        createUser();
                        break;
                    case 4:
//                    System.out.println("EXIT");1
                        quit = true;
                        sc.close();
                        break;
                    default:
                        System.out.println("WRONG INPUT, TRY AGAIN");
                        break;
                }
                System.out.println();

            } catch (InputMismatchException ex) {
                System.out.println("Bad Input!!! Must be an integer");
            }
        }

//        DBWriter dataOutput = new DBWriter();
//        System.out.println(dataOutput.outputSetup());
//        /*
//            * Simultaneous Equations with 2 unknowns
//         */
//        char[] operator = new char[]{'+', '+'};
//        int[] result2D;
//        int[] x_coeff = new int[]{2, 3};
//        int[] y_coeff = new int[]{-3, 8};
//        int[] equals = new int[]{2, 3};
//
//        if (y_coeff[0] < 0) {
//            operator[0] = '-';
//        }
//        if (y_coeff[1] < 0) {
//            operator[1] = '-';
//        }
//
//        System.out.println("Solving simultaneously the equations with 2 variables:");
//        //Print as an equation
//        System.out.printf("%40dx %s %dy = %d%n", x_coeff[0], operator[0], Math.abs(y_coeff[0]), equals[0]);
//        System.out.printf("%40dx %s %dy = %d%n", x_coeff[1], operator[1], Math.abs(y_coeff[1]), equals[1]);
//        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y)  =  ");
//
//        try {
//            TwoVariables sim2unk;
//            sim2unk = new TwoVariables(x_coeff, y_coeff, equals);
//            result2D = sim2unk.solveSimultaneous();
//
//            System.out.printf("%d", result2D[0], result2D[1]);
//        } catch (ArithmeticException e) {
//            System.out.printf("(%s, %s)%n", "?", "?");
//        }
//
//        System.out.println("\n\n");
//
//        /*
//        * Simultaneous Equations with 3 unknowns
//         */
//        int[] x_coefff;
//        int[] y_coefff;
//        int[] z_coefff;
//        int[] equalss;
//
//        char[][] operators = new char[3][2];
//        for (char[] op : operators) {
//            Arrays.fill(op, '+');
//        }
//
//        int[] result3D;
//        x_coefff = new int[]{1, 2, 1};
//        y_coefff = new int[]{1, 3, -5};
//        z_coefff = new int[]{1, 5, 6};
//        equalss = new int[]{2, 11, -29};
//
//        for (int i = 0; i < 3; i++) {
//            if (y_coefff[i] < 0) {
//                operators[i][0] = '-';
//            }
//            if (z_coefff[i] < 0) {
//                operators[i][1] = '-';
//            }
//        }
//
//        System.out.println("Solving simultaneously the equations with 3 variables:");
//        //Print as an equation
//        System.out.printf(
//                "%40dx %s %dy %s %dz = %d%n", x_coefff[0], operators[0][0],
//                Math.abs(y_coefff[0]), operators[0][1], Math.abs(z_coefff[0]), equalss[0]
//        );
//        System.out.printf(
//                "%40dx %s %dy %s %dz = %d%n", x_coefff[1], operators[1][0],
//                Math.abs(y_coefff[1]), operators[1][1], Math.abs(z_coefff[1]), equalss[1]
//        );
//        System.out.printf(
//                "%40dx %s %dy %s %dz = %d%n", x_coefff[2], operators[2][0],
//                Math.abs(y_coefff[2]), operators[2][1], Math.abs(z_coefff[2]), equalss[2]
//        );
//        System.out.printf("%n%30s%n%40s", "Answer:", "(x, y, z)  =  ");
//
//        try {
//            ThreeVariables sim3unk;
//            sim3unk = new ThreeVariables(x_coefff, y_coefff, z_coefff, equalss);
//            result3D = sim3unk.solveSimultaneous();
//
//            System.out.printf("%d", result3D[0], result3D[1], result3D[2]);
//
//        } catch (ArithmeticException e) {
//            System.out.printf("(%s, %s, %s)%n", "?", "?", "?");
//        }
//        System.out.println();
//
//    }
        }

    

    private static void mainMenu() {

        System.out.println("-------------------------");
        System.out.println("------MAIN MENU----------");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1. LOGIN AS AN ADMIN");
        System.out.println("2. LOGIN AS AN USER");
        System.out.println("3. SIGN-UP");
        System.out.println("4. EXIT");
        System.out.println("Your choice: ");
    }

    private static void menuAdmin() {
        System.out.println("-------------------------");
        System.out.println("------LOGIN AS AN ADMIN--");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1. CREATE USER");
        System.out.println("2. MODIFY USER");
        System.out.println("3. ACCESS USER LIST");
        System.out.println("4. REMOVE USER");
        System.out.println("5. LOG-OUT");
        System.out.println("Your choice: ");

>>>>>>> Stashed changes
    }
    
}
