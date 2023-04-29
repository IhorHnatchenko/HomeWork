public class Student {

    private String name;
    private double rate;
    private boolean finished;
    private String type;

    public Student(String name, double rate, boolean finished, String type) {
        this.name = name;
        this.rate = rate;
        this.finished = finished;
        this.type = type;
    }

    public Student(String name, double rate, String type){
        this.name = name;
        this.rate = rate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", finished=" + finished +
                ", type='" + type + '\'' +
                "}\n";
    }
}
