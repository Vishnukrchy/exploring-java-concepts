package File_Handling;


import java.io.*;

/*
    * @author Vishnu Kumar
    * @version 1.0
    * @since 2025-06-15
    * * Serialization in Java is the process of converting an object into a byte stream, which can then be saved to a file or transmitted over a network.
    * It allows you to persist the state of an object and later reconstruct it.
    * * Why is Serialization important?
    * Serialization is important in Java for several reasons:
    * 1. Persistence: It allows you to save the state of an object to a file or database, enabling data persistence across program executions.
    * 2. Communication: It enables the transmission of objects over a network, allowing remote method invocation (RMI) and distributed computing.
    * 3. Caching: Serialized objects can be cached for faster access in future operations.
    * * How to use Serialization in Java?
    * To use serialization in Java, you need to implement the `Serializable` interface in the class whose objects you want to serialize. The `Serializable` interface is a marker interface, meaning it does not contain any methods. Once a class implements this interface, you can use `ObjectOutputStream` to write the object to a file and `ObjectInputStream` to read it back.
    * * Example:
    * Here is a simple example of serialization in Java:
 */
//public class S1_Serialization {
//    public static void main(String[] args) {
//        // Create an object to be serialized
//        Employee employee = new Employee("John Doe", 30, "Software Engineer");
//
//        // Serialize the object to a file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
//            oos.writeObject(employee);
//            System.out.println("Employee object serialized successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Deserialize the object from the file
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
//            Employee deserializedEmployee = (Employee) ois.readObject();
//            System.out.println("Deserialized Employee: " + deserializedEmployee);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
