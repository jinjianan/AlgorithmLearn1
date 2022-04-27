package linear_search;

public class Student {

    private String name;

    public Student(String name){
        this.name = name;
    }

    public boolean equals(Student student){
        return this.name.equals(student.getName());
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
        return this.name.equals( o.name );
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
