package it.sincrono.services.utils;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;


@Component
public class RestClient {
    private ResteasyClient client;

    public RestClient() {
        client = new ResteasyClientBuilder().build();
    }

    public String sendRequest(String url, String method, String requestEntity) {
        ResteasyWebTarget target = client.target(url);

        Invocation.Builder builder = target.request();
        
        Response response;
        switch (method.toUpperCase()) {
            case "GET":
                response = builder.get();
                break;
            case "POST":
                response = builder.post(Entity.json(requestEntity));
                break;
            case "PUT":
                response = builder.put(Entity.json(requestEntity));
                break;
            case "DELETE":
                response = builder.delete();
                break;
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }

        if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            throw new RuntimeException("HTTP error code: " + response.getStatus());
        }

        String responseBody = response.readEntity(String.class);
        response.close();

        return responseBody;
    }

    public void close() {
        client.close();
    }
}
