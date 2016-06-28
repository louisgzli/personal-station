package org.xiyuan1223.blog.utils;

import java.lang.reflect.Array;

/**
 * ���鹤����
 * 
 * @author wang.sheng
 * 
 */
public final class ArrayUtils
{
	private ArrayUtils()
	{
	}

	/**
	 * ����ָ�������ͳ��ȹ����������
	 * 
	 * @param clazz
	 * @param length
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArrayInstance(Class<T> clazz, int length)
	{
		return (T[]) Array.newInstance(clazz, length);
	}
}
