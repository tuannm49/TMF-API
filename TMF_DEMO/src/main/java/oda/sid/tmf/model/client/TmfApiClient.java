/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oda.sid.tmf.model.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

import java.util.Collections;
import java.util.List;

public class TmfApiClient<T> {
    private final Client client;
    private final String baseUri = "http://api.example.com/tmf/v4";
    private final Class<T> entityClass;

    public TmfApiClient(Class<T> entityClass) {
        this.entityClass = entityClass;
        ClientConfig config = new ClientConfig();
        this.client = ClientBuilder.newClient(config);
    }

    public T getById(String id, String fields) {
        WebTarget target = client.target(baseUri)
                .path("/{id}")
                .resolveTemplate("id", id);

        if (fields != null && !fields.isEmpty()) {
            target = target.queryParam("fields", fields);
        }

        Response response = target.request(MediaType.APPLICATION_JSON).get();

        if (response.getStatus() == 200) {
            return response.readEntity(entityClass);
        } else {
            throw new RuntimeException("Failed to get : " + response.getStatus());
        }
    }

    public T create(T entity) {
        WebTarget target = client.target(baseUri);

        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 201) {
            return response.readEntity(entityClass);
        } else {
            throw new RuntimeException("Failed to create : " + response.getStatus());
        }
    }

    public T update(String id, T entity) {
        WebTarget target = client.target(baseUri)
                .path("/{id}")
                .resolveTemplate("id", id);

        Response response = target.request(MediaType.APPLICATION_JSON)
                .method("PATCH", Entity.entity(entity, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200) {
            return response.readEntity(entityClass);
        } else {
            throw new RuntimeException("Failed to update : " + response.getStatus());
        }
    }

    public List<T> findAll(String filter, String fields) {
        WebTarget target = client.target(baseUri);

        if (filter != null && !filter.isEmpty()) {
            target = target.queryParam("filter", filter);
        }
        if (fields != null && !fields.isEmpty()) {
            target = target.queryParam("fields", fields);
        }

        Response response = target.request(MediaType.APPLICATION_JSON).get();

        if (response.getStatus() == 200) {
            return Collections.singletonList(response.readEntity(entityClass));
        } else {
            throw new RuntimeException("Failed to list : " + response.getStatus());
        }
    }

    public void close() {
        client.close();
    }

}
