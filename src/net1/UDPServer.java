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
			//��������������
			ds = new DatagramSocket(port);
			//�����ֽ�����
			byte[] chs = new byte[1024];
			System.out.println("�������Ѿ�����");
			while(true){
				//�������ݰ�����
				DatagramPacket dp = new DatagramPacket(chs, chs.length);
				//���ݰ��Ľ���
				ds.receive(dp);
				//��÷��Ͷ˵�IP
				InetAddress ip1 = dp.getAddress();
				//������ݰ��е����ݣ��������ĳ����������Լ�����ʱ�ĳ���
				byte[] sj = dp.getData();
				//��ý������ݵĳ��ȣ�ʵ�ʽ��ܵĳ���
				int len = dp.getLength();
				//��װ���ݰ��е�����
				String str = new String(sj, 0, len);
				System.out.println(ip1.getHostAddress()+"˵��\r\n"+str);		
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
