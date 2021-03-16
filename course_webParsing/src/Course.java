
public class Course {
	
	int courseID;	//강의 고유 번
	String courseUniversity;	//학부 혹은 대학원 
	int courseYear;	//해당 년도 
	String courseTerm;	//해당 학기 
	String courseMajor;	//해당 학과 
	int courseGrade;	//해당 학년 
	String courseTitle;	//강의 제목 
	int courseCredit;	//강의 학점 
	int courseDivide;	//강의 분반 
	int coursePersonnel;	//강의 제한 인원 
	String courseProfessor;	//강의 교수 	
	String courseTime;	//강의 시간대 
	String courseRoom;	//강의실 
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseUniversity() {
		return courseUniversity;
	}
	public void setCourseUniversity(String courseUniversity) {
		this.courseUniversity = courseUniversity;
	}
	public int getCourseYear() {
		return courseYear;
	}
	public void setCourseYear(int courseYear) {
		this.courseYear = courseYear;
	}
	public String getCourseTerm() {
		return courseTerm;
	}
	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}
	public String getCourseMajor() {
		return courseMajor;
	}
	public void setCourseMajor(String courseMajor) {
		this.courseMajor = courseMajor;
	}
	public int getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public int getCourseDivide() {
		return courseDivide;
	}
	public void setCourseDivide(int courseDivide) {
		this.courseDivide = courseDivide;
	}
	public int getCoursePersonnel() {
		return coursePersonnel;
	}
	public void setCoursePersonnel(int coursePersonnel) {
		this.coursePersonnel = coursePersonnel;
	}
	public String getCourseProfessor() {
		return courseProfessor;
	}
	public void setCourseProfessor(String courseProfessor) {
		this.courseProfessor = courseProfessor;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getCourseRoom() {
		return courseRoom;
	}
	public void setCourseRoom(String courseRoom) {
		this.courseRoom = courseRoom;
	}
	public Course(String courseUniversity, int courseYear, String courseTerm,
			String courseMajor, int courseGrade, String courseTitle, int courseCredit, int courseDivide,
			int coursePersonnel, String courseProfessor, String courseTime, String courseRoom) {
		super();
		this.courseUniversity = courseUniversity;
		this.courseYear = courseYear;
		this.courseTerm = courseTerm;
		this.courseMajor = courseMajor;
		this.courseGrade = courseGrade;
		this.courseTitle = courseTitle;
		this.courseCredit = courseCredit;
		this.courseDivide = courseDivide;
		this.coursePersonnel = coursePersonnel;
		this.courseProfessor = courseProfessor;
		this.courseTime = courseTime;
		this.courseRoom = courseRoom;
	}
	public Course(int courseID, String courseUniversity, int courseYear, String courseTerm,
			String courseMajor, int courseGrade, String courseTitle, int courseCredit, int courseDivide,
			int coursePersonnel, String courseProfessor, String courseTime, String courseRoom) {
		super();
		this.courseID = courseID;
		this.courseUniversity = courseUniversity;
		this.courseYear = courseYear;
		this.courseTerm = courseTerm;
		this.courseMajor = courseMajor;
		this.courseGrade = courseGrade;
		this.courseTitle = courseTitle;
		this.courseCredit = courseCredit;
		this.courseDivide = courseDivide;
		this.coursePersonnel = coursePersonnel;
		this.courseProfessor = courseProfessor;
		this.courseTime = courseTime;
		this.courseRoom = courseRoom;
	}
	public void show()
	{
		System.out.println("----------------------------------");
		System.out.println("학부 혹은 대학원: " + courseUniversity);
		System.out.println("해당 년도: " + courseYear);
		System.out.println("해당 학기: " + courseTerm);
		System.out.println("해당 학과: " + courseMajor);
		System.out.println("해당 학년: " + courseGrade);
		System.out.println("강의 제목: " + courseTitle);
		System.out.println("강의 학점: " + courseCredit);
		System.out.println("제한 인원: " + courseDivide);
		System.out.println("강의 교수: " + courseProfessor);
		System.out.println("강의 시간: " + courseTime);
		System.out.println("강의실: " + courseRoom);
	}
}