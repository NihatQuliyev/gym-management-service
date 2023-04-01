import service.GymManagementSystem;
import service.impl.GymManagementSystemImpl;

public class Main {
    public static void main(String[] args) {
        GymManagementSystem gymManagementSystem = new  GymManagementSystemImpl();
        gymManagementSystem.management();
    }
}