public record DateList(Date first, DateList rest) {
    // listLen method
    static int listLen(DateList list) {
        if (list == null) {
            return 0;
        } else {
            return 1 + listLen(list.rest());
        }
    }
    // minDate method
    static Date minDate(DateList list) {
        if (list == null) {
            return null;
        }
        if (list.rest() == null) {
            return list.first();
        }

        Date restMin = minDate(list.rest());

        if (Date.comesBefore(list.first(), restMin)) {
            return list.first();
        } else {
            return restMin;
        }
    }

    // dateCover method
    static DateInterval dateCover(DateList list) {
        if (list == null) {
            return null;
        }

        Date latest = list.first();
        DateList remaining = list.rest();

        while (remaining != null) {
            if (Date.comesBefore(latest, remaining.first())) {
                latest = remaining.first();
            }
            remaining = remaining.rest();
        }
        return new DateInterval(minDate(list), Date.tomorrow((latest)));
    }

    // allTomorrows method
    static DateList allTomorrows(DateList list) {
        if (list == null) {
            return null;
        }
        return new DateList(
                Date.tomorrow(list.first()),
                allTomorrows(list.rest())
        );
    }
    // addToEnd method
    static DateList addToEnd(DateList list, Date date) {
        if (list == null) {
            return new DateList(date, null);
        }
        return new DateList(
                list.first(),
                addToEnd(list.rest(), date)
        );
    }
    // append method
    static DateList append(DateList list1, DateList list2) {
        if (list1 == null) {
            return list2;
        }
        return new DateList(
                list1.first(),
                append(list1.rest(), list2)
        );
    }
}
