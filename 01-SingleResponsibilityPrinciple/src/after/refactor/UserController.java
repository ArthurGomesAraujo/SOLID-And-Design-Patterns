package after.refactor;

import mocked.utils.ObjectMapper;
import mocked.utils.User;

import java.io.IOException;

public class UserController {

    private UserPersistenceService persistenceService = new UserPersistenceService();

    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(userJson, User.class);
        UserValidator validator = new UserValidator();

        boolean isValid = validator.isValidUser(user);

        if(!isValid) {
            return "ERROR";
        }

        persistenceService.saveUser(user);

        return "SUCCESS";
    }

}
