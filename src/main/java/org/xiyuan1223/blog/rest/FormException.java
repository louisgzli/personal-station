 package org.xiyuan1223.blog.rest;

/**
 * �������쳣
 * 
 * @author wang.sheng
 * 
 */
public class FormException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public FormException(String msg)
	{
		super(msg);
	}

	public FormException(String msg, Throwable cause)
	{
		super(msg, cause);
	}
}
