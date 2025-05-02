package java_enum;
// constructor and concrete methods.
 enum Color1{
    RED,GREEN,BLUE;
    // Enum constructor called separately for each
    // constant
    // ordinal() returns the index of the constant
    Color1(){
        System.out.println("Constructor called for "+this.name() +" "+this.ordinal());
    }
    public void colorInfo() {
        System.out.println("Universal Color");
    }

}

public class EnumAndMethods {
    public static void main(String[] args) {
        Color1 color = Color1.BLUE;
        System.out.println(color);
        color.colorInfo();
        /*
Constructor called for RED 0
Constructor called for GREEN 1
Constructor called for BLUE 2
BLUE
Universal Color
         */
    }

}
