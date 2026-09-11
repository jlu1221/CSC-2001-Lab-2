public record DateInterval(Date start, Date end) {
    public DateInterval {
        if (Date.comesBefore(end, start) && !end.equals(start)) {
            // throw exception
            throw new IllegalArgumentException("Invalid Interval");
        }
    }

    // dateIntervalDays method


}
