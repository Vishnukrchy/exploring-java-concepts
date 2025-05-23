package interface_java_8;
/*
💡 Why Default Methods Exist in Java 8+
1. ✅ Backward Compatibility
Let’s say you already have millions of lines of code using an interface.
if we  want to add a new method to the interface, but you don’t want to break the existing code.
Then you can use the default keyword to add the new method to the interface in Java 8.
 */
public interface NotificationService {
    void sendNotification(String message);
    /* Now if want to add a new method to send emails:
    void sendEmail(String email);
    Before Java 8, this would break every class that implements this interface because they’d be forced to implement the new method

    Solution? Add a Default Method:
     */
  //void  sendEmail(String email);// throw error in implementation class to implement this method

    default void sendEmail(String email){
        System.out.println("Sending Email: " + email);
    }
    //Now existing classes don’t break, and new ones can override if they want!
}
class EmailService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Notification: " + message);
    }
}

