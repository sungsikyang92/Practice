//import java.io.BufferedReader;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
////예시이다. 서버시간은 네이버 실시간검색어 순위는 네이트임으로 정상작동은 하지 않는다. 
//public class Main3 {
//	public static void main(String[] args) throws Exception {
//		while(True){
//			String target = "https://www.nate.com/?f=natesvc";
//			HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//			FileWriter fw = null;
//			String temp;
//			while((temp = br.readLine()) != null) {
//				//서버시간 
//				if(temp.contains("svt: ")) {
//					fw = new FileWriter(temp.split("svt: ")[1].split(",")[0] + ".txt");
//				}
//				//실시간검색
//				if(temp.contains("class=\"txt_rank\"")) {
//	//				System.out.println(temp);
//	//				System.out.println(temp.split("class=\"txt_rank\">")[1].split("<")[0]);
//					fw.write(temp.split("class=\"txt_rank\">")[1].split("<")[0] + "\r\n");
//				}
//				//write close 
//				if(rank == 10) {
//					fw.close();
//				}
//			}
//			con.disconnect();
//			br.close();
//			//10초동안 
//			Thread.sleep(10000);
//		}
//	}
//}
//
