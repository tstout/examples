package example.smc;

public class OrderSM {
    private final OrderActions actions;
    private final example.smc.OrderSMContext fsm;

    public OrderSM(OrderActions actions) {
        this.actions = actions;
        fsm = new example.smc.OrderSMContext(this);
        fsm.enterStartState();
    }

    public void addItem(LineItem item) {
        fsm.addItem(item);
    }

    public void resume() {
        fsm.resume();
    }

    public void appendOrderItem(LineItem item) {
        actions.appendOrderItem(item);
    }

    public boolean finishOrderOK() {
        return actions.finishOrder() == OrderActions.FinishStatus.OK;
    }

    public void persistOrder() {
        actions.persistOrder();
    }

    public void suspend() {
        fsm.suspend();
    }

    public void finish() {
        fsm.finish();
    }
}
