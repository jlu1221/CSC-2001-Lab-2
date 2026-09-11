public record DateInterval(Date start, Date end) {
    public DateInterval {
        if (Date.comesBefore(end, start) && !end.equals(start)) {
            // throw exception
            throw new IllegalArgumentException("Invalid Interval");
        }
    }

    // dateIntervalDays method
    static int dateIntervalDays(DateInterval interval) {
        if (interval.start().year() == interval.end().year()) {
            return Date.dayOfYear(interval.end()) - Date.dayOfYear(interval.start());
        }
        else {
            return (interval.end().year() - interval.start().year()) * 365
                    - Date.dayOfYear(interval.start())
                    + Date.dayOfYear(interval.end());
        }
    }

    // dateOverlap method
    static boolean dateOverlap(DateInterval a, DateInterval b) {
        return Date.comesBefore(a.start(), b.end())
                && Date.comesBefore(b.start(), a.end());
    }

    // dateIntervalIntersect method
    static DateInterval dateIntervalIntersect(DateInterval a, DateInterval b) {
        if (!dateOverlap(a, b)) {
            return null;
        }
        Date start;
        if (Date.comesBefore(a.start(), b.start())) {
            start = b.start();
        } else {
            start = a.start();
        }
        Date end;
        if (Date.comesBefore(a.end(), b.end())) {
            end = a.end();
        } else {
            end = b.end();
        }
        return new DateInterval(start, end);
    }

    static DateInterval maybeDateIntervalIntersect(DateInterval a, DateInterval b) {
        if (a == null || b == null) {
            return null;
        }
        return dateIntervalIntersect(a, b);
    }
}
