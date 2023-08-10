package helper_hw;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.LoggerTest;
import utils.configuration.ReadProperties;

public class DataHelper {
    static Logger logger = LogManager.getLogger(DataHelper.class);

    public static User getUser() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        logger.info(user.toString());
        return user;
    }
}
