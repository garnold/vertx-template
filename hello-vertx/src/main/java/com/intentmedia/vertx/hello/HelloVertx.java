package com.intentmedia.vertx.hello;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

public class HelloVertx extends Verticle {

    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            public void handle(HttpServerRequest request) {
                request.response().putHeader("Content-Type", "text/plain");
                request.response().setChunked(true);
                request.response().end("Hello, Vertx!");
            }
        }).listen(8080);
    }
}
