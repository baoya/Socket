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
//			//�����ͻ��˶���
//			ds = new DatagramSocket();
//			//����Ҫ���͵�����
//			byte[] chs = "��õ�".getBytes();
//			//����Ҫ���͵�Ŀ�ĵص�ip����
//			InetAddress  ip = InetAddress.getByName("192.168.1.157") ;
//			//�����ݰ�
//			DatagramPacket dp = new DatagramPacket(chs, 0, chs.length, ip, 11111);
//			//�ͻ��˷������ݰ�
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
			//��������̨��������
			br = new BufferedReader(new InputStreamReader(System.in));
			//�����ͻ��˶���
			ds = new DatagramSocket();
			while(true){
				//�ӿ���̨��ȡһ��
				String line = br.readLine();
				//�������͵�����		
				byte[] bs = line.getBytes();
				//����Ҫ���͵�Ŀ�ĵص�IP����
				InetAddress ip = InetAddress.getByName("192.168.1.157");
				//�����ݰ�
				DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, ip, 12347);
				//����
				ds.send(dp);
				//�˳�����
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
