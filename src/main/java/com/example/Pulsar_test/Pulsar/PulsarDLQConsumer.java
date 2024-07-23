package com.example.Pulsar_test.Pulsar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.DeadLetterPolicy;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;
import org.apache.pulsar.shade.org.apache.avro.io.BinaryEncoder;

import com.example.Pulsar_test.model.KeyValueRecord;
import com.example.Pulsar_test.model.ContainerPlanKey;
import com.example.Pulsar_test.model.ContainerPlanValue;


public class PulsarDLQConsumer {
	
	final static String TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NzU2NzAxODMsImlzcyI6ImRhdGFzdGF4Iiwic3ViIjoiY2xpZW50OzNhM2VkM2YwLWUxN2UtNGNhOS1iZGRiLTkwY2UwZmVmYzhkNzthR3hsTFdGd2IyeHNieTFqWkdNPTszMjUxNGVlMmQxIiwidG9rZW5pZCI6IjMyNTE0ZWUyZDEifQ.NLe3L9mcVr-Yicr8PBvm7x1Vvnim7vnUAcvJ429fxVDRc44sQmTHXiWIVMLH1ChgvNCff4YQJTtxwZZTbkbMCIM-r0uEOAUdHAYfDXLbKE88zrPVoJBQBhFwCX-CBqwmaIxnCcf9gTtfQ7PXCGxN5BJnEBV4PXKWkpMC6heDLydf_sEba1p5oX2v7MffEalkqLQfd8U7I2IhpJGE6awmCycJR8Pozbo_1nHoFTc2kMpOY1C-CnJlajSRVGbPkmhKUbFD5IJq4aAifqqcO6vn9Ri9raFGdJocURh-Jc8A6Sa09OQ8-1kAvoETjaFqBHKA6XpiCdmXvUU0Ei6Z3SCbbw";

	
    final static Schema<KeyValue<ContainerPlanKey, ContainerPlanValue>> kvSchema = Schema.KeyValue(
            Schema.AVRO(ContainerPlanKey.class),
            Schema.AVRO(ContainerPlanValue.class),
            KeyValueEncodingType.SEPARATED
    );
    
	public static void main(String[] args) {
       
        try {
        	PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar+ssl://pulsar-gcp-uscentral1.streaming.datastax.com:6651")
                    .authentication(
                        AuthenticationFactory.token(TOKEN)
                    )
                    .build();

            
        	Consumer<GenericRecord> consumer = client.newConsumer(org.apache.pulsar.client.api.Schema.AUTO_CONSUME())
                    .topic("persistent://hle-apollo-cdc/astracdc/data-57d08fd8-6deb-4a9b-933b-908783c5113c-sortation.container_plan_search-hle-cp-sub-dlq")
                    .subscriptionName("container_plan-hle-plan-dlq-2222222")
                    .subscriptionType(SubscriptionType.Key_Shared)
                    .enableRetry(false)
                    .subscribe();
            
            //consumer.seek(360000000);
            while (true) {
            // Listening and waiting for a message
               
                 try {

                	Message<GenericRecord> msg = consumer.receive() ;
                 	//GenericRecord record = msg.getValue();
               
                 	System.out.println("Value: ");
                 	//System.out.println("Key: "+record.getField("Key"));
                 } 
        
        catch(Exception e) {
        	 System.out.println(e.getMessage());
            e.printStackTrace();
        	}
          }

}
        catch(PulsarClientException e) {
       	 System.out.println(e.getMessage());
           e.printStackTrace();
       	}
	}
	
//	public static void deserializeGenericWithSchema(Message<GenericRecord> msg) throws IOException {
//		SpecificDatumWriter<GenericRecord> avroEventWriter = new SpecificDatumWriter<KeyValueRecord>(new org.apache.avro.Schema.Parser().parse(new File("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/avro/KeyValueSchema.avsc")));
//
//		EncoderFactory avroEncoderFactory = EncoderFactory.get();
//	    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//	    org.apache.avro.io.BinaryEncoder binaryEncoder = avroEncoderFactory.binaryEncoder(stream, null);
//	    avroEventWriter.write((KeyValueRecord) msg, binaryEncoder);
//	    binaryEncoder.flush();
//	    IOUtils.closeQuietly(stream);
//	    byte[] m = stream.toByteArray();
//
//	    FileOutputStream fos = new FileOutputStream("/full/path/data/test3.java.avro");
//	    fos.write(m);
//	    fos.close();
//	}
}
