package com.example.Pulsar_test.Pulsar;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.pulsar.client.api.*;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;

import com.example.Pulsar_test.model.ContainerPlanKey;
import com.example.Pulsar_test.model.ContainerPlanValue;

@Slf4j
@Data
public class ConsumerService {


	final static String TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NzU2NzAxODMsImlzcyI6ImRhdGFzdGF4Iiwic3ViIjoiY2xpZW50OzNhM2VkM2YwLWUxN2UtNGNhOS1iZGRiLTkwY2UwZmVmYzhkNzthR3hsTFdGd2IyeHNieTFqWkdNPTszMjUxNGVlMmQxIiwidG9rZW5pZCI6IjMyNTE0ZWUyZDEifQ.NLe3L9mcVr-Yicr8PBvm7x1Vvnim7vnUAcvJ429fxVDRc44sQmTHXiWIVMLH1ChgvNCff4YQJTtxwZZTbkbMCIM-r0uEOAUdHAYfDXLbKE88zrPVoJBQBhFwCX-CBqwmaIxnCcf9gTtfQ7PXCGxN5BJnEBV4PXKWkpMC6heDLydf_sEba1p5oX2v7MffEalkqLQfd8U7I2IhpJGE6awmCycJR8Pozbo_1nHoFTc2kMpOY1C-CnJlajSRVGbPkmhKUbFD5IJq4aAifqqcO6vn9Ri9raFGdJocURh-Jc8A6Sa09OQ8-1kAvoETjaFqBHKA6XpiCdmXvUU0Ei6Z3SCbbw";
    
	private String topic;
    private String subscription;
    private PulsarClient pulsarClient;
    private Consumer<KeyValue<ContainerPlanKey, ContainerPlanValue>> consumer;
	private File keyFile; 
	private File valueFile;
    
	private final static Schema<KeyValue<ContainerPlanKey, ContainerPlanValue>> kvSchema = Schema.KeyValue(
            Schema.AVRO(ContainerPlanKey.class),
            Schema.AVRO(ContainerPlanValue.class),
            KeyValueEncodingType.SEPARATED
    );


//	    public DataFileWriter avroFileWriter(Class clazz,File file) throws IOException {
//	        // Extract Avro schema from Pulsar schema
//	    	org.apache.avro.Schema avroSchema =new org.apache.avro.Schema .Parser().parse(new String(Schema.AVRO(clazz).getSchemaInfo().getSchema()));
//	        
//	        DatumWriter datumWriter = new SpecificDatumWriter<>(clazz);
//	    	DataFileWriter dataFileWriter = new DataFileWriter<>(datumWriter);
//	        dataFileWriter.create(avroSchema, file);
//	        
//	        return dataFileWriter;
//	    } 




    public static void main(String[] args)
    {
    	ConsumerService consumerService=new ConsumerService();
    	
    	consumerService.setTopic("persistent://hle-apollo-cdc/astracdc/data-57d08fd8-6deb-4a9b-933b-908783c5113c-sortation.container_plan");
    	consumerService.setSubscription("test-sub-1");
    	
 
    	
    	Consumer<KeyValue<ContainerPlanKey, ContainerPlanValue>> consumer = null;
    	PulsarClient pulsarClient;
    	
    	Message<KeyValue<ContainerPlanKey, ContainerPlanValue>> msg = null;
    	
    	

    	
    	try {	
    		
    		FileOutputStream outputStream = new FileOutputStream("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/java/com/example/Pulsar_test/model/data.avro");
			
    		consumerService.setPulsarClient(PulsarClient.builder()
			            .serviceUrl("pulsar+ssl://pulsar-gcp-uscentral1.streaming.datastax.com:6651")
			            .authentication(
			                AuthenticationFactory.token(TOKEN)
			            )
			            .build());
			pulsarClient=consumerService.getPulsarClient();
			
			consumerService.setConsumer(pulsarClient.newConsumer(kvSchema)
                    .topic(consumerService.getTopic())
                    .subscriptionName(consumerService.getSubscription())
                    .subscriptionType(SubscriptionType.Key_Shared)
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                    .subscribe());
			consumer=consumerService.getConsumer();
			
//			DataFileWriter keyWriter = consumerService.avroFileWriter(ContainerPlanKey.class, consumerService.getKeyFile());
//			DataFileWriter valueWriter = consumerService.avroFileWriter(ContainerPlanValue.class, consumerService.getValueFile());
			
//			org.apache.avro.Schema keySchema =new org.apache.avro.Schema .Parser().parse(new String(Schema.AVRO(ContainerPlanKey.class).getSchemaInfo().getSchema()));
//			org.apache.avro.Schema valueSchema =new org.apache.avro.Schema .Parser().parse(new String(Schema.AVRO(ContainerPlanValue.class).getSchemaInfo().getSchema()));

			
	        while (true) {
	           	 msg = consumer.receive();         
	           	System.out.println("Message  Key : "+msg.getReaderSchema().toString());
	           	
//	           	System.out.println("Message  Key : "+msg.getValue().getValue());
	           	
//				consumerService.writeRecord(keySchema,(GenericRecord)msg.getValue().getKey(), consumerService.getKeyFile());
//				consumerService.writeRecord(valueSchema,(GenericRecord)msg.getValue().getKey(), consumerService.getValueFile());
	           	 
	           	//consumer.acknowledge(msg);
	           	break;

	        }
			
		} 
    	catch (PulsarClientException e) {
			log.error(e.getMessage(), e);
		}
        catch (Exception e) {
        	try {
				consumer.acknowledge(msg);
			} catch (PulsarClientException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			log.error(e.getMessage(), e);
        }
    	
    }
    

}