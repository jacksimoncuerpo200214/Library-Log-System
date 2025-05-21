package config;

public class SessionManager {

    private static SessionManager instance;
    private usersession userSession;

    private SessionManager() {
        userSession = usersession.getInstance();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(int id, String firstname, String lastname, String username, String email, String role,
                             String password, String status, String address, String image, String phone) {
        userSession.setId(id);
        userSession.setFirstname(firstname);
        userSession.setLastname(lastname);
        userSession.setUsername(username);
        userSession.setEmail(email);
        userSession.setRole(role);
        userSession.setPassword(password);
        userSession.setStatus(status);
        userSession.setAddress(address);
        userSession.setImage(image);
        userSession.setPhone(phone);
        userSession.setLoggedIn(true);
        userSession.setUserlogged(true);
    }

    public void endSession() {
        userSession.logout();
    }

    public boolean isSessionActive() {
        return userSession.isLoggedIn();
    }

    public usersession getUserSession() {
        return userSession;
    }
}
