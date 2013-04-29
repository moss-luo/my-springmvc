package com.ittbank.restful.util.json;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.ittbank.restful.util.TemplateResult;

public class HttpStatusWithJsonView extends MappingJacksonJsonView {
	
	private JsonEncoding encoding = JsonEncoding.UTF8;
	private ObjectMapper objectMapper = new ObjectMapper();
	private boolean prefixJson = false;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		Object value = filterModel(model);
		JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), encoding);
		if (prefixJson) {
			generator.writeRaw("{} && ");
		}
		if(check(value)){
			TemplateResult tm = (TemplateResult)value;
			response.setStatus(tm.getHttpStatus());
			value = tm.getModel();
		}
		
		objectMapper.writeValue(generator, value);
	}

	@Override
	protected Object filterModel(Map<String, Object> model) {
		 Map<?, ?> result = (Map<?, ?>) super.filterModel(model);  
	        if (result.size() == 1) {  
	            return result.values().iterator().next();  
	        } else {  
	            return result;  
	        }  
	}
	
	protected boolean check(Object obj) {
		return obj instanceof TemplateResult;
	}
	
	public void setEncoding(JsonEncoding encoding) {
		Assert.notNull(encoding, "'encoding' must not be null");
		this.encoding = encoding;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public void setPrefixJson(boolean prefixJson) {
		this.prefixJson = prefixJson;
	}

	
}
