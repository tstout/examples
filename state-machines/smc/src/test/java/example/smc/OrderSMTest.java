package example.smc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderSMTest {

    @Mock OrderActions actions;

    @Test
    public void basicTest() {
        OrderSM sm = new OrderSM(actions);
        sm.addItem(new LineItem());
        sm.suspend();
        sm.resume();
        sm.finish();

        verify(actions).finishOrder();
        verify(actions).persistOrder();
    }
}
