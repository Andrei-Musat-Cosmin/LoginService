package it.sincrono.services.utils;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Component;

import it.sincrono.responses.AnagraficaDtoResponse;
import it.sincrono.responses.GenericResponse;

import it.sincrono.responses.*;

import it.sincrono.entity.TipoAzienda;


@Component
public class RestClient {
    private ResteasyClient client;

    public RestClient() {
        client = new ResteasyClientBuilder().build();
    }

    public GenericResponse sendRequest(String url, String method, String requestEntity) {
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
        
        System.out.println("response: "+response.getEntity().getClass());
        
        //System.out.println(" tag: "+response.getEntityTag().getClass());


        GenericResponse responseBody = readEntity(response,method,url);
        response.close();

        return responseBody;
    }
    
    
    private GenericResponse readEntity(Response response,String method,String url) {
    	
    	GenericResponse genericResponse = null;
    	
    	if(method=="POST" || method=="PUT" || method=="DELETE") {
    		
    		genericResponse=response.readEntity(GenericResponse.class);
    		
    	}else {
    		
    		if(url.contains("dettaglio-anagrafica")) {
    			
    			genericResponse=response.readEntity(AnagraficaDtoResponse.class);
    			
    		}else {
    			
    			if(url.contains("anagraficaDto-list")) {
    				
    				genericResponse=response.readEntity(AnagraficaDtoListResponse.class);
    				
    			}else {
    				
    				if(url.contains("dashboard")) {
        				
        				genericResponse=response.readEntity(CommessaDtoListResponse.class);
        				
        			}else {
        				
        				if(url.contains("organico ")) {
            				
            				genericResponse=response.readEntity(OrganicoDtoListResponse.class);
            				
            			}else {
            				
            				
            				if(url.contains("tipo-azienda/map")) {
                				
                				genericResponse=response.readEntity(TipologicheListResponse.class);
                				
                			}else {
                				
                				if(url.contains("tipo-contratto/map")) {
                    				
                    				genericResponse=response.readEntity(TipologicheListResponse.class);
                    			
                    			}else {
                    				
                    				if(url.contains("tipo-contratto-nazionale/map")) {
                        				
                        				genericResponse=response.readEntity(TipologicheListResponse.class);
                        				
                        			}else {
                        				
                        				if(url.contains("tipo-livelli-contrattuali/map")) {
                            				
                            				genericResponse=response.readEntity(TipologicheListResponse.class);
                            				
                            			}
                        				
                        			}
                    				
                    				
                    			}
                				
                			}
            				
            				
            			}
        				
        				
        			}
    				
    			}
    			
    		}
    	}
    	
    	return genericResponse;
    	
    	 
    	
    	
    	
    }

    public void close() {
        client.close();
    }
}
