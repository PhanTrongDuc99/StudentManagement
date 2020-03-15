/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author USER
 */
public class ConfigurationProviderImpl implements ConfigurationProvider {

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        File file = new File("config.properties");
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Properties Exception");
        }
        return properties;
    }

}
