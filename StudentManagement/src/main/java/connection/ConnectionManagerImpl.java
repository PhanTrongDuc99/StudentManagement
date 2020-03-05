/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author USER
 */
public class ConnectionManagerImpl implements ConnectionManager {

    private ConfigurationProviderImpl provider;

    public ConnectionManagerImpl() {
        provider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {
        Properties properties = provider.getProperties();
        Connection conn = null;
        try {
            Class.forName(properties.getProperty("driverClass"));
            conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
