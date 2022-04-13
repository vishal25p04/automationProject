package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public ResponseSpecification resSpec;
	
	public RequestSpecification reqSpecification() throws IOException {
		if(req!=null)
			return req;
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).
			addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).
			addFilter(RequestLoggingFilter.logRequestTo(log)). 
			addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
	}
	
	public ResponseSpecification resSpecification() {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).
				expectStatusCode(200).build();
		return resSpec;
	}
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vishal\\Documents\\GitHub\\automationProject\\RestAPIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
