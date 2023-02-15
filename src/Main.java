import org.junit.Test;

public class Main {


         CommunicationServiceFactory CommFactory=new CommunicationServiceFactory();
         CommunicationService emailComm=CommFactory.getCommServiceInstance("Email");
         CommunicationService textComm=CommFactory.getCommServiceInstance("Text");
         CommunicationService callComm=CommFactory.getCommServiceInstance("Call");
         CommunicationService WhatsAppComm=CommFactory.getCommServiceInstance("WhatsApp");


         User emp1=new UserBuilder("Lokesh")
                 .age(30)
                 .phone("1234567")
                 .address("Fake address 1234")
                 .build();

         User emp2=new UserBuilder("Jack")
                 .age(40)
                 .phone("5655")
                 //no address
                 .build();
         User emp3=new UserBuilder("Super")
                 //No age
                 //No phone
                 //no address
                 .build();



         @Test
         public void testCase1(){
             emailComm.subscribe(emp1);
             textComm.subscribe(emp1);

             emailComm.subscribe(emp2);
             WhatsAppComm.subscribe(emp2);

             textComm.subscribe(emp3);
             WhatsAppComm.subscribe(emp3);

              System.out.println("Case 1 :\n When users have a common communication Channel");
              emailComm.subscribe(emp1);
              textComm.subscribe(emp1);

              emailComm.subscribe(emp2);
              WhatsAppComm.subscribe(emp2);


              textComm.subscribe(emp3);
              WhatsAppComm.subscribe(emp3);

              emp1.SendMessage(emp2, "How are you..");
              emp2.SendMessage(emp1, "I am fine or you");

         }

     @Test public void testCase2() {
             emailComm.unSubscribe(emp1);
          System.out.println("\nCase 2:\n When users not have any common communication Channel");
              emailComm.unSubscribe(emp1);

              emp1.SendMessage(emp2,"Hi Deepak");
     }
}