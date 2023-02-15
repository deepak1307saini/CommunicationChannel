import java.util.HashMap;
import java.util.Map;

public class User {
    //All final attributes

    private final String name; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private Map<String, CommunicationService> CommServices;

    User(UserBuilder builder) {
       this.name=builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
        CommServices=new HashMap<>();
    }


    public String name() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
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
