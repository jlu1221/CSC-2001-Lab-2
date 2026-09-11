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
}