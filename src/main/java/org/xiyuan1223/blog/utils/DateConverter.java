package org.xiyuan1223.blog.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * ÈÕÆÚ×ª»»Æ÷
 * 
 * @author wang.sheng
 * 
 */
@Service
public class DateConverter implements Converter<String, Date>
{
	Log log = LogFactory.getLog(getClass());

	private static String[] DATE_FORMATS = new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss" };

	public Date convert(String source)
	{
		try
		{
			if (StringUtils.isEmpty(source) || source.equalsIgnoreCase("null"))
			{
				return null;
			}
			return DateUtils.parseDate(source, DATE_FORMATS);
		}
		catch (ParseException e)
		{
			log.error("parseDate failed! source=" + source, e);
			return null;
		}
	}
}