package query;

public class GymQuery {
    public static String ADD_MEMBER = "INSERT INTO row_info(update_date, register_date, status) VALUES  (now(),now(),1);\n" +
            "INSERT INTO gym(NAME, SURNAME, FIN, PASSPORT_NUMBER, DEPARTURES,AMOUNT, EXPIRATION_DATE,row_info_id) VALUES (?,?,?,?,?,?,?,(Select id from row_info order by id desc limit 1 ));";

    public static String SHOW_MEMBER = "SELECT name,surname,fin,passport_number ,departures,amount,expiration_date, register_date ,update_date from gym gy\n" +
            "INNER JOIN public.row_info ri on ri.id = gy.row_info_id where status =1;";

    public static String ENTER_THE_GYM = "UPDATE gym SET departures = departures - 1 WHERE fin = ? and departures > 0 ";

    public static String UPDATE_DEPARTURES = "UPDATE gym SET departures = departures + ? where fin  = ?;\n" +
            "UPDATE  row_info SET update_date = now() where id = (Select row_info_id from gym where fin=?) ";

    public static String DELETE_DEPARTURES = "UPDATE row_info SET status = 0 WHERE ID= (SELECT row_info_id FROM gym WHERE fin = ?)";
}
