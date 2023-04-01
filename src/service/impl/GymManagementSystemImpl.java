package service.impl;
import exception.FinAlreadyExists;
import exception.InvalidOptionException;
import exception.NotFoundFin;
import exception.NotFoundMemberException;
import service.GymManagementSystem;
import java.util.InputMismatchException;
import static util.MenuUtil.entry;
public class GymManagementSystemImpl implements GymManagementSystem {
    @Override
    public void management()  {
        GymServiceImpl gymService = new GymServiceImpl();
        while (true) {
            try {
                int option = entry();
                switch (option) {
                    case 0 -> System.exit(-1);
                    case 1 -> gymService.addMember();
                    case 2 -> gymService.showMember();
                    case 3 -> gymService.enterTheGym();
                    case 4 -> gymService.updateDepartures();
                    case 5 -> gymService.deleteDepartures();
                    default -> throw new InvalidOptionException();
                }
            }
            catch (InputMismatchException | InvalidOptionException | NotFoundMemberException | NotFoundFin |
                   FinAlreadyExists |NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
