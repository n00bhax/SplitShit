package factory;

public class FactoryProducer {

    public static TicketFactory getFactory(boolean isEquallySplit) {
        if (isEquallySplit) {
            return new EquallySplitTicketFactory();
        } else {
            return new UnequallySplitTicketFactory();
        }
    }
}

