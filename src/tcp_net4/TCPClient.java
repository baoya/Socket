package tcp_net4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	/**
	 * @param args
	 */
	private String ip;
	private int port;

	public TCPClient(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
		Sender s = new Sender();
		Thread t = new Thread(s);
		t.start();
	}

	class Sender implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Socket s = null;
			BufferedWriter bw = null;
			BufferedReader br = null;
			try {
				s = new Socket(ip, port);
				System.out.println("客户端已经启动!");
				// 获得从控制台输入的流对象
				br = new BufferedReader(new InputStreamReader(System.in));
				// 获得输出流
				OutputStream out = s.getOutputStream();
				bw = new BufferedWriter(new OutputStreamWriter(out));
				String line = "";

				while ((line = br.readLine()) != null) {
					System.out.println("我说:\n" + line);
					if ("exit".equals(line)) {
						break;
					}
					bw.write(line);
					bw.newLine();
					bw.flush();

				}

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (bw != null)
						bw.close();
					if (br != null)
						br.close();
					if (s != null)
						s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPClient("192.168.1.171", 12345);
	}

}
