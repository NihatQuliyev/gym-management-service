package service.impl;
import exception.FinAlreadyExists;
import exception.NotFoundFin;
import model.Member;
import repository.GymRepository;
import repository.impl.GymRepositoryImpl;
import service.GymService;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import static helper.GymServiceHelper.fillAddMember;
import static util.InputUtil.inputInteger;
import static util.InputUtil.inputString;
public class GymServiceImpl implements GymService {
    public  final GymRepository gymRepository;
    public GymServiceImpl(){
        gymRepository = new GymRepositoryImpl();
    }
    @Override
    public void addMember() {
        Member member1 = fillAddMember();
        List<Member> members = gymRepository.showMember();

        boolean isTrue = members.stream()
                .anyMatch(member -> member.getFin().equals(member1.getFin()));

        if (!isTrue) {
            gymRepository.addMember(member1);
            System.out.println("Register successfully!");
        } else {
            throw new FinAlreadyExists();
        }
    }
        @Override
    public void showMember() {
       List<Member> members =  gymRepository.showMember();
       members
               .forEach(System.out::println);
    }
    @Override
    public void enterTheGym() {
        String fin = inputString("Enter the fin: ");
        AtomicBoolean isTrue = new AtomicBoolean(false);
        gymRepository.enterTheMember(fin);
        gymRepository.showMember().stream()
                .filter(member -> {
                    isTrue.set(member.getFin().equals(fin));
                    return isTrue.get();
                })
                .peek(member -> {
                    if (member.getDepartures() == 0) {
                        System.out.println("Rejected");
                    } else {
                        System.out.println("departures: " + member.getDepartures());
                    }
                })
                .findFirst();
        if (!isTrue.get()){
            throw new NotFoundFin();
        }
    }
    @Override
    public void updateDepartures() {
        String fin = inputString("Enter the fin: ");
        Integer departures = inputInteger("Enter the departures: ");
        AtomicBoolean isTrue = new AtomicBoolean(false);
        gymRepository.updateDepartures(departures,fin);
        gymRepository.showMember().stream()
                .filter(member -> {
                    isTrue.set(member.getFin().equals(fin));
                    return isTrue.get();
                })
                .forEach(member -> System.out.println(member.getName() + " " + member.getSurname() + " Successfully Update"));
        if (!isTrue.get()) {
            throw new NotFoundFin();
        }
    }
    public void deleteDepartures(){
        String fin = inputString("Enter the fin: ");
        AtomicBoolean isTrue = new AtomicBoolean(false);
        gymRepository.showMember().stream()
                .filter(member -> {
                    isTrue.set(member.getFin().equals(fin));
                    return isTrue.get();
                })
                .forEach(member -> System.out.println(member.getName() + " " + member.getSurname() + " Delete"));
        if (!isTrue.get()) {
            throw new NotFoundFin();
        }else {
            gymRepository.deleteDepartures(fin);
        }
    }
}
