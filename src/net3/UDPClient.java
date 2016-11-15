package net3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient implements Runnable {
	//发送的目的地的IP
	private String ip;
	//发送目的地的端口号
	private int port;
	//构造器
	public UDPClient(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		BufferedReader br = null;
		try {
			//创建控制台的输入流
			br = new BufferedReader(new InputStreamReader(System.in));
			//创建客户端对象
			ds = new DatagramSocket();
			System.out.println("已经接入"+ip);
			while(true){
				//从控制台读取一行
				String line = br.readLine();
				//创建发送的数据		
				byte[] bs = line.getBytes();
				//创建要发送的目的地的IP对象
				InetAddress ip1 = InetAddress.getByName(ip);
				//打数据包
				DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, ip1, port);
				//发送
				ds.send(dp);
				System.out.println("我说：\r\n"+line);
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
