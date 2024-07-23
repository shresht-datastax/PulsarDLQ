package com.example.Pulsar_test.Pulsar;

import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionType;

public class PulsarDLQRetryConsumer {
	
//	final static String TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3MDczODEwMjksImlzcyI6ImRhdGFzdGF4Iiwic3ViIjoiY2xpZW50O2M2MjUxMjk0LTEyOTEtNDk5ZC1hNTUwLWE4OGIwYWUzNWI5ZTtiWGt0ZEdWdVlXNTBMV0oxYzNrdFoyOWliR2x1O2ViMDdmYzI4NGMiLCJ0b2tlbmlkIjoiZWIwN2ZjMjg0YyJ9.m30szHo1Mrj8IUm14qgU_oc35rw1HPFH-1H6J6xO3SP8_w771KhSqIRKr2fryBIYRosABW7DnXQXXfHi7ZM-Y7rL_xHB0J7HbEU1GMXjU8_CEnHfIFnreV8mRSdqoXzXKlOgMlKtJEvZ9ormvODmZaU9zhF4DeQlx3cxPxVcPNUP8tN1584wTyDScLwFuX7s20d6zPgRrptt2T8ZcvzdF3k8U-FMpo86U2xP16GFAIlwshDM7pK5R0FsZY0wRts1oRdWVALMFi2Ri_DkLUXqydewc0AOdTs4QE6id7O_qyS9zkoEnTiPRfYUhzXxT4UfQ3ijAQygvhNrFSLrqhG16Q";
//	 
//	public static void main(String[] args) {
//	       
//        try {
//        	PulsarClient client = PulsarClient.builder()
//                    .serviceUrl("pulsar+ssl://pulsar-gcp-uscentral1.streaming.datastax.com:6651")
//                    .authentication(
//                        AuthenticationFactory.token(TOKEN)
//                    )
//                    .build();
//            Consumer<String> consumer = client.newConsumer(Schema.STRING)
//                    .topic("persistent://my-tenant-busy-goblin/my-namespace/my-topic-dlq-retry")
//                    .subscriptionName("init-sub")
//                    .subscriptionType(SubscriptionType.Shared)
//                    .subscribe();
//            
//            //consumer.seek(360000000);
//            while (true) {
//            // Listening and waiting for a message
//                 Message<String> msg = consumer.receive();
//               
//                 try {
//                      // Print out that the message has been received
//               
//                    System.out.println("Message received: " + new String(msg.getData()));
//                   
//                    // Send an acknowledgment back so that it can be deleted by the broker
//               
//                     consumer.acknowledge(msg);
//               
//                 } catch (Exception e) {
//               
//                     // Notify that the message delivery failed
//               
//                     //consumer.negativeAcknowledge(msg);
//                 }
//            }
//        }
//        catch(PulsarClientException e) {
//            e.printStackTrace();
//        }
//    }

}
