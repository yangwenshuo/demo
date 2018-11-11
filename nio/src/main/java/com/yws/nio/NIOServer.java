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

	//定义一个通道轮询器
	private Selector selector;
	
	public void initServer(int port) throws IOException {
		//由于是服务端我么创建一个ServerSocketChannel对象,
		//就像是在tcp那里服务端创建sokcetchannel对象
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//注意这个是用ServerSocketChannel类的open方法创建对象
		
		
		//注意这个要把这个serversocketchannel设置成非阻塞的
		serverSocketChannel.configureBlocking(false);
		
		//绑定服务端监听的端口
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		
		
		//用Selector的open方法创建一个selector对象
		this.selector = Selector.open();
		
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		//注意这个init方法就是创建serersocketchannel和selector
		//然后通过serversocketchannel的register将轮询器selector绑定到这个serversocketchannel
	}
	
	
	
	public void listen() throws IOException {
		
		while(true) {
			
			
			//注意这个方法的意思是selector去轮询的socket里看accept和read都会看.
			//相当于调用accept()和read()方法.
			//相当于复用器去轮询了,这个方法是阻塞的,无所谓了阻塞.
			//还有一个相同功能的方法是selectnow.
			selector.select();
			
			
			//注意但select()方法不阻塞后,在调用selectedkeys方法就可以获得到有事件的
			//selectkey了,这个就是标记一个个socketchannel的.
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			
			
			
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();
				// 删除已选的key,以防重复处理
				iterator.remove();
				
				//这个handle方法无论是刚accept上来的还是有read请求的都会处理
				//把这个key传进去就可以,这个selectionkey对象就是
				
				
				//是这样子的,selectionkey即可以映射到socketchanne上,也可以
				//映射到serversocketchannel上
				//如果是accept事件被轮询其发现了返回的selectionkey映射的就是
				//serversocketchannel,这个时候你调用selectionkey的channel方法获得的就是
				//发生accept事件的serversocketchannel,发生read事件的时候
				//获得的就是socketchannel方法
				handler(key);
			}
		}
		
	}
	
    public void handler(SelectionKey key) throws IOException {
		
		
    	//根据selectionkey的方法isacceptable和isreadable判断到底是来了什么事件
		if (key.isAcceptable()) {
			handlerAccept(key);
			
		} else if (key.isReadable()) {
			handelerRead(key);
		}
	}
	
    public void handlerAccept(SelectionKey key) throws IOException {
    	
    	
    	//先通过selectkey获得serversockethannel
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		
		
		//然后再通过server的accept方法获得链接上来的scoketchannel
		//也是有accept方法的.
		SocketChannel channel = server.accept();
		
		//设置为非阻塞
		channel.configureBlocking(false);

		
		System.out.println("新的客户端连接");
		
		
		//再把这个socketchannel注册到selector里面去只不过这个注册的是read事件
		//所以说我么的socketchannel和Serversocketchannel都注册在了
		//这个一个selector上,只不过注册的事件,和注册的时间不同
		channel.register(this.selector, SelectionKey.OP_READ);
	}


	public void handelerRead(SelectionKey key) throws IOException {


		
		//通过selectionkey获得socketchannel,这时候已经确定是有请求来了
		//所以我们去read之后也可以返回
		
		//这个相比于普通的socket和serversocket都需要获得什么in/outputstream流
		//啥的不同,这个直接就是socketchannel.read和write,而参数呢就是bytebuffer
		//就是我们常说的buffer.
		SocketChannel channel = (SocketChannel) key.channel();
		
		//也是有read方法的
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int read = channel.read(buffer);
		if(read > 0){
			byte[] data = buffer.array();
			String msg = new String(data).trim();
			System.out.println("服务端收到信息：" + msg);
			
			//回写数据
			ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes());
			channel.write(outBuffer);// 将消息回送给客户端
		}else{
			System.out.println("客户端关闭");
			
			
			//如果发现read事件的length为0
			//就调用cancel方法删除这个key
			key.cancel();
		}
	}


	public static void main(String[] args) throws IOException {
		NIOServer server = new NIOServer();
		server.initServer(8000);
		server.listen();
	}
	
}
