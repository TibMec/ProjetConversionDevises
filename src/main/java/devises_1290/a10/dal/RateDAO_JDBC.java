package devises_1290.a10.dal;

import devises_1290.a10.model.Currency;
import devises_1290.a10.model.Rate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RateDAO_JDBC implements IRate_DAO {
    Connection connection = null;

    public RateDAO_JDBC() {
        this.connection = ConnectionFactory
                .getInstance()
                .getConnection();
    }

    @Override
    public boolean addRate(Rate rate) {
        String query = SQL_BOX.ADD_RATE;
        try {
            PreparedStatement pStmt = this.connection.prepareStatement(query);
            pStmt.setInt(1, rate.getId());
            pStmt.setDouble(1, rate.getValue());
            int affectedRows = pStmt.executeUpdate();
            if (affectedRows == 1)
                return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        Rate rateFound = null;
        String query = SQL_BOX.FIND_RATE_BY_CURRENCY_NAME;
        try {
            PreparedStatement pStmt = this.connection.prepareStatement(query);
            pStmt.setString(1, name);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                double value = rs.getDouble("value");
                rateFound = new Rate(id, value);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rateFound;
    }

}
