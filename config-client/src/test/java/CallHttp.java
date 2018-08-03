import java.text.MessageFormat;
import java.util.Map;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

public class CallHttp {

	public static void main(String[] args) {
		BasicAuthorizationInterceptor ss = new BasicAuthorizationInterceptor(
				"", "");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(ss);
		String url = "http://localhost:8888/application/test/master";
		ResponseEntity<Environment> responseEntity = restTemplate.getForEntity(
				url, Environment.class);
		Environment environment = responseEntity.getBody();
		for (PropertySource propertySource : environment.getPropertySources()) {
			Map<String, Object> map = (Map<String, Object>) propertySource
					.getSource();
			for (String key : map.keySet()) {
				System.out.println(MessageFormat.format("{0}={1}", key,
						map.get(key)));
			}
		}
		System.out.println("$$$");
	}
}
