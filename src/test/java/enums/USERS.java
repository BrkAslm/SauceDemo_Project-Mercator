package enums;

public enum USERS {
    STANDARD("standard_user","secret_sauce"),
    LOCKEDOUT("locked_out_user","secret_sauce"),
    PROBLEM("problem_user","secret_sauce"),
    PERFORMANCE("performance_glitch_user","secret_sauce"),
    ;

    private final String username;

    private final String password;

    USERS(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
