public record DateInterval(Date start, Date end) {
    public DateInterval {
        if (Date.comesBefore(end, start) && !end.equals(start)) {
            // throw exception
            throw new IllegalArgumentException("Invalid Interval");
        }
    }

    // dateIntervalDays method
    // Purpose: This method returns the number of days in the given interval; a 24-hour period from noon of the starting day and noon of the ending day
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
    // Purpose: This method takes two dateIntervals and return true if the intervals overlap each other; return false otherwise
    static boolean dateOverlap(DateInterval a, DateInterval b) {
        return Date.comesBefore(a.start(), b.end())
                && Date.comesBefore(b.start(), a.end());
    }

    // dateIntervalIntersect function
    // Purpose: This function takes two dateIntervals and return a maybe-date-interval representing their intersection
    // maybe-date-interval: this is defined as either a date-interval record or null
    static DateInterval dateIntervalIntersect(DateInterval a, DateInterval b) {
        if (!dateOverlap(a, b)) {
            return null;
        }
        Date start;
        if (Date.comesBefore(a.start(), b.start())) {
            start = a.start();
        } else {
            start = b.start();
        }
        Date end;
        if (Date.comesBefore(a.end(), b.end())) {
            end = a.end();
        } else {
            end = b.end();
        }
        return new DateInterval(start, end);
    }

    // maybeDateIntervalIntersection function
    // Purpose: takes two maybe-date-intervals and returns a maybe-date-interval representing their intersection
    static DateInterval maybeDateIntervalIntersect(DateInterval a, DateInterval b) {
        if (a == null || b == null) {
            return null;
        }
        return dateIntervalIntersect(a, b);
    }
}
