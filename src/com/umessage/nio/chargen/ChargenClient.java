package com.umessage.nio.chargen;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Chargen客户端，打开与服务器的连接，等待服务器的输入，并将输入的内容打印到标准输出上。
 * 
 * @author licb
 * 
 */
public class ChargenClient {
	// 默认应该是19,但是改端口需要使用root运行，所以这里选择一个大的端口号
	public static int DEFAULT_PORT = 9999;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SocketAddress remote = new InetSocketAddress("localhost", DEFAULT_PORT);
		try {
			SocketChannel client = SocketChannel.open(remote);

			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel out = Channels.newChannel(System.out);

			// while (client.read(buffer) != -1) {
			// buffer.flip();
			// out.write(buffer);
			// buffer.clear();
			// }

			while (true) {
				int n = client.read(buffer);
				if (n > 0) {
					buffer.flip();
					out.write(buffer);
					buffer.clear();
				} else if (n == -1) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
