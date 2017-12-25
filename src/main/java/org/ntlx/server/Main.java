package org.ntlx.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

import java.io.IOException;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;

public class Main {

  public static void main(String args[])
      throws IllegalArgumentException, NullPointerException, IOException {
    Main main = new Main();
    main.startServer();
  }

  public void startServer() throws IllegalArgumentException, NullPointerException, IOException {
    ResourceConfig rc = new PackagesResourceConfig("org.ntlx.service");
    HttpServer myServer = GrizzlyServerFactory.createHttpServer("http://0.0.0.0:9876/calc/", rc);
    HttpHandler httpHandler = new CLStaticHttpHandler(HttpServer.class.getClassLoader(), "/ui/");
    myServer.getServerConfiguration().addHttpHandler(httpHandler, "/");
    try {
      myServer.start();
      Thread.currentThread().join();
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      myServer.stop();
    }
  }
}
