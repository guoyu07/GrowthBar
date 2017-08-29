package controllers;

import common.GrowthbarObjects;

/**
 * Version:v1.0 (description:  )
 */
public interface BaseController extends GrowthbarObjects {

	default boolean isEmptyInteger(Integer number) {
		return null == number || number.equals(ZERO_INT);
	}

	default boolean isEmptyString(String str) {
		return null == str || NULL_STRING.equals(str);
	}

}
