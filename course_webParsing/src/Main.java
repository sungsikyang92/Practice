import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		
		try {
			String target = "http://was.knue.ac.kr/j2ee/haksa/etc/public/s_major_time_v.jsp?area1=2016&area2=21&area3=91&area4=3108";
			HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "EUC-KR"));
			String plainText = "";
			String temp;
			while((temp = br.readLine()) != null)
			{
				plainText += temp + "\n";
			}
			parsing(plainText);
			con.disconnect();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void parsing(String plainText) 
	{
		String courseUniversity = "학부";
		int courseYear = 2016;
		String courseTerm = "2학기"; 
		String courseMajor = "기술교육과";
		int courseGrade;	//해당 학년 
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
			courseGrade = Integer.parseInt(parts[1]);
			courseTitle = parts[4];
			courseCredit = Integer.parseInt(parts[5]);
			courseDivide = Integer.parseInt(parts[8]);
			coursePersonnel = Integer.parseInt(parts[9]);
			courseProfessor = parts[10];
			courseTime = parts[11];
			courseRoom = parts[12];
			Course course = new Course(courseUniversity, courseYear, courseTerm,
					courseMajor, courseGrade, courseTitle, courseCredit, courseDivide,
					coursePersonnel, courseProfessor, courseTime, courseRoom);
			course.show();
		}
	}
}
