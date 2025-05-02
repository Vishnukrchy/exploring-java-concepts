package java_enum;


/**
 *  Example Use Case — Without and With Enum
 */
public class UserStatus {
    public static final String ACTIVE = "ACTIVE";
    public static final String INACTIVE = "INACTIVE";

    public static void main(String[] args) {
        String classic_status = "ACITVE"; // typo - still compiles
        if (classic_status.equals(UserStatus.ACTIVE)) {
            System.out.println("status is Active");
        }else {
            System.out.println("status is Inactive");
        }

        // ✅ Using Enum

        Status enumstatus = Status.ACTIVE;
        System.out.println(enumstatus);
        switch (enumstatus) {
            case ACTIVE -> System.out.println("User is active.");
            case INACTIVE -> System.out.println("User is inactive.");
            case PENDING -> System.out.println("User is pending.");

        }
    }
}
/**
 * ✅ With Enum (clean & safe)
 */
enum Status {
    ACTIVE, INACTIVE, PENDING
}







