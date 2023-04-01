package repository;
import model.Member;
import java.util.List;
public interface GymRepository {
    boolean addMember(Member member) ;
    List<Member> showMember();
    boolean enterTheMember(String fin);
    boolean updateDepartures(Integer departures,String fin);
    boolean deleteDepartures(String fin);
}
