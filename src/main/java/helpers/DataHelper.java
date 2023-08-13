package helpers;


import models.User;
import models.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.configuration.ReadProperties;

public class DataHelper {
    static Logger logger = LogManager.getLogger(DataHelper.class);

    public static UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("Maksym");
        userInfo.setLastName("Sudarikov");
        userInfo.setZipCode("12345");

        logger.info(userInfo.toString());
        return userInfo;
    }

    public static User getUserCredentials() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        logger.info(user.toString());
        return user;


    }
}
