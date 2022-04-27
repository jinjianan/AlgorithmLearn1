package sort.selection;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public boolean equals(Student student) {
        return this.name.equals(student.getName());
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) return -1;
        return Integer.compare(this.score, o.score);
    }

    @Override
    public boolean equals(Object student) {
        if (student == this)
            return true;
        if (student == null)
            return false;
        if (student.getClass() != this.getClass())
            return false;

        Student o = (Student) student;
        return this.name.equals(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[name: %s score: %d]", name, score);
    }

}
