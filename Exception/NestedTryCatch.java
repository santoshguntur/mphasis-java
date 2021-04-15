
import sun.util.logging.PlatformLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NestedTryCatch {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(NestedTryCatch.class.getName());
        try {
            System.out.println(2 / 1);
            try {
                System.out.println(Integer.parseInt("23a"));
            } catch (ArithmeticException e) {
                logger.log(Level.SEVERE, "divide by zero");
            }
            Class.forName("java.util.Dat");
            System.out.println("end of try");
        } catch (ArithmeticException ae) {
            logger.log(Level.SEVERE, "divide by zero");
        } catch (NumberFormatException ne) {
            //logger.log(Level.SEVERE, "please provide a valid number");
            logger.log(Level.INFO,"new msg");
            logger.log(Level.SEVERE, "logging:",
                    new RuntimeException("Error"));

        }
        catch(ClassNotFoundException ce){
            logger.log(Level.SEVERE, "could not locate class");

        }
        System.out.println("end");
    }
}

