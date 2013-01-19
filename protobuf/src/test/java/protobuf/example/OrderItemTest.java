package protobuf.example;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static protobuf.example.Order.*;

public class OrderItemTest {

    @Test
    public void serializeOrderItem() throws InvalidProtocolBufferException {
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

        byte[] serializedOrderItem = orderItem.toByteArray();

        OrderItem hydratedOrderItem = OrderItem.parseFrom(serializedOrderItem);

        List<OrderItemFee> fees = hydratedOrderItem.getItemFeesList();

        assertThat(fees.size(), is(not(0)));
        assertEquals(fees.get(0).getAmount(), fee.toBDecimal());
        assertThat(hydratedOrderItem.getSkuNumber(), is(4010L));
        assertThat(hydratedOrderItem.getQuantity(), is(2));

        //
        // Note taxable field is optional with a default value of true...
        //
        assertThat(fees.get(0).getTaxable(), is(true));
    }
}
