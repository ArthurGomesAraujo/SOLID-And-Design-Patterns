package after.refactor;

import mocked.utils.CallHistory;

import java.util.List;

public class PhoneSubscriber extends Subscriber {

    @Override
    //open for extension
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);

        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();

        return totalDuration * baseRate / 100;
    }
}
