package protobuf.example;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static protobuf.example.SuperHero.*;
import static protobuf.example.SuperHero.FutileSuperpowerType.*;

public class SuperHeroTest {

    static final double LAT = 55.949354;
    static final double LONG = -3.147583;

    @Test
    public void serializeSuperHeroSighting() throws InvalidProtocolBufferException {

        UselessSuperHeroSighting sighting = UselessSuperHeroSighting.newBuilder()
                .setLatitude(LAT)
                .setLongitude(LONG)
                .setName("kiwimancer")
                .setPowerType(COMMUNICATE_WITH_FRUIT)
                .build();

        byte[] serializedSighting = sighting.toByteArray();

        UselessSuperHeroSighting hydratedSighting = UselessSuperHeroSighting.parseFrom(serializedSighting);

        assertEquals(hydratedSighting.getLatitude(), LAT);
        assertEquals(hydratedSighting.getLongitude(), LONG);
        assertEquals(hydratedSighting.getPowerType(), COMMUNICATE_WITH_FRUIT);
    }
}
