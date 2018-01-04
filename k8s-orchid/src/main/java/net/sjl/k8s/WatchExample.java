package net.sjl.k8s;

import com.google.gson.reflect.TypeToken;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.apis.CoreApi;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1APIVersions;
import io.kubernetes.client.models.V1APIGroupList;
import io.kubernetes.client.models.V1NamespaceList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.Watch;
import io.kubernetes.client.auth.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WatchExample {
    public static void main(String[] args) throws IOException, ApiException{
      ApiClient client = Config.defaultClient();
      client.getHttpClient().setReadTimeout(60, TimeUnit.SECONDS);
      Configuration.setDefaultApiClient(client);

      CoreApi api = new CoreApi();
      // CoreApi apiInstance = new CoreApi();
      try {
        V1APIVersions result = api.getAPIVersions();
        // V1APIVersions result = apiInstance.getAPIVersions();
        System.out.println(result);
      } catch (ApiException e) {
        System.err.println("Exception when calling CoreApi#getAPIVersions");
        e.printStackTrace();
      }

      CoreV1Api apiInstance = new CoreV1Api();
      
      try {
        // 1.0-beta2
        // V1NamespaceList result = apiInstance.listNamespace(null, null, null, true, null, 56, null, 30, true);
        V1NamespaceList result = apiInstance.listNamespace(null, null, null, true, null, 56, null, 30, true);
        // V1NamespaceList result = apiInstance.listNamespace(null, null, null, null, 56, true);
        System.out.println(result);
      } catch (ApiException e) {
        System.err.println("Exception when calling CoreV1Api#listNamespace");
        e.printStackTrace();
      }

      Watch<V1Namespace> watch = Watch.createWatch(
        client,
        // apiInstance.listNamespaceCall(null, null, null, null, 5, Boolean.TRUE, null, null),
                apiInstance.listNamespaceCall(null, null, null, Boolean.TRUE, null, 200, null, 5, Boolean.TRUE, null, null),
                // apiInstance.listNamespaceCall(null, null, null, true, null, 56, null, 30, true, null, null),
                // apiInstance.listNamespaceCall(null, null, null, null, null, 5, null, null, Boolean.TRUE, null, null),
                new TypeToken<Watch.Response<V1Namespace>>(){}.getType());

      for (Watch.Response<V1Namespace> item : watch) {
         System.out.printf("%s : %s%n", item.type, item.object.getMetadata().getName());
      }
    }
}
