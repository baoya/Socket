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
//			//�����������˶���
//			ds = new DatagramSocket(11111);
//			//�����������ݵ��ֽ�����
//			byte[] chs = new byte[1024];
//			//�������յ����ݰ�
//			DatagramPacket dp = new DatagramPacket(chs, chs.length);
//			//�������˽������ݰ�
//			ds.receive(dp);
//			
//			//��ȡ���Ͷ˵�IP��ַ
//			InetAddress ip = dp.getAddress();
//			byte[] sj = dp.getData();
//			//��װ���յ��ֽ�����
//			String str = new String(sj, 0, sj.length);
//			System.out.println(ip.getHostAddress()+"������:"+str);
//		} catch (SocketException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DatagramSocket ds = null;
		try {
			//��������������
			ds = new DatagramSocket(12347);
			//�����ֽ�����
			byte[] chs = new byte[1024];
			System.out.println("�������Ѿ�����");
			while(true){
				//�������ݰ�����
				DatagramPacket dp = new DatagramPacket(chs, chs.length);
				//���ݰ��Ľ���
				ds.receive(dp);
				//��÷��Ͷ˵�IP
				InetAddress ip = dp.getAddress();
				//������ݰ��е�����
				byte[] sj = dp.getData();
				//��װ���ݰ��е�����
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
