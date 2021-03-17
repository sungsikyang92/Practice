import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	private static String valueOne[] = {"1101","1102","1104","2101","2102","2103","2104","2105","2201","2202","2203","2204","2205","3101","3102","3103","3104","3105","3106","3107","3108","3109","3111","3201","3202","3301"};
	private static String valueTwo[] = {"91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91","91"};
	private static String valueThree[] = {"전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공","전공"};
	private static String valueFour[] = {"유아교육과","초등교육과","교육학과","국어교육과","영어교육과","독어교육과","불어교육과","중국어교육과","윤리교육과","일반사회교육과","지리교육과","역사교육과","공통사회교육전공","수학교육과","물리교육과","화학교육과","생물교육과","지구과학교육과","가정교육과","컴퓨터교육과","기술교육과","환경교육과","공통과학교육전공","음악교육과","미술교육과","체육교육과"};
	
	private static FileWriter fw;
	private static int courseID = 0;
	
	public static void main(String[] args) {
		
		try {
			fw = new FileWriter("output.txt");
			for(int i = 0; i < valueOne.length; i++) {
				String target = "http://was.knue.ac.kr/j2ee/haksa/etc/public/s_major_time_v.jsp?area1=2016&area2=21&area3=" + valueTwo[i] + "&area4=" + valueOne[i];
				HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "EUC-KR"));
				String plainText = "";
				String temp;
				while((temp = br.readLine()) != null)
				{
					plainText += temp + "\n";
				}
				parsing(plainText, "학부", 2016, "2학기", valueThree[i], valueFour[i]);
				con.disconnect();
				br.close();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void parsing(String plainText, String courseUniversity, int courseYear, String courseTerm, String courseArea, String courseMajor) throws Exception 
	{
		String courseGrade;	//해당 학년 
		String courseTitle;	//강의 제목 
		int courseCredit;	//강의 학점 
		int courseDivide;	//강의 분반 
		int coursePersonnel;	//강의 제한 인원 
		String courseProfessor;	//강의 교수 	
		String courseTime;	//강의 시간대 
		String courseRoom;	//강의실 
		String[] courses = plainText.split("<tr height=25>");
		for(int i = 1; i < courses.length; i++)
		{
			String parts[] = courses[i].split("<td bgcolor=ffffff align=center>");
			for(int j = 1; j < parts.length; j++)
			{
				parts[j] = (parts[j].split("</td>")[0].replaceAll("<font  color=blue", "").replaceAll("</font>", "").replaceAll(">", "").replaceAll("\t", "").replaceAll(" ", "").replaceAll("\n", ""));
			}
			courseGrade = parts[1];
			courseTitle = parts[4];
			courseCredit = Integer.parseInt(parts[5]);
			courseDivide = Integer.parseInt(parts[8]);
			coursePersonnel = Integer.parseInt(parts[9]);
			courseProfessor = parts[10];
			courseTime = parts[11];
			courseRoom = parts[12];
			Course course = new Course(++courseID, courseUniversity, courseYear, courseTerm, courseArea,
					courseMajor, courseGrade, courseTitle, courseCredit, courseDivide,
					coursePersonnel, courseProfessor, courseTime, courseRoom);
			fw.write("\"" + course.getCourseID() + "\"," +
					"\"" + course.getCourseUniversity() + "\"," +
					"\"" + course.getCourseYear() + "\"," +
					"\"" + course.getCourseTerm() + "\"," +
					"\"" + course.getCourseArea() + "\"," +
					"\"" + course.getCourseMajor() + "\"," +
					"\"" + course.getCourseGrade() + "\"," +
					"\"" + course.getCourseTitle() + "\"," +
					"\"" + course.getCourseCredit() + "\"," +
					"\"" + course.getCourseDivide() + "\"," +
					"\"" + course.getCoursePersonnel() + "\"," +
					"\"" + course.getCourseProfessor() + "\"," +
					"\"" + course.getCourseTime() + "\"," +
					"\"" + course.getCourseRoom() + "\"\r\n");
		}
	}
}
