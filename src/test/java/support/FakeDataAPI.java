package support;

import com.github.javafaker.Faker;
import runner.RunCucumberTest;

public class FakeDataAPI extends RunCucumberTest {


    public static Faker api (){
        return new Faker();
    }

    public static String getFirstName (){
        String name = api().name().firstName();
        System.out.println("THE GENERATED FIRST NAME WAS " + name);
        return name;
    }

    public static String getLastName (){
        String name = api().name().lastName();
        System.out.println("THE GENERATED LAST NAME WAS " + name);
        return name;
    }

    public static String getEmail (){
        String email = api().internet().emailAddress();
        System.out.println(email);
        return email;
    }

    public static String getPassword (){
        String password = api().internet().password();
        System.out.println(password);
        return password;
    }

    public static String getCompanyName (){
        return api().company().name();
    }
    public static String getAddress (){
        return api().address().streetAddress();
    }
    public static String getState (){
        return api().address().state();
    }
    public static String getCity (){
        return api().address().city();
    }

    public static String getZipCode (){
        return api().address().zipCode();
    }
    public static String getPhoneNumber (){
        return api().phoneNumber().cellPhone();
    }

}
