package after.refactor;

import mocked.utils.InternetSessionHistory;

import java.util.List;

public class ISPSubscriber extends Subscriber {

    private long freeUsage;

    public ISPSubscriber() {}

    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    @Override
    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(subscriberId);

        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;

        if (chargeableData <= 0) {
            return 0;
        }

        return chargeableData * baseRate / 100;
    }
}
