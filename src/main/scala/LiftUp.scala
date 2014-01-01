
<!-- saved from url=(0086)https://raw.github.com/icoxfog417/lift_basic_heroku/master/src/main/scala/LiftUp.scala -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">import org.eclipse.jetty.server.handler.ContextHandler
import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.{Handler, Server}
import org.eclipse.jetty.webapp.WebAppContext

import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector
import net.liftweb.http.LiftFilter
import java.util.EnumSet
import javax.servlet.DispatcherType

object LiftUp extends App{
  val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080
  
  val server = new Server
  val scc = new SelectChannelConnector
  scc.setPort(port)
  server.setConnectors(Array(scc))

  val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)

  context.addServlet(classOf[DefaultServlet], "/");
  context.addFilter(classOf[LiftFilter], "/*", EnumSet.of(DispatcherType.REQUEST))
  context.setResourceBase("src/main/webapp")

  server.setHandler(context);

  server.start()
  server.join()

}
</pre></body></html>