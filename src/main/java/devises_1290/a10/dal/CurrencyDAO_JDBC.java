package devises_1290.a10.dal;

import devises_1290.a10.model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDAO_JDBC implements ICurrency_DAO {
    Connection connection = null;

    public CurrencyDAO_JDBC() {
        this.connection = ConnectionFactory
                .getInstance()
                .getConnection();
    }

    @Override
    public Currency getCurrencyByName(String name) {
        Currency currencyFound = null;
        String query = SQL_BOX.FIND_CURRENCY_BY_NAME;
        try {
            PreparedStatement pStmt = this.connection.prepareStatement(query);
            pStmt.setString(1, name);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                currencyFound = new Currency(id,name,country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currencyFound;
    }

}
