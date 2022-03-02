import java.util.Scanner;
 
public class tryJava {
    static void help(){
        System.out.println("MFA - PBO Test1");
        System.out.println("Random assortment of calculator-esque utilities.");
        System.out.println("");
        System.out.println("COMMANDS:");
        System.out.println("\tHELP \t\t\tDisplays this message");
        System.out.println("\tCURRENT \t\tShows the data's current state");
        System.out.println("\tADD [NUMBER] \t\tAdds a number to the data");
        System.out.println("\tSUBSTRACT [NUMBER] \tSubstract a number from the data");
        System.out.println("\tMULTIPLY [NUMBER] \tMultiplies the data a number times");
        System.out.println("\tDIVIDE [NUMBER] \tDivides the data a number times");
        System.out.println("\tROUND [CEIL/FLOOR] \tEither ceils or floors the data");
        System.out.println("\tCONVERT [DATA TYPE] \tConverts the data into another data types");
        System.out.println("\tEXIT \t\t\tExits the program");
    }
    
    static void current(int status, int i, long l, double d, float f) {
        switch(status) {
        case 1:
            System.out.println("An interger which is " + i);
            break;
        case 2:
            System.out.println("A Long which is " + l);
            break;
        case 3:
            System.out.println("A double which is " + d);
            break;
        case 4:
            System.out.println("A float which is " + f);
            break;
        default:
            System.out.println("Program Error -- wrong status");
            break;
        }
    }
 
    //  INTERGER ARITHMETICS
    static int add(String string, int a) {
        int b = Integer.parseInt(string);
        return a + b;
    }
    
    static int substract(String string, int a) {
        int b = Integer.parseInt(string);
        return a - b;
    }
    
    static int multiply(String string, int a) {
        int b = Integer.parseInt(string);
        return a * b;
    }
    
    static int divide(String string, int a) {
        int b = Integer.parseInt(string);
        return a / b;
    }
    
    //  LONG ARITHMETICS
    static long add(String string, long a) {
        long b = Long.parseLong(string);
        return a + b;
    }
    
    static long substract(String string, long a) {
        long b = Long.parseLong(string);
        return a - b;
    }
    
    static long multiply(String string, long a) {
        long b = Long.parseLong(string);
        return a * b;
    }
    
    static long divide(String string, long a) {
        long b = Long.parseLong(string);
        return a / b;
    }
    
    //  DOUBLE ARITHMETICS
    static double add(String string, double a) {
        double b = Double.parseDouble(string);
        return a + b;
    }
    
    static double substract(String string, double a) {
        double b = Double.parseDouble(string);
        return a - b;
    }
    
    static double multiply(String string, double a) {
        double b = Double.parseDouble(string);
        return a * b;
    }
    
    static double divide(String string, double a) {
        double b = Double.parseDouble(string);
        return a / b;
    }
    
    //  FLOAT ARITHMETICS
    static float add(String string, float a) {
        float b = Float.parseFloat(string);
        return a + b;
    }
    
    static float substract(String string, float a) {
        float b = Float.parseFloat(string);
        return a - b;
    }
    
    static float multiply(String string, float a) {
        float b = Float.parseFloat(string);
        return a * b;
    }
    
    static float divide(String string, float a) {
        float b = Float.parseFloat(string);
        return a / b;
    }
    
    // CONVERTER
    
    // COVERTERS
    static int convert(int status, long l, double d, float f) {
        int temp = -1;
        switch(status) {
        case 2:
            temp = (int)l;
            break;
        case 3:
            temp = (int)d;
            break;
        case 4:
            temp = (int)f;
            break;
        default:
            System.out.println("Program Error -- STATUS IS = " + status);
            break;
        }
        return temp;
    }
    
    static long convert(int status, int i, double d, float f) {
        long temp = -1;
        switch(status) {
        case 1:
            temp = (long)i;
            break;
        case 3:
            temp = (long)d;
            break;
        case 4:
            temp = (long)f;
            break;
        default:
            System.out.println("Program Error -- STATUS IS = " + status);
            break;
        }
        return temp;
    }
    
    
    static double convert(int status, int i, long l, float f) {
        double temp = -1.0;
        switch(status) {
        case 1:
            temp = (double)i;
            break;
        case 2:
            temp = (double)l;
            break;
        case 4:
            temp = (double)f;
            break;
        default:
            System.out.println("Program Error -- STATUS IS = " + status);
            break;
        }
        return temp;
    }
    
    static float convert(int status, int i, long l, double d) {
        float temp = -1.0f;
        
        switch(status) {
        case 1:
            temp = (float)i;
            break;
        case 2:
            temp = (float)l;
            break;
        case 3:
            temp = (float)d;
            break;
        default:
            System.out.println("Program Error -- STATUS IS = " + status);
            break;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int status = 1;
        String userInput = null;
        
        int integere = 0;
        long longe = 0;
        double doublee = 0.0;
        float floate = 0.0f;
        
        while(true){
            userInput = scanner.nextLine();
            if(userInput.matches("HELP") || userInput.matches("help"))
                help();
            else if(userInput.matches("CURRENT") || userInput.matches("current"))
                current(status,integere,longe,doublee,floate);
            else if(userInput.startsWith("ADD") || userInput.startsWith("add")) {
                userInput = userInput.replaceFirst("ADD ","");
                userInput = userInput.replaceFirst("add ","");
                switch(status){
                case 1:
                    integere = add(userInput,integere);
                    break;
                case 2:
                    longe = add(userInput,longe);
                    break;
                case 3:
                    doublee = add(userInput,doublee);
                    break;
                case 4:
                    floate = add(userInput,floate);
                    break;
                default:
                    System.out.println("Program Error -- STATUS IS = " + status);
                    break;
                }
            }
            else if(userInput.startsWith("SUBSTRACT") || userInput.startsWith("substract")) {
                userInput = userInput.replaceFirst("SUBSTRACT ","");
                userInput = userInput.replaceFirst("substract ","");
                switch(status){
                case 1:
                    integere = substract(userInput,integere);
                    break;
                case 2:
                    longe = substract(userInput,longe);
                    break;
                case 3:
                    doublee = substract(userInput,doublee);
                    break;
                case 4:
                    floate = substract(userInput,floate);
                    break;
                default:
                    System.out.println("Program Error -- STATUS IS = " + status);
                    break;
                }
            }
            else if(userInput.startsWith("MULTIPLY") || userInput.startsWith("multiply")) {
                userInput = userInput.replaceFirst("MULTIPLY ","");
                userInput = userInput.replaceFirst("multiply ","");
                switch(status){
                case 1:
                    integere = multiply(userInput,integere);
                    break;
                case 2:
                    longe = multiply(userInput,longe);
                    break;
                case 3:
                    doublee = multiply(userInput,doublee);
                    break;
                case 4:
                    floate = multiply(userInput,floate);
                    break;
                default:
                    System.out.println("Program Error -- STATUS IS = " + status);
                    break;
                }
            }
            else if(userInput.startsWith("DIVIDE")  || userInput.startsWith("divide")) {
                userInput = userInput.replaceFirst("DIVIDE ","");
                userInput = userInput.replaceFirst("divide ","");
                switch(status){
                case 1:
                    integere = divide(userInput,integere);
                    break;
                case 2:
                    longe = divide(userInput,longe);
                    break;
                case 3:
                    doublee = divide(userInput,doublee);
                    break;
                case 4:
                    floate = divide(userInput,floate);
                    break;
                default:
                    System.out.println("Program Error -- STATUS IS = " + status);
                    break;
                }
            }
            else if(userInput.startsWith("CONVERT")  || userInput.startsWith("convert")) {
                if(userInput.contains("INT")  || userInput.contains("int")) {
                    if(status == 1)
                        System.out.println("Coversion Cancelled. Your Current Data is already in this data type.");
                    else
                        integere = convert(status,longe,doublee,floate);
                    status = 1;
                }else if(userInput.contains("LONG")  || userInput.contains("long")) {
                    if(status == 2)
                        System.out.println("Coversion Cancelled. Your Current Data is already in this data type.");
                    else
                        longe = convert(status,integere,doublee,floate);
                    status = 2;
                }else if(userInput.contains("DOUBLE")  || userInput.contains("double")) {
                    if(status == 3)
                        System.out.println("Coversion Cancelled. Your Current Data is already in this data type.");
                    else
                        doublee = convert(status,integere,longe,floate);
                    status = 3;
                }else if(userInput.contains("FLOAT")  || userInput.contains("float")) {
                    if(status == 4)
                        System.out.println("Coversion Cancelled. Your Current Data is already in this data type.");
                    else
                        floate = convert(status,integere,longe,doublee);
                    status = 4;
                }else
                    System.out.println("Invalid Data Type, please try again");
            }
            else if(userInput.matches("EXIT") || userInput.matches("exit"))
                break;
            else
                System.out.println("Uknown / invalid commands, please try again Or type in 'HELP' for commands");
            System.out.println("");
        }
 
    }