package com.example.Pulsar_test.Pulsar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonDecoder;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.DeadLetterPolicy;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.client.api.schema.SchemaDefinition;
import org.apache.pulsar.client.impl.PulsarClientImpl;
import org.apache.pulsar.client.impl.schema.generic.MultiVersionSchemaInfoProvider;
import org.apache.pulsar.common.naming.TopicName;
import org.apache.pulsar.shade.io.netty.handler.codec.http.DefaultFullHttpRequest;
import org.apache.pulsar.shade.io.netty.handler.codec.http.DefaultHttpRequest;
import org.apache.pulsar.client.api.schema.SchemaReader;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class PulsarConsumer {
	final static String TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NzU2NzAxODMsImlzcyI6ImRhdGFzdGF4Iiwic3ViIjoiY2xpZW50OzNhM2VkM2YwLWUxN2UtNGNhOS1iZGRiLTkwY2UwZmVmYzhkNzthR3hsTFdGd2IyeHNieTFqWkdNPTszMjUxNGVlMmQxIiwidG9rZW5pZCI6IjMyNTE0ZWUyZDEifQ.NLe3L9mcVr-Yicr8PBvm7x1Vvnim7vnUAcvJ429fxVDRc44sQmTHXiWIVMLH1ChgvNCff4YQJTtxwZZTbkbMCIM-r0uEOAUdHAYfDXLbKE88zrPVoJBQBhFwCX-CBqwmaIxnCcf9gTtfQ7PXCGxN5BJnEBV4PXKWkpMC6heDLydf_sEba1p5oX2v7MffEalkqLQfd8U7I2IhpJGE6awmCycJR8Pozbo_1nHoFTc2kMpOY1C-CnJlajSRVGbPkmhKUbFD5IJq4aAifqqcO6vn9Ri9raFGdJocURh-Jc8A6Sa09OQ8-1kAvoETjaFqBHKA6XpiCdmXvUU0Ei6Z3SCbbw";
	private Schema keySchema;
	private Schema valueSchema;
	private Schema combinedSchema;
    private GenericRecord keyRecord;
    private GenericRecord valueRecord;
	private GenericRecord combinedRecord; 
	private File file;   
	private DatumWriter<GenericRecord> datumWriter ;
	private DataFileWriter<GenericRecord> dataFileWriter;
	
	public static void main(String[] args) {
		     
		try {
			PulsarConsumer pulsarConsumer=new PulsarConsumer();
        	PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar+ssl://pulsar-gcp-uscentral1.streaming.datastax.com:6651")
                    .authentication(
                        AuthenticationFactory.token(TOKEN)
                    )
                    .build();
        	
        	
        	pulsarConsumer.setKeySchema(new Schema.Parser().parse(new File("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/avro/ContainerPlanKey.avsc")));
    		pulsarConsumer.setValueSchema(new org.apache.avro.Schema.Parser().parse(new File("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/avro/ContainerPlanValue.avsc")));
    		pulsarConsumer.setCombinedSchema(new org.apache.avro.Schema.Parser().parse(new File("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/avro/KeyValueSchema.avsc")));


            
    		FileOutputStream outputStream = new FileOutputStream("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/java/com/example/Pulsar_test/model/data.avro");
			
            
            Consumer<byte[]> consumer = client.newConsumer()
            		.topic("persistent://hle-apollo-cdc/astracdc/data-57d08fd8-6deb-4a9b-933b-908783c5113c-sortation.container_plan")
                    .subscriptionName("my-subscription-12345678910")
                    .subscriptionType(SubscriptionType.Key_Shared)
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
            	    .subscribe();
            

            while (true) {
                // Deserialize key and value
                try {
                	
                	Message<byte[]> msg = consumer.receive();

//                	writeRecordToFile(pulsarConsumer.getCombinedSchema(),msg, outputStream);
                    
        
//                    Schema raw = new Schema.Parser().setValidate(true).parse(avroSchemaInJson);
//                    AvroSchema schema = new AvroSchema(raw);
//                    schema.withReaderSchema(schema);
//                    schema.getReader();
//                    
                	System.out.println("Message in Bytes: "+msg.getData());

                	
                    // Deserialize byte array to Avro record
                    DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(pulsarConsumer.getCombinedSchema());
                    Decoder decoder = DecoderFactory.get().binaryDecoder(msg.getData(), null);
                    GenericRecord avroRecord = datumReader.read(null, decoder);
                    System.out.println(avroRecord);

                    // Save Avro record to file
                    
//                    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(pulsarConsumer.getCombinedSchema());
//                    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
//                    dataFileWriter.create(pulsarConsumer.getCombinedSchema(), pulsarConsumer.getFile());
//                    dataFileWriter.append(avroRecord);
                    
//                    break;

                }
                
                catch (Exception e) {
     				System.out.println(e.getMessage());  
    				e.printStackTrace();
                 }
               
            }
        }
        catch(Exception e) {
				System.out.println(e.getMessage());  
			e.printStackTrace();
        } 
    }
	
//    private static void writeRecordToFile(Schema avroSchema,org.apache.pulsar.client.api.schema.GenericRecord record, OutputStream outputStream) throws IOException {
//        DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(avroSchema);
//        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(new File("/Users/shreshtjain99/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Pulsar-test/src/main/java/com/example/Pulsar_test/model/data.avro"), datumReader);
//        GenericRecord emp = null;
//  		
//        while (dataFileReader.hasNext()) {
//           emp = dataFileReader.next(emp);
//           System.out.println(emp);
//        }
//     }
	
//    private static byte[] serializeAvroGenericRecord(org.apache.avro.generic.GenericRecord record, Schema schema) throws IOException {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        DatumWriter<org.apache.avro.generic.GenericRecord> writer = new GenericDatumWriter<>(schema);
//        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
//        writer.write(record, encoder);
//        encoder.flush();
//        out.close();
//        return out.toByteArray();
//    }
    }
