import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2 {
	public static void main(String[] args) throws Exception {
		
		String target = "https://www.nate.com/?f=natesvc";
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		FileWriter fw = null;
		String temp;
		while((temp = br.readLine()) != null) {
			if(temp.contains("class=\"txt_rank\"")) {
//				System.out.println(temp);
//				System.out.println(temp.split("class=\"txt_rank\">")[1].split("<")[0]);
				fw.write(temp.split("class=\"txt_rank\">")[1].split("<")[0] + "\r\n");
			}
		}
		con.disconnect();
		br.close();
	}
}

