public class CommunicationServiceFactory {

    public CommunicationService getCommServiceInstance(String commType){

        switch (commType){
            case "Email" :
                return new EmailCommunication();
            case "Text"  :
                return new TextCommunication();
            case "WhatsApp" :
                return new WhatsAppCommunication();
            default :
                return new CallCommunication();

        }
    }
}
