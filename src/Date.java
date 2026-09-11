public record Date(int year, int month, int day){
    public Date{
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("Invalid month");
        }
        if (day < 1){
            throw new IllegalArgumentException(("Invalid day"));
        }
    }
}