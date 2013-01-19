package protobuf.example;

import org.junit.Test;

import java.math.BigDecimal;

import static protobuf.example.Order.*;

public class ToStringTest {

    @Test
    public void showMessageAsString() {
        Money fee = new Money(BigDecimal.ONE);

        OrderItem orderItem = OrderItem.newBuilder()
                .setSkuNumber(4010L)
                .setQuantity(2)
                .setPrice(new Money(BigDecimal.TEN).toBDecimal())
                .addItemFees(OrderItemFee.newBuilder()
                        .setAmount(fee.toBDecimal())
                        .setQuantity(1)
                        .build())
                .build();

        System.out.print(orderItem.toString());
    }
}
