package org.server;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/wsServer")
public class WsServer {
	Session sessions[] = new Session[5];
	int i = 0;
	@OnOpen
	public void OnOpen(Session session) {
		sessions[i] = session;
		System.out.println(sessions[i].toString());  
		++i;
	}
	
	@OnMessage
	public void onMessage(Session ss,byte[] img) {
		ByteBuffer buf = ByteBuffer.wrap(img);
		for (int i = 0; i<sessions.length; ++i){
			try {
				sessions[i].getBasicRemote().sendBinary(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void onClose(Session ss) {
		try {
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
