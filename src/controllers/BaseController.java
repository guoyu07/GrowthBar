package controllers;

import common.GrowthbarObjects;
import common.model.UserInformation;

import java.util.List;

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

	default <T> boolean isEmptyList(List<T> list) {
		return null == list || list.isEmpty();
	}

}
