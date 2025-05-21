package oda.sid.tmf.model.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import oda.sid.tmf.model.base.ServiceConstants;
import org.glassfish.jersey.client.ClientProperties;

/**
 *
 * @author bahman.barzideh
 *
 */
public class CatalogClient {

    private CatalogClient() {
    }

    public static Object getObject(String href, Class theClass, int depth) {
        Client client = createClient();
        WebTarget webResource = client.target(href);
        if (depth > ServiceConstants.MINIMUM_DEPTH_VALUE) {
            webResource = webResource.queryParam("depth", String.valueOf(depth));
        }
        
        return webResource.request(MediaType.APPLICATION_JSON).get(theClass);
    }
        
    private static Client createClient() {
        ObjectMapper mapper = new ObjectMapper();
        
        mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper = mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper = mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        
        JacksonJaxbJsonProvider jacksonProvider = new JacksonJaxbJsonProvider();
        jacksonProvider.setMapper(mapper);
        //ClientConfig config = new ClientConfig();
        //config.register(jacksonProvider);
        //Client client = ClientBuilder.newClient(config);
        Client client = ClientBuilder.newClient();
        client.property(ClientProperties.CONNECT_TIMEOUT, 3000);
        client.property(ClientProperties.READ_TIMEOUT, 3000);
        client.register(jacksonProvider);
        return client;
    }

}
