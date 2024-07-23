package com.example.Pulsar_test.Pulsar;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class KeyValueSchemaGenerator {
    public static void main(String[] args) {
        try {
            // Load key and value schemas
            Schema keySchema = new Schema.Parser().parse(new File("/Users/shreshtjain99/Desktop/UserService/src/main/java/com/semicolons/user/avro/ContainerPlanKey.avsc"));
            Schema valueSchema = new Schema.Parser().parse(new File("/Users/shreshtjain99/Desktop/UserService/src/main/java/com/semicolons/user/avro/ContainerPlanValue.avsc"));

            // Create fields for the key and value
            Field keyField = new Field("key", keySchema, null, (Object) null);
            Field valueField = new Field("value", valueSchema, null, (Object) null);

            // Create a new schema with both key and value fields
            Schema combinedSchema = Schema.createRecord("KeyValueRecord", null, null, false);
            combinedSchema.setFields(Arrays.asList(keyField, valueField));

            // Write the combined schema to a new .avsc file
            try (FileWriter fileWriter = new FileWriter("/Users/shreshtjain99/Desktop/UserService/src/main/java/com/semicolons/user/avro/KeyValueSchema.avsc")) {
                fileWriter.write(combinedSchema.toString(true));
            }

            System.out.println("Combined schema generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
