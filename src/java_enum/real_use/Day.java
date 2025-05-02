package java_enum.real_use;

public enum Day {

    MONDAY("Mon", false),
    TUESDAY("Tue", false),
    WEDNESDAY("Wed", false),
    THURSDAY("Thu", false),
    FRIDAY ("Fri",false),
    SATURDAY("Sat", true),
    SUNDAY("Sun", true);
    private final String shortName;
    private final boolean isWeekend;

    // Constructor for each enum constant
    Day(String shortName, boolean isWeekend) {
        this.shortName = shortName;
        this.isWeekend = isWeekend;
    }
    public String getShortName() {
        return shortName;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
 class EnumTest1 {
    public static void main(String[] args) {
        Day []days = Day.values();
        for (Day day : days) {
            System.out.println(day.name() + " (" + day.getShortName() + ") - Weekend? " + day.isWeekend()+""+day.ordinal());
        }
    }
}

