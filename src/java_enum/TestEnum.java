package java_enum;

public class TestEnum {
    Day day;

    TestEnum(Day day){
        this.day = day;
    }
    public static void main(String[] args) {
        String str="MONDAY";
        Day day = Day.valueOf(str);
        TestEnum test = new TestEnum(day);
        System.out.println(test.dayIsLike());//All Day is MONDAY Monday

        new TestEnum(Day.WEDNESDAY).dayIsLike();//

    }
    public String dayIsLike() {
        System.out.println(" Day is "+day);
      String result =  switch (day){
            case MONDAY-> "Monday";
            case TUESDAY-> "Tuesday";
            case WEDNESDAY-> "Wednesday";
            case THURSDAY-> "Thursday";
            case FRIDAY-> "Friday";
            case SATURDAY-> "Saturday";
            case SUNDAY-> "Sunday";

        };
        return result;
    }
}
