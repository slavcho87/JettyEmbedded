package iw7i;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

public class HelloWordJetty  extends AbstractHandler {

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<html><body><h2>Hello World!</h2>");
        response.getWriter().println("</body></html>");
	}

	public static void main(String[] args) throws Exception
    {
        Server server;
        
        if(args.length==0){
        	System.err.println("ERROR: Falta el puerto del servidor!");
        	System.exit(0);
        }
        
        server = new Server(Integer.parseInt(args[0]));
        
        server.setHandler(new HelloWordJetty());
        server.start();
        server.join();
    }
}
