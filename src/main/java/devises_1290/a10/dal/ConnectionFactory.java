package devises_1290.a10.dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    Properties dbProps;

    private static final String DB_NAME = "tibmec_curate";
    private static final String DB_USER = "tibmec_cur_user";
    private static final String DB_PASSWORD = "b2b2025ratcur";
    private static final String DB_HOST = "mysql-tibmec.alwaysdata.net";
    private static final String DB_URL = "jdbc:mariadb://" + DB_HOST + ":3306/"+ DB_NAME;

    private Connection connection = null;
    private static ConnectionFactory instance = null;

    public static ConnectionFactory getInstance()
    {
        if (ConnectionFactory.instance == null)
            ConnectionFactory.instance = new ConnectionFactory();
        return ConnectionFactory.instance;
    }

    private ConnectionFactory() {
        try {
//            loadDBProperties();
//            this.DB_URL = "jdbc:mariadb://" +
//                    this.dbProps.getProperty("MariaDB.Server.HOST") + ":3306/"+
//                    this.dbProps.getProperty("MariaDB.Catalog.Initial");
//
//            this.connection = DriverManager.getConnection(DB_URL,
//                    this.dbProps.getProperty("MariaDB.Credentials.DB_USER"),
//                    this.dbProps.getProperty("MariaDB.Credentials.DB_PASSWORD"));
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDBProperties() {
        this.dbProps = new Properties();
        String filename = "src/main/resources/config.properties";
        try {
            FileInputStream fis = new FileInputStream(filename);
            this.dbProps.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
