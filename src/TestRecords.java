public class TestRecords {
    public static void main(String[] args) {
        // Date objects
        Date date1 = new Date(2026, 4, 30);
        Date date2 = new Date(2026, 3, 31);
        Date date3 = new Date(2026, 2, 28);

        System.out.println(Date.daysInMonth(2));
        System.out.println(Date.tomorrow(date2));
        System.out.println(Date.dayOfYear(date1));
        System.out.println(Date.comesBefore(date1, date2));

        // DateInterval objects
        DateInterval interval1 = new DateInterval(date3, date2);
        DateInterval interval2 = new DateInterval(date2, date1);
        DateInterval interval3 = new DateInterval(date3, date1);

        System.out.println(DateInterval.dateIntervalDays(interval1));
        System.out.println(DateInterval.dateOverlap(interval1, interval2));
        System.out.println(DateInterval.dateIntervalIntersect(interval1, interval3));
        System.out.println(DateInterval.maybeDateIntervalIntersect(interval1, interval2));

        // DateList object
        DateList list3 = new DateList(date3, null);
        DateList list2 = new DateList(date1, list3);
        DateList list1 = new DateList(date2, list2);

        System.out.println(DateList.listLen(list1));
        System.out.println(DateList.minDate(list1));
        System.out.println(DateList.dateCover(list1));
        System.out.println(DateList.allTomorrows(list1));
        System.out.println(DateList.addToEnd(list1, new Date(2027, 1, 1)));

        // append list
        DateList list4 = new DateList(new Date(2027, 2, 1), null);

        System.out.println(DateList.append(list1, list4));
    }
}

