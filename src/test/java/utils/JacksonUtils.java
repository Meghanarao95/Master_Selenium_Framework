package utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import objects.BillingAddress;

public class JacksonUtils {
	
	
	public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
	    InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
	    if (is == null) {
	        throw new IllegalArgumentException("File not found: " + fileName);
	    }
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.readValue(is, T);
	}


}
