public record Date(int year, int month, int day){
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
    public static void main(String[] args) {
        Date date1 = new Date(2026, 4, 30);
        Date date2 = new Date(2026, 3,31);
        Date date3 = new Date(2026, 2, 28);
    }

    // tomorrow method
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
}
