package com.pradip.books;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Created by Pradip on 2/10/2015.
 */
public class Server {

    public static final String BASE_API_URI="http://localhost:8080/api/";

    public boolean getFileCacheEnabled()
    {
        return false;
    }

    public static void main(String args[]) throws Exception
    {
        Server server=new Server();
        final HttpServer httpServer=server.startServer();
        System.out.println("Press Enter to stop the Server");
        System.in.read();
        httpServer.shutdown();

    }

    public HttpServer startServer(){

        final ResourceConfig resourceConfig=new ResourceConfig().packages("com.pradip.books");
        HttpServer httpServer=GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_API_URI), resourceConfig);
        httpServer.getServerConfiguration().addHttpHandler(getHttpHandler(),"/page");
        return httpServer;

    }

    public HttpHandler getHttpHandler()
    {
        StaticHttpHandler staticHttpHandler=new StaticHttpHandler("src/main/resources/webapp/");
        staticHttpHandler.setFileCacheEnabled(getFileCacheEnabled());
        return staticHttpHandler;
    }
}
