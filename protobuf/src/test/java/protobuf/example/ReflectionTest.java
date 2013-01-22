package protobuf.example;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

import static java.lang.String.format;
import static protobuf.example.SuperHero.FutileSuperpowerType.*;
import static protobuf.example.SuperHero.*;

public class ReflectionTest {
    Logger logger = Logger.getLogger(getClass());

    //
    // Note: Look at the implementation of com.google.protobuf.TextFormat for a more in-depth example
    // of protobuf's reflection API
    //
    @Test
    public void printFields() {

        printFields(UselessSuperHeroSighting.newBuilder()
                .setLatitude( 55.949354)
                .setLongitude(-3.147583)
                .setName("kiwimancer")
                .setPowerType(COMMUNICATE_WITH_FRUIT)
                .build());
    }

    void printFields(Message message) {

        for (Map.Entry<Descriptors.FieldDescriptor, Object> field
                : message.getAllFields().entrySet()) {

            Descriptors.FieldDescriptor fieldDescriptor= field.getKey();

            logger.info(format("Field Name: %s FieldType: %s Optional: %s FieldValue: %s",
                    fieldDescriptor.getName(),
                    fieldDescriptor.getType(),
                    fieldDescriptor.isOptional() ? "Yes" : "No",
                    field.getValue()));
        }
    }
}
