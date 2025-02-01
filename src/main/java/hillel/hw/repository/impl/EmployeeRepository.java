package hillel.hw.repository.impl;

import hillel.hw.database.DBConn;
import hillel.hw.entity.Employee;
import hillel.hw.repository.AppRepository;
import hillel.hw.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements AppRepository<Employee> {
    private final static String TABLE_EMPLOYEES = "employees";

    @Override
    public String create(Employee employee) {
        String sql = "INSERT INTO " + TABLE_EMPLOYEES +
                " (name, age, position, salary) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getAge());
            pstmt.setString(3, employee.getPosition());
            pstmt.setString(4, employee.getSalary());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {

            return e.getMessage();
        }
    }

    @Override
    public Optional<List<Employee>> read() {
        try (Statement stmt = DBConn.connect().createStatement()) {
            List<Employee> list = new ArrayList<>();
            // SQL-запит
            String sql = "SELECT id, name, age, position, salary FROM "
                    + TABLE_EMPLOYEES;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Employee(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("age"),
                                rs.getString("position"),
                                rs.getString("salary")
                        )
                );
            }
            return Optional.of(list);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public String update(Employee employee) {
        if (readById(employee.getId()).isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            String sql = "UPDATE " + TABLE_EMPLOYEES +
                    " SET name = ?, age = ?, position = ?, salary = ?" +
                    " WHERE id = ?";
            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
                pst.setString(1, employee.getName());
                pst.setString(2, employee.getAge());
                pst.setString(3, employee.getPosition());
                pst.setString(4, employee.getSalary());
                pst.setLong(5, employee.getId());
                pst.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        }
    }

    @Override
    public String delete(Long id) {
        if (!isIdExists(id)) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            String sql = "DELETE FROM " + TABLE_EMPLOYEES +
                    " WHERE id = ?";
            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
                pst.setLong(1, id);
                pst.executeUpdate();
                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        }
    }

    @Override
    public Optional<Employee> readById(Long id) {
        String sql = "SELECT id, name, age, position, salary FROM "
                + TABLE_EMPLOYEES + " WHERE id = ?";
        try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Employee employee = new Employee(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("age"),
                    rs.getString("position"),
                    rs.getString("salary")
            );
            return Optional.of(employee);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    private boolean isIdExists(Long id) {
        String sql = "SELECT COUNT(id) FROM " + TABLE_EMPLOYEES +
                " WHERE id = ?";
        try {
            PreparedStatement pst = DBConn.connect().prepareStatement(sql);
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }
}