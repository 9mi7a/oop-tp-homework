import java.util.*;
class Subject {
    private String subjectName;
    private List<Teacher> teachers;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.teachers = new ArrayList<>();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "Subject [subjectName=" + subjectName + "]";
    }
}


