package net1;

public class chatroom {
	
	public static void main(String[] args) {
		//创建接受端对象的线程的实现
		UDPClient uc = new UDPClient("192.168.1.156",10004);
		UDPServer us = new UDPServer(10003);
		//发送端的线程
		Thread t = new Thread(uc);
		//接收端的线程
		Thread t1 = new Thread(us);
		//启动两个线程
		t.start();
		t1.start();
	}
}
