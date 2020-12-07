package factory;

public class FactoryProducer {

    public static TicketFactory getFactory(boolean isEvenlySplit) {
        if (isEvenlySplit) {
            return new EvenlySplitTicketFactory();
        } else {
            return new UnequallySplitTicketFactory();
        }
    }
}

