package controller;

import common.exception.FailLoginException;
import entity.db.AIMSDB;
import entity.user.User;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;

public class AuthenticationController extends BaseController {

    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    public void login(String email, String password) throws Exception {
//        LOGGER.info(email);
//        LOGGER.info(Utils.md5(password));
        try {
            User user = new User().authenticate(email, Utils.md5(password));
            // Log user details
            if (Objects.isNull(user)) throw new FailLoginException();
//            SessionInformation.mainUser = user;
//            SessionInformation.expiredTime = LocalDateTime.now().plusHours(24);
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }


//    public void logout() {
//        SessionInformation.mainUser = null;
//        SessionInformation.expiredTime = null;
//    }

}
