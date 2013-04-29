package com.ittbank.restful.util.json.adaptor;

public interface DataOutputAdaptorProvider {
	void init();
	DataOutputAdaptor getAdaptor(String type);
}
