package protobuf.example;

import com.google.common.io.Files;
import com.google.protobuf.Message;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.*;
import static protobuf.example.SuperHero.FutileSuperpowerType.*;
import static protobuf.example.SuperHero.*;

public class SuperHeroTest {

    static final double LAT = 55.949354;
    static final double LONG = -3.147583;

    File dataFile = new File(System.getProperty("user.home"), "sighting.dat");


    @Test
    public void serializeSuperHeroSighting() throws IOException {

        UselessSuperHeroSighting sighting = UselessSuperHeroSighting.newBuilder()
                .setLatitude(LAT)
                .setLongitude(LONG)
                .setName("kiwimancer")
                .setPowerType(COMMUNICATE_WITH_FRUIT)
                .build();

        serializeToFile(sighting);

        UselessSuperHeroSighting hydratedSighting = deserialzeFromFile();

        assertEquals(hydratedSighting.getLatitude(), LAT);
        assertEquals(hydratedSighting.getLongitude(), LONG);
        assertEquals(hydratedSighting.getPowerType(), COMMUNICATE_WITH_FRUIT);
    }

    void serializeToFile(Message message) throws IOException {
        Files.write(message.toByteArray(), dataFile);
    }

    UselessSuperHeroSighting deserialzeFromFile() throws IOException {
        return UselessSuperHeroSighting.parseFrom(Files.toByteArray(dataFile));
    }

}
