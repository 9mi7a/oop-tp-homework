import java.util.ArrayList;
import java.util.List;

class Exam {
    private String examName;
    private Subject subject;
    private List<Student> enrolledStudents;

    public Exam(String examName, Subject subject) {
        this.examName = examName;
        this.subject = subject;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getExamName() {
        return examName;
    }
    public Subject getSubject() {
        return subject;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

     public void enrollStudent(Student student) {
        enrolledStudents.add(student);}
//affichage
    @Override
    public String toString() {
        return " Exam [exam Name=" + examName + "; subject=" + subject.getSubjectName() + "]";
    }}