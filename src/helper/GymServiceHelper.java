package helper;
import model.Member;
import java.time.LocalDate;
import static util.InputUtil.inputInteger;
import static util.InputUtil.inputString;
public class GymServiceHelper {
    public static Member fillAddMember(){
        try {
            String name = inputString("Enter the name: ");
            String surname = inputString("Enter the surname: ");
            String fin = inputString("Enter the fin: ");
            String passportNumber = inputString("Enter the passportNumber: ");
            Integer departures = inputInteger("Enter the departures: ");
            Integer amount = inputInteger("Enter the amount: ");
            LocalDate expirationDate = LocalDate.parse(inputString("Enter the expiration: "));
            return new Member(name, surname, fin, passportNumber, departures, amount, expirationDate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
