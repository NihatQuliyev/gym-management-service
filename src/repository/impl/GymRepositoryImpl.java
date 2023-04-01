package repository.impl;
import exception.NotFoundMemberException;
import model.Member;
import query.GymQuery;
import repository.GymRepository;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import static repository.DbConnection.connect;

public class GymRepositoryImpl implements GymRepository {
    @Override
    public boolean addMember(Member member) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GymQuery.ADD_MEMBER);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getSurname());
            preparedStatement.setString(3, member.getFin());
            preparedStatement.setString(4, member.getPasswordNumber());
            preparedStatement.setInt(5, member.getDepartures());
            preparedStatement.setInt(6, member.getAmount());
            preparedStatement.setDate(7, Date.valueOf(member.getExpirationDate()));
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Member> showMember() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GymQuery.SHOW_MEMBER);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.wasNull()) throw new NotFoundMemberException();
            List<Member> member = new LinkedList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String fin = resultSet.getString("fin");
                String passportNumber = resultSet.getString("passport_number");
                Integer departures = resultSet.getInt("departures");
                LocalDate registerDate = resultSet.getDate("register_date").toLocalDate();
                LocalDate updateDate = resultSet.getDate("update_date").toLocalDate();
                LocalDate expirationDate = resultSet.getDate("expiration_date").toLocalDate();
                Integer amount = resultSet.getInt("amount");
                member.add(new Member(name, surname, fin, passportNumber, departures, amount,  expirationDate , registerDate, updateDate));
            }
            return member;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean enterTheMember(String fin) {
        try(Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(GymQuery.ENTER_THE_GYM);
            preparedStatement.setString(1,fin);
            int count = preparedStatement.executeUpdate();
            return count > 0;

        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateDepartures(Integer departures,String fin) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GymQuery.UPDATE_DEPARTURES);
            preparedStatement.setInt(1, departures);
            preparedStatement.setString(2, fin);
            preparedStatement.setString(3, fin);
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteDepartures(String fin) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GymQuery.DELETE_DEPARTURES);
            preparedStatement.setString(1, fin);
            int count = preparedStatement.executeUpdate();
            return count > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


