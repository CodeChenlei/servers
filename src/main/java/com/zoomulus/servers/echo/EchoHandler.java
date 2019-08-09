package com.zoomulus.servers.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Netty with http:http://www.seepingmatter.com/2016/03/30/a-simple-standalone-http-server-with-netty.html
 * https://medium.com/@irunika/how-to-write-a-http-websocket-server-using-netty-f3c136adcba9
 */
public class EchoHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ctx.write((ByteBuf) msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	}
}
