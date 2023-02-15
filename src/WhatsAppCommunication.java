import java.util.HashSet;
import java.util.Set;

public class WhatsAppCommunication implements CommunicationService{
    private static Set<User> subs = new HashSet<>();
    @Override
    public void communication(User user) {

    }

    @Override
    public void subscribe(User user) {
        subs.add(user);
        user.addCommService("WhatsApp",this);
    }

    @Override
    public void unSubscribe(User user) {
        subs.remove(user);
        user.removeCommService("WhatsApp");
    }

    @Override
    public boolean SendMessage(User user1, User user2, String message) {
        if (subs.contains(user2)){
            user2.ReceiveMessage(user1,message,"WhatsApp");
            return true;
        }
        return false;
    }
}
