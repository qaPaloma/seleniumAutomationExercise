package support;

import org.apache.commons.lang3.RandomStringUtils;
import runner.RunCucumberTest;
import java.util.Random;

public class UserDataUtils extends RunCucumberTest {

    //Methods created to generate random data for forms

    /*---------*/
    public static String getRandomNumber(int numberOfDigits){
        return RandomStringUtils.randomNumeric(numberOfDigits);
    }

    public static int getRandomNumber(int minValue, int maxValue){
        Random random = new Random();

        return random.nextInt(maxValue - minValue) + minValue;
    }

    /*---------*/
    public static class getRandomName {
        private static Random random = new Random();
        private static String[] firstName = { "Amelia", "Olivia", "Emily", "Ava", "Sophie",
                "Mia", "Ruby", "Lily", "Grace", "Freya", "Charlotte", "Daisy", "Phoebe", "Millie",
                "Eva", "Alice", "Lucy", "Florence", "Lola"};

        private static String[] lastName = { " Smith", " Johnson", " Williams", " Brown", " Jones", " Garcia",
                " Miller", " Davis", " Rodriguez", " Martinez", " Hernandez", " Lopez" };

        public static String firstName() {
            return firstName[random.nextInt(firstName.length)];
        }

        public static String lastName() {
            return lastName[random.nextInt(lastName.length)];
        }

    }

    /*---------*/
    public static String getRandomEmail(){
        String emailStart = "test+";
        String emailEnd = "@test.com";
        int number = getRandomNumber(1,9999999);

        return emailStart + number + emailEnd;
    }

    /*---------*/
    public static String getRandomPassword(){

        String uppercase = RandomStringUtils.randomAlphabetic(2);
        String lowercase = RandomStringUtils.randomAlphabetic(2).toLowerCase();
        String number = getRandomNumber(2);

        return uppercase + lowercase + number;
    }

}
