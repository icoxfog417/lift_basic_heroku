import org.eclipse.jetty.server.handler.ContextHandler
import org.eclipse.jetty.server.ServerConnector
import org.eclipse.jetty.server.{Handler, Server}
import org.eclipse.jetty.webapp.WebAppContext

object LiftUp extends App{
  val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

  val server = new Server
  val sc = new ServerConnector(server)
  sc.setPort(port)
  server.setConnectors(Array(sc))

  val context = new WebAppContext()
  context.setServer(server)
  context.setWar("src/main/webapp")
  context.setContextPath("/")

  val context0: ContextHandler = new ContextHandler();
  context0.setHandler(context)
  server.setHandler(context0)

  server.start()
  server.join()

}
