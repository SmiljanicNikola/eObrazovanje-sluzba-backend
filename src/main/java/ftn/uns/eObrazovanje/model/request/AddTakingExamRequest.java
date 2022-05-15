package ftn.uns.eObrazovanje.model.request;

public class AddTakingExamRequest {


    private Integer grade;

    private boolean passed;

    private Integer lecturerId;

    private Integer attendingCoursesId;

    private boolean deleted;

    public Integer getGrade() {
        return grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public Integer getAttendingCoursesId() {
        return attendingCoursesId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public void setAttendingCoursesId(Integer attendingCoursesId) {
        this.attendingCoursesId = attendingCoursesId;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AddTakingExamRequest() {
    }

    public AddTakingExamRequest(Integer grade, boolean passed, Integer lecturerId, Integer attendingCoursesId) {
        this.grade = grade;
        this.passed = passed;
        this.lecturerId = lecturerId;
        this.attendingCoursesId = attendingCoursesId;
    }

    public AddTakingExamRequest(Integer grade, boolean passed, Integer lecturerId, Integer attendingCoursesId, boolean deleted) {
        this.grade = grade;
        this.passed = passed;
        this.lecturerId = lecturerId;
        this.attendingCoursesId = attendingCoursesId;
        this.deleted = deleted;
    }
}
