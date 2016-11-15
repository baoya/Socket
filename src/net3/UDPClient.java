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
	//���͵�Ŀ�ĵص�IP
	private String ip;
	//����Ŀ�ĵصĶ˿ں�
	private int port;
	//������
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
			//��������̨��������
			br = new BufferedReader(new InputStreamReader(System.in));
			//�����ͻ��˶���
			ds = new DatagramSocket();
			System.out.println("�Ѿ�����"+ip);
			while(true){
				//�ӿ���̨��ȡһ��
				String line = br.readLine();
				//�������͵�����		
				byte[] bs = line.getBytes();
				//����Ҫ���͵�Ŀ�ĵص�IP����
				InetAddress ip1 = InetAddress.getByName(ip);
				//�����ݰ�
				DatagramPacket dp = new DatagramPacket(bs, 0, bs.length, ip1, port);
				//����
				ds.send(dp);
				System.out.println("��˵��\r\n"+line);
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
