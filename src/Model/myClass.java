package Model;

public class myClass {
    private String ClassName;
    private int StartDay;
    private int Dayline;

    public myClass(String className, int startDay, int dayline) {
        ClassName = className;
        StartDay = startDay;
        Dayline = dayline;
    }

    @Override
    public String toString() {
        return "myClass{" +
                "ClassName='" + ClassName + '\'' +
                ", StartDay=" + StartDay +
                ", Dayline=" + Dayline +
                '}';
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getStartDay() {
        return StartDay;
    }

    public void setStartDay(int startDay) {
        StartDay = startDay;
    }

    public int getDayline() {
        return Dayline;
    }

    public void setDayline(int dayline) {
        Dayline = dayline;
    }
}
