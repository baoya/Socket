package tcp_net4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 */
	private int Port;
	
	public TCPServer(int port) {
		super();
		Port = port;
		Recevice r = new Recevice();
		Thread t = new Thread(r);
		t.start();
	}
	class Recevice implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader br = null;
			ServerSocket ss = null;
			Socket s = null;
			try {
				// 创建服务器端的服务套接字
				ss = new ServerSocket(Port);
				System.out.println("服务器端已经启动!");
				// 接收到了一个连接的请求,等待客户端来建立连接
				s = ss.accept();
				// 获得发送端的IP
				InetAddress ia = s.getInetAddress();
				// 获得这个通道的输入输出流对象{字节流}
				InputStream in = s.getInputStream();
				br = new BufferedReader(new InputStreamReader(in));
				
				String line = null;
				while((line = br.readLine()) != null){
					// 读取一行
					
					System.out.println(ia.getHostAddress() + "发送了:" + line);
					if("exit".equals(line)){
						break;
					}
				}



			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					if (br != null)
						br.close();
					if(s != null)
						s.close();
					if(ss != null)
						ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	public static void main(String[] args) {
		new TCPServer(12345);
	}
}
