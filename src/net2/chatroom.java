package net2;

public class chatroom {
	
	public static void main(String[] args) {
		//�������ܶ˶�����̵߳�ʵ��
		UDPClient uc = new UDPClient("192.168.1.156",10003);
		UDPServer us = new UDPServer(10004);
		//���Ͷ˵��߳�
		Thread t = new Thread(uc);
		//���ն˵��߳�
		Thread t1 = new Thread(us);
		//���������߳�
		t.start();
		t1.start();
	}
}
