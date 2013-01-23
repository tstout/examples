package protobuf.example;

import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.*;
import static java.lang.String.format;
import static org.junit.Assert.*;
import static protobuf.example.SuperHero.FutileSuperpowerType.*;
import static protobuf.example.SuperHero.*;

public class ReflectionTest {

    final static UselessSuperHeroSighting SIGHTING =
            UselessSuperHeroSighting.newBuilder()
                    .setLatitude( 55.949354)
                    .setLongitude(-3.147583)
                    .setName("kiwimancer")
                    .setPowerType(COMMUNICATE_WITH_FRUIT)
                    .build();

    final static Double NEW_DOUBLE_VALUE = Double.MAX_VALUE;
    final static String NEW_STRING_VALUE = "new-value";


    Logger logger = Logger.getLogger(getClass());

    //
    // Note: Look at the implementation of com.google.protobuf.TextFormat for a more in-depth example
    // of protobuf's reflection API
    //
    @Test
    public void printFieldsTest() {

        printFields(SIGHTING);
    }

    @Test
    public void modifyMessageTest() {

        Message modifiedMsg = modifyMessage(SIGHTING);

        assertEquals(fieldValue("name", modifiedMsg), NEW_STRING_VALUE);
        assertEquals(fieldValue("longitude", modifiedMsg), NEW_DOUBLE_VALUE);
    }

    Message modifyMessage(Message message) {

        ImmutableMap<Descriptors.FieldDescriptor.Type, ?> valuesForType =
                of(Descriptors.FieldDescriptor.Type.DOUBLE, NEW_DOUBLE_VALUE,
                        Descriptors.FieldDescriptor.Type.STRING, NEW_STRING_VALUE);

        Message.Builder modifiedMsgBuilder = message.toBuilder();

        for (Map.Entry<Descriptors.FieldDescriptor, Object> field
                : message.getAllFields().entrySet()) {

            Object newValue = valuesForType.get(field.getKey().getType());

            if (newValue != null) {
                modifiedMsgBuilder.setField(field.getKey(), newValue);
            }
        }

        return modifiedMsgBuilder.build();
    }

    Descriptors.FieldDescriptor fieldByName(String name, Message msg) {
        return msg.getDescriptorForType().findFieldByName(name);
    }

    Object fieldValue(String name, Message msg) {
        return msg.getAllFields().get(fieldByName(name, msg));
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
