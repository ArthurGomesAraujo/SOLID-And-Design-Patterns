package after.refactor;

import mocked.utils.Store;
import mocked.utils.User;

public class UserPersistenceService {

    //Store used by controller
    private Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
}
