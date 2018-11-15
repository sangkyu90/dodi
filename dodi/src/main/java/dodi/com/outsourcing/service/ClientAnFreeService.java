package dodi.com.outsourcing.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface ClientAnFreeService {
	public Integer cfInsert(Map<String,String> m) throws IllegalAccessException, InvocationTargetException;
	public Integer cfUpdate(Map<String,String> m) throws IllegalAccessException, InvocationTargetException;
	public Map<String,String> cfGet(Integer memberNum);
}
