

import java.util.logging.Level;
import java.util.logging.Logger;

    class IllegalException extends Exception{
        @Override 
        public String getMessage() {
            return "u need to be above age 18 to register for voting";
        }
    }
    class VotingRegistration{
        void register(int age) throws IllegalException{
            if(age<18){
                throw new IllegalException();
            }
        }
    }
    public class CustomException {
        public static void main(String []args){
            Logger logger = Logger.getLogger(CustomException.class.getName());
            try {
                new VotingRegistration().register(16);
            } catch (IllegalException e) {
                e.printStackTrace(); // e holds the reference of the throw IllegalException in the register method
            }
            logger.log(Level.INFO,"end");
        }
    }


