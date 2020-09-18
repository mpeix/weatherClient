package training.weather.clients;
import java.io.IOException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class RequestClient {

    private HttpRequestFactory _requestFactory;

    /**
     * Constructor
     */
    public RequestClient(){
        _requestFactory = new NetHttpTransport().createRequestFactory();
    }

    /**
     * Performs a get request to given URL
     * @param url uri to call
     * @return A String containing the response from http get
     * @throws IOException
     */
    public String Get(String url) throws IOException {
        return  _requestFactory.buildGetRequest(new GenericUrl(url)).execute().parseAsString();
    }
}
