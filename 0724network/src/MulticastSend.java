import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {

	public static void main(String[] args) {
		try {
			
			MulticastSocket ms = new MulticastSocket();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("닉네임 입력 : ");
			String nick = sc.nextLine();
			String str = nick + "님이 입장하셧습니다.";
			
			while(true) {
				System.out.print("메시지(종료는 end):");
				String msg = sc.nextLine();
				if(msg.equals("end")) {
					msg = nick + "님이 퇴장하셧습니다.";
					//보내는 패킷 만들기 - 내용, 길이, 받을곳의 주소, 포트번호 
					DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
					//데이터 전송
					ms.send(dp);
					//소켓과 스캐너 닫기
					ms.close();
					sc.close();
					break;
				}else {
					//메시지 만들기
					msg = nick + ":" + msg;
					//전송할 패킷만들기
					DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length , InetAddress.getByName("230.100.50.5") , 9999);
					//데이터 전송
					ms.send(dp);
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
