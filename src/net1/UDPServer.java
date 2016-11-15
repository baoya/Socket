package net1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDPServer implements Runnable {
	
	private int port;
	
	
	public UDPServer(int port) {
		super();
		this.port = port;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		try {
			//创建服务器对象
			ds = new DatagramSocket(port);
			//创建字节数组
			byte[] chs = new byte[1024];
			System.out.println("服务器已经启动");
			while(true){
				//创建数据包对象
				DatagramPacket dp = new DatagramPacket(chs, chs.length);
				//数据包的接收
				ds.receive(dp);
				//获得发送端的IP
				InetAddress ip1 = dp.getAddress();
				//获得数据包中的数据，这个数组的长度是我们自己定义时的长度
				byte[] sj = dp.getData();
				//获得接受数据的长度，实际接受的长度
				int len = dp.getLength();
				//组装数据包中的数据
				String str = new String(sj, 0, len);
				System.out.println(ip1.getHostAddress()+"说：\r\n"+str);		
				if("exit".equals(str)){
					break;
				}
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
