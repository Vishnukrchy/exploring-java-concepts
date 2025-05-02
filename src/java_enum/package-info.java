package java_enum;
/***
 *
 * @author Vishnu Kumar
 * @version 1.0
 * @since 2025-05-02
 *
 * 🔥 What is enum in Java?
 * An enum (short for "enumeration") is a special Java type used to define a collection of constants.
 * Think of it as a cooler, safer alternative to a bunch of static final variables.
 *
 * public enum Status {
 *     ACTIVE,
 *     INACTIVE,
 *     PENDING
 * }
 *
 *
 * Now instead of dealing with "ACTIVE" or "PENDING" as Strings (which are error-prone), you can use Status.ACTIVE — type-safe and self-documenting.
 *
 *  Problems Solved by enum
 *  Avoids magic strings or numbers
 * ✅ Instead of "ACTIVE" or 1, you use a clean, type-safe Status.ACTIVE.
 *
 * Compile-time safety
 * ❌ This won’t compile: Status status = "ACTIVE";
 * ✅ Only valid enum values are allowed. No typos, no bugs.
 *
 * Readable switch-case
 * ✅ Cleaner than writing tons of if-else with string comparison.
 *
 * Can hold fields, methods, constructors
 * ✅ Not just constants — enums can have behavior too.
 *
 *❌ Without Enum (bug-prone)
 * public class UserStatus {
 *     public static final String ACTIVE = "ACTIVE";
 *     public static final String INACTIVE = "INACTIVE";
 * }
 *
 * String status = "ACITVE"; // typo - still compiles
 * if (status.equals(UserStatus.ACTIVE)) {
 *     // do something
 * }
 *✅ With Enum (clean & safe)
 * public enum Status {
 *     ACTIVE, INACTIVE, PENDING
 * }
 *
 * Status status = Status.ACTIVE;
 *
 * switch (status) {
 *     case ACTIVE -> System.out.println("User is active.");
 *     case INACTIVE -> System.out.println("User is inactive.");
 *     case PENDING -> System.out.println("User is pending.");
 * }
 *
 *
 *
 */