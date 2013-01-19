package protobuf.example;

import com.google.protobuf.ByteString;

import java.math.BigDecimal;
import java.math.BigInteger;

import static protobuf.example.Order.*;

public class Money {

    private final BigDecimal bdVal;
    private final BDecimal bDecimal;

    public Money(BigDecimal val) {
        bdVal = val;
        bDecimal = toBDecimal();
    }

    public Money(BDecimal val) {
        bDecimal = val;
        bdVal = toBigDecimal();
    }

    public BigDecimal getAmount() {
        return bdVal;
    }

    public BDecimal toBDecimal() {
        BigInteger biVal = bdVal.toBigInteger();

        return BDecimal.newBuilder()
                .setScale(bdVal.scale())
                .setIntVal(BInteger.newBuilder()
                        .setValue(ByteString.copyFrom(biVal.toByteArray()))
                        .build())
                .build();
    }

    private BigDecimal toBigDecimal() {
        ByteString bytes = bDecimal.getIntVal().toByteString();
        return new BigDecimal(new BigInteger(bytes.toByteArray()));
    }
}
