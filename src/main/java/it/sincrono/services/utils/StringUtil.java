package it.sincrono.services.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	public String modifiedPath(String path) {

		int index = path.indexOf("/services");

		String modifiedUrl = null;

		if (index != -1) {
			modifiedUrl = path.substring(index);

		}

		return modifiedUrl;
	}

}
