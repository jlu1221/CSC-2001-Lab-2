public record Date(int year, int month, int day) {

    // Constructor
    public Date{
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month");
        }
        if (day < 1 || day > daysInMonth(month)){
            throw new IllegalArgumentException(("Invalid day"));
        }

    }

    // daysInMonth method
    // Purpose: This method accepts a month value and returns the number of days in the month; returns a error if the value is invalid
    static int daysInMonth(int month) {
        return switch (month) {
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            case 2 -> 28;
            default -> {
                throw new IllegalArgumentException("Invalid month");
            }
        };
    }

    // main method
    // Three examples of date records
    public static void main(String[] args) {
        Date date1 = new Date(2026, 4, 30);
        Date date2 = new Date(2026, 3,31);
        Date date3 = new Date(2026, 2, 28);
    }

    // tomorrow method
    // Purpose: This method inputs a date and output the next following date
    static Date tomorrow(Date date) {
        // Last day of the year
        if (date.month() == 12 && date.day() == 31) {
            return new Date(date.year() + 1, 1, 1);
        }
        // Last day of month
        else if (date.day() == daysInMonth(date.month())) {
            return new Date(date.year(), date.month() + 1, 1);
        }
        // Normal case
        else
            return new Date(date.year(), date.month(), date.day() + 1);
    }

    // dayOfYear method
    // Purpose: This method return the number of days since Jan 1; specifically a 24-hour period from noon to noon
    static int dayOfYear(Date date) {
        return (switch (date.month()) {
            case 1  -> 0;    // January
            case 2  -> 31;   // February
            case 3  -> 59;   // March
            case 4  -> 90;   // April
            case 5  -> 120;  // May
            case 6  -> 151;  // June
            case 7  -> 181;  // July
            case 8  -> 212;  // August
            case 9  -> 243;  // September
            case 10 -> 273;  // October
            case 11 -> 304;  // November
            case 12 -> 334;  // December
            default -> throw new IllegalArgumentException("Invalid Date");
        });
    }

    // comesBefore method
    // Purpose: This method takes two dates and return true if the first date comes before the second one; return false otherwise
    static boolean comesBefore(Date date1, Date date2) {
        if (date1.year() < date2.year()) {
            return true;
        } else if (date1.year() == date2.year()
                && date1.month() < date2.month()) {
            return true;
        } else if (date1.year() == date2.year()
                && date1.month() == date2.month()
                && date1.day() <= date2.day()) {
            return true;
        } else {
            return false;
        }
    }
}
