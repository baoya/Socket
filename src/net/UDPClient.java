package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		DatagramSocket ds = null;
//		try {
//			//创建客户端对象
//			ds = new DatagramSocket();
//			//创建要发送的内容
//			byte[] chs = "你好的".getBytes();
//			//创建要发送的目的地的ip对象
//			InetAddress  ip = InetAddress.getByName("192.168.1.157") ;
//			//打数据包
//			DatagramPacket dp = new DatagramPacket(chs, 0, chs.length, ip, 11111);
//			//客户端发送数据包
//			ds.send(dp);
//		} catch (SocketException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DatagramSocket ds = null;
		BufferedReader br = null;
		try {
			//创建控制台的输入流
			br = new BufferedReader(new InputStreamReader(System.in));
			//创建客户端对象
			ds = new DatagramSocket();
			while(true){
				//从控制台读取一行
				String line = br.readLine();
				//创建发送的数据		
				byte[] bs = line.getBytes();
				//创建要发送的目的地的IP对象
				InetAddress ip = InetAddress.getByName("192.168.1.157");
				//打数据包
				DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, ip, 12347);
				//发送
				ds.send(dp);
				//退出程序
				if("exit".equals(line)){
					break;
				}
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
