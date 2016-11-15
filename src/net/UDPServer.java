package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		DatagramSocket ds = null; 
//		try {
//			//创建服务器端对象
//			ds = new DatagramSocket(11111);
//			//创建接收数据的字节数组
//			byte[] chs = new byte[1024];
//			//创建接收的数据包
//			DatagramPacket dp = new DatagramPacket(chs, chs.length);
//			//服务器端接收数据包
//			ds.receive(dp);
//			
//			//获取发送端的IP地址
//			InetAddress ip = dp.getAddress();
//			byte[] sj = dp.getData();
//			//组装接收的字节数据
//			String str = new String(sj, 0, sj.length);
//			System.out.println(ip.getHostAddress()+"发送了:"+str);
//		} catch (SocketException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DatagramSocket ds = null;
		try {
			//创建服务器对象
			ds = new DatagramSocket(12347);
			//创建字节数组
			byte[] chs = new byte[1024];
			System.out.println("服务器已经启动");
			while(true){
				//创建数据包对象
				DatagramPacket dp = new DatagramPacket(chs, chs.length);
				//数据包的接收
				ds.receive(dp);
				//获得发送端的IP
				InetAddress ip = dp.getAddress();
				//获得数据包中的数据
				byte[] sj = dp.getData();
				//组装数据包中的数据
				String str = new String(sj, 0, sj.length);
				System.out.println(str);		
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
