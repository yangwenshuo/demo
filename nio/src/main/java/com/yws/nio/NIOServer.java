package com.yws.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

	//����һ��ͨ����ѯ��
	private Selector selector;
	
	public void initServer(int port) throws IOException {
		//�����Ƿ������ô����һ��ServerSocketChannel����,
		//��������tcp�������˴���sokcetchannel����
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//ע���������ServerSocketChannel���open������������
		
		
		//ע�����Ҫ�����serversocketchannel���óɷ�������
		serverSocketChannel.configureBlocking(false);
		
		//�󶨷���˼����Ķ˿�
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		
		
		//��Selector��open��������һ��selector����
		this.selector = Selector.open();
		
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		//ע�����init�������Ǵ���serersocketchannel��selector
		//Ȼ��ͨ��serversocketchannel��register����ѯ��selector�󶨵����serversocketchannel
	}
	
	
	
	public void listen() throws IOException {
		
		while(true) {
			
			
			//ע�������������˼��selectorȥ��ѯ��socket�￴accept��read���ῴ.
			//�൱�ڵ���accept()��read()����.
			//�൱�ڸ�����ȥ��ѯ��,���������������,����ν������.
			//����һ����ͬ���ܵķ�����selectnow.
			selector.select();
			
			
			//ע�⵫select()������������,�ڵ���selectedkeys�����Ϳ��Ի�õ����¼���
			//selectkey��,������Ǳ��һ����socketchannel��.
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			
			
			
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();
				// ɾ����ѡ��key,�Է��ظ�����
				iterator.remove();
				
				//���handle���������Ǹ�accept�����Ļ�����read����Ķ��ᴦ��
				//�����key����ȥ�Ϳ���,���selectionkey�������
				
				
				//�������ӵ�,selectionkey������ӳ�䵽socketchanne��,Ҳ����
				//ӳ�䵽serversocketchannel��
				//�����accept�¼�����ѯ�䷢���˷��ص�selectionkeyӳ��ľ���
				//serversocketchannel,���ʱ�������selectionkey��channel������õľ���
				//����accept�¼���serversocketchannel,����read�¼���ʱ��
				//��õľ���socketchannel����
				handler(key);
			}
		}
		
	}
	
    public void handler(SelectionKey key) throws IOException {
		
		
    	//����selectionkey�ķ���isacceptable��isreadable�жϵ���������ʲô�¼�
		if (key.isAcceptable()) {
			handlerAccept(key);
			
		} else if (key.isReadable()) {
			handelerRead(key);
		}
	}
	
    public void handlerAccept(SelectionKey key) throws IOException {
    	
    	
    	//��ͨ��selectkey���serversockethannel
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		
		
		//Ȼ����ͨ��server��accept�����������������scoketchannel
		//Ҳ����accept������.
		SocketChannel channel = server.accept();
		
		//����Ϊ������
		channel.configureBlocking(false);

		
		System.out.println("�µĿͻ�������");
		
		
		//�ٰ����socketchannelע�ᵽselector����ȥֻ�������ע�����read�¼�
		//����˵��ô��socketchannel��Serversocketchannel��ע������
		//���һ��selector��,ֻ����ע����¼�,��ע���ʱ�䲻ͬ
		channel.register(this.selector, SelectionKey.OP_READ);
	}


	public void handelerRead(SelectionKey key) throws IOException {


		
		//ͨ��selectionkey���socketchannel,��ʱ���Ѿ�ȷ��������������
		//��������ȥread֮��Ҳ���Է���
		
		//����������ͨ��socket��serversocket����Ҫ���ʲôin/outputstream��
		//ɶ�Ĳ�ͬ,���ֱ�Ӿ���socketchannel.read��write,�������ؾ���bytebuffer
		//�������ǳ�˵��buffer.
		SocketChannel channel = (SocketChannel) key.channel();
		
		//Ҳ����read������
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int read = channel.read(buffer);
		if(read > 0){
			byte[] data = buffer.array();
			String msg = new String(data).trim();
			System.out.println("������յ���Ϣ��" + msg);
			
			//��д����
			ByteBuffer outBuffer = ByteBuffer.wrap("�õ�".getBytes());
			channel.write(outBuffer);// ����Ϣ���͸��ͻ���
		}else{
			System.out.println("�ͻ��˹ر�");
			
			
			//�������read�¼���lengthΪ0
			//�͵���cancel����ɾ�����key
			key.cancel();
		}
	}


	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(8000);
		server.listen();
	}
	
}
