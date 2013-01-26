package vcap.router;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;

import java.net.InetSocketAddress;

/**
 * @author Mike Heath <heathma@ldschurch.org>
 */
public class TestHttpClient {

	public static void main(String[] args) {
	}

}
