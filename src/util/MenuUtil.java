package util;

import static util.InputUtil.inputInteger;

public class MenuUtil {
    public static int entry() {
        System.out.println("\n------ Gym Management Service ------\n" +
                "\n[0] Exit System" +
                "\n[1] Register gym member" +
                "\n[2] Show gym member" +
                "\n[3] Enter the gym" +
                "\n[4] Update departure"+
                "\n[5] Delete departure"

        );
        return inputInteger("Choose option: ");
    }
}
