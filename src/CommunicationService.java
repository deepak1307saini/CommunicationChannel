public interface CommunicationService {

    public void communication(User emp);
    public void subscribe(User emp);
    public void unSubscribe(User emp);
    public boolean SendMessage(User emp1, User emp2, String serviceName);
}
