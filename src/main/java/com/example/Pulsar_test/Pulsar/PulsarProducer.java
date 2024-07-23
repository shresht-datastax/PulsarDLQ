package com.example.Pulsar_test.Pulsar;

import java.util.UUID;

import org.apache.pulsar.client.api.*;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;

public class PulsarProducer
{
//	final static String TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NzU2NzAxODMsImlzcyI6ImRhdGFzdGF4Iiwic3ViIjoiY2xpZW50OzNhM2VkM2YwLWUxN2UtNGNhOS1iZGRiLTkwY2UwZmVmYzhkNzthR3hsTFdGd2IyeHNieTFqWkdNPTszMjUxNGVlMmQxIiwidG9rZW5pZCI6IjMyNTE0ZWUyZDEifQ.NLe3L9mcVr-Yicr8PBvm7x1Vvnim7vnUAcvJ429fxVDRc44sQmTHXiWIVMLH1ChgvNCff4YQJTtxwZZTbkbMCIM-r0uEOAUdHAYfDXLbKE88zrPVoJBQBhFwCX-CBqwmaIxnCcf9gTtfQ7PXCGxN5BJnEBV4PXKWkpMC6heDLydf_sEba1p5oX2v7MffEalkqLQfd8U7I2IhpJGE6awmCycJR8Pozbo_1nHoFTc2kMpOY1C-CnJlajSRVGbPkmhKUbFD5IJq4aAifqqcO6vn9Ri9raFGdJocURh-Jc8A6Sa09OQ8-1kAvoETjaFqBHKA6XpiCdmXvUU0Ei6Z3SCbbw";
//
//	public static void main( String[] args )
//    {
//        try {
//            PulsarClient client = PulsarClient.builder()
//                    .serviceUrl("pulsar+ssl://pulsar-gcp-uscentral1.streaming.datastax.com:6651")
//                    .authentication(
//                        AuthenticationFactory.token(TOKEN)
//                    )
//                    .build();
//            
//            Schema<KeyValue<ContainerPlanKey, ContainerPlanValue>> kvSchema = Schema.KeyValue(
//                    Schema.AVRO(ContainerPlanKey.class),
//                    Schema.AVRO(ContainerPlanValue.class),
//                    KeyValueEncodingType.SEPARATED
//            );
//            
//        	Producer<KeyValue<ContainerPlanKey, ContainerPlanValue>> producer = client.newProducer(kvSchema)
//                    .topic("persistent://hle-apollo-cdc/astracdc/data-57d08fd8-6deb-4a9b-933b-908783c5113c-sortation.container_plan_search-hle-cp-sub-dlq")
//                    .create();
//            
//        	
//        	ContainerPlanKey key=new ContainerPlanKey();
//            for(int i=2;i<1555;i++)
//            {
//
//            	key.setContainerId(UUID.randomUUID().toString());
//                producer.send(new KeyValue<>(key, new ContainerPlanValue()));
//               
//            }
//
//            producer.close();
//        }
//        catch (PulsarClientException e) {          
//            e.printStackTrace();
//        }
//       
//    }
}