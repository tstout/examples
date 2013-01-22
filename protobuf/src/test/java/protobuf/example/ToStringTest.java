package protobuf.example;

import com.google.protobuf.TextFormat;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.math.BigDecimal;

import static protobuf.example.Order.*;

public class ToStringTest {
    Logger logger = Logger.getLogger(getClass());

    static final OrderItem ORDER_ITEM = OrderItem.newBuilder()
            .setSkuNumber(4010L)
            .setQuantity(2)
            .setPrice(new Money(BigDecimal.TEN).toBDecimal())
            .addItemFees(OrderItemFee.newBuilder()
                    .setAmount(new Money(BigDecimal.ONE).toBDecimal())
                    .setQuantity(1)
                    .build())
            .build();


    @Test
    public void showMessageAsString() {
        logger.info(ORDER_ITEM.toString());
    }

    @Test
    public void debugPrint() {
        logger.info(String.format("ShortDebug: %s", TextFormat.shortDebugString(ORDER_ITEM)));
    }

}
