import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BroadCastSend {

	public static void main(String[] args) {
		try {
			//UDP전송을 위한 소켓생성
			DatagramSocket ds = new DatagramSocket();
			Scanner sc = new Scanner(System.in);
			System.out.print("닉네임 입력 : ");
			String nick = sc.nextLine();
			String msg = nick + "님이 전송할 준비가 되엇습니다.";
			//닉네임 전송
			DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length , InetAddress.getByName("192.168.0.255"),7777);
			ds.send(dp);
			while(true) {
				System.out.print("메시지 : ");
				msg = sc.nextLine();
				msg = nick + ":" + msg;
				dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length , InetAddress.getByName("192.168.0.255"),7777);
				ds.send(dp);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
