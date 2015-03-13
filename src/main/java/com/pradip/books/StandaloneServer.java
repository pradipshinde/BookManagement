package com.pradip.books;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;

/**
 * Created by Pradip on 2/21/15.
 */
public class StandaloneServer extends Server {

    @Override
    public boolean getFileCacheEnabled() {
        return true;
    }

    @Override
    public HttpHandler getHttpHandler() {
        return new CLStaticHttpHandler(StandaloneServer.class.getClassLoader(), "webapp/");
    }
}
