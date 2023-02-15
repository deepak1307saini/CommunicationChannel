import java.util.HashMap;
import java.util.Map;

public class User {
    private String name; // required

    private Map<String, CommunicationService> CommServices;

    User(String name) {
        this.name=name;
        CommServices=new HashMap<>();
    }


    public void addCommService(String serviceName, CommunicationService commChanel){

            CommServices.put(serviceName,commChanel);
    }

    public void removeCommService(String service){
        CommServices.remove(service);
    }

    public void SendMessage(User user,String message){
        boolean flag=false;

            for (String channel:CommServices.keySet()) {
                if (CommServices.get(channel).SendMessage(this,user,message)){
                    flag=true;
                    break;
                }
            }

        if(!flag){
            System.out.println(user.name+" not having any communication service");
        }
    }

    public void ReceiveMessage(User user,String message,String serviceName){
        System.out.println("Hi "+this.name+" you received a "+serviceName+ " from "+user.name+" ->");
        System.out.println("                                                     "+message);
    }

}
