package java_enum;
// Creating a Class with Enum Member
public class EnumTest {
    Day day;
    EnumTest(Day day){
        this.day=day;
    }
    // method to execute action as per enum value
    public void doAction(){
        switch (day){
            case MONDAY ->  System.out.println("Mondays are tough");
            case TUESDAY -> System.out.println("Tuesday are better");
            case WEDNESDAY ->System.out.println("Wednesday are okay");
            case THURSDAY -> System.out.println("Thursdays are hopeful");
            case FRIDAY -> System.out.println("Fridays are exciting");
            case SATURDAY -> System.out.println("Saturdays are relaxing");
            case SUNDAY -> System.out.println("Sunday are for rest");

            default -> System.out.println("Invalid day");
        }
    }

    public static void main(String[] args) {
        EnumTest test = new EnumTest(Day.MONDAY);
        test.doAction();

        EnumTest test1 = new EnumTest(Day.TUESDAY);
        test1.doAction();

        EnumTest test2 = new EnumTest(Day.WEDNESDAY);
        test2.doAction();

        EnumTest test3 = new EnumTest(Day.THURSDAY);
        test3.doAction();

        EnumTest test4 = new EnumTest(Day.FRIDAY);
        test4.doAction();

        EnumTest test5 = new EnumTest(Day.SATURDAY);
        test5.doAction();

        EnumTest test6 = new EnumTest(Day.SUNDAY);
        test6.doAction();

    }

    /***
     * Mondays are tough
     * Tuesday are better
     * Wednesday are okay
     * Thursdays are hopeful
     * Fridays are exciting
     * Saturdays are relaxing
     * Sunday are for rest
     */

}
