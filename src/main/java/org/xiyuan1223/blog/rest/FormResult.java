package org.xiyuan1223.blog.rest;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * ���ݱ�����
 * 
 * @author wang.sheng
 * 
 */
  
public class FormResult
{
	private Object data;
	private boolean success;
	private String message;
	private Map<String, String> errors = new HashMap<String, String>();

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void addError(String id, String message)
	{
		errors.put(id, message);
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}

	public boolean hasErrors()
	{
		return !errors.isEmpty();
	}

	/**
	 * ��У���쳣�л�ȡ������Ϣ
	 * 
	 * @param e
	 */
	public void copyErrors(ConstraintViolationException e)
	{
		if (e != null)
		{
			for (ConstraintViolation<?> constrainViolation : e.getConstraintViolations())
			{
				this.addError(constrainViolation.getPropertyPath().toString(), constrainViolation.getMessage());
			}
		}
	}

	/**
	 * ��SpringMVC��ܵ�BindingResult�����л�ȡ������Ϣ
	 * 
	 * @param bindingResult
	 */
	public void copyErrors(BindingResult bindingResult)
	{
		if (bindingResult != null && bindingResult.hasErrors())
		{
			for (FieldError fieldError : bindingResult.getFieldErrors())
			{
				this.addError(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
	}
/**
 * ��дstring����������û�л�ȡ��
 */
	@Override
	public  String toString (){
		return 
				this.data.toString();
		
	}
}
