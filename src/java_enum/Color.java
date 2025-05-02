package java_enum;
// enum can be declared outside any class (Note enum keyword instead of
// class keyword)
//Enum declaration can be done outside a class or inside a class but not inside a method.
//1. Declaration outside the class
public enum Color {
    RED, GREEN, BLUE
}
class  Test {
    public static void main(String[] args) {
        Color c = Color.BLUE;
        System.out.println(c);// BLUE

        // 2. Loop through Enum
        //We can iterate over the Enum using the values() method, which returns an array of enum constants.

        Color[] colors = Color.values();
        for (Color color : colors) {
            System.out.println(color);
        }// BLUE GREEN RED


        //3. Enum in a Switch Statement
        Color var_1 = Color.RED;

        // Switch case with Enum
        switch (var_1) {
            case RED:
                System.out.println("Red color observed");
                break;
            case GREEN:
                System.out.println("Green color observed");
                break;
            case BLUE:
                System.out.println("Blue color observed");
                break;
            default:
                System.out.println("Other color observed");
        }

    }


}





