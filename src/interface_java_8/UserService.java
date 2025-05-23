package interface_java_8;
/*
2. 🌀 Multiple Behavior Sharing (Like Traits / Mixins)
In languages like Scala or Kotlin, you can use traits or mixins to share method logic. Java didn’t have that… until now.
 */
interface Logger {
    default  void log(String msg) {
        System.out.println("Log: " + msg);
    }
}
interface  Auditor {
    default void audit(String action) {
        System.out.println("Audit: " + action);
    }
}


public class UserService implements Logger, Auditor {
    public void saveUser() {
        log("User saved");
        audit("User saved");
    }
}

/*
3. 🧠 Override Only If You Want
You get a default behavior — but you're free to customize it.
 */
interface AppConfig{
    default String getEnvironment() {
        return "Production";
    }
    default String getDatabaseUrl() {
        return "jdbc:mysql://localhost:3306/prod_db";
    }
    default String getDatabaseUsername() {
        return "root";
    }
}

class DevelopmentConfig implements AppConfig {
    @Override
    public String getEnvironment() {
        return "Development";
    }
    @Override
    public String getDatabaseUrl() {
        return "jdbc:mysql://localhost:3306/dev_db";
    }
}
