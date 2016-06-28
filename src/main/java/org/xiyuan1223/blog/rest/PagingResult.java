package org.xiyuan1223.blog.rest;

/**
 * ��ҳ��ѯ���
 * 
 * @author wang.sheng
 * 
 */
public class PagingResult<T>
{
	private long total;
	private T[] results;

	public PagingResult(long total, T[] results)
	{
		this.total = total;
		this.results = results;
	}

	public long getTotal()
	{
		return total;
	}

	public void setTotal(long total)
	{
		this.total = total;
	}

	public T[] getResults()
	{
		return results;
	}

	public void setResults(T[] results)
	{
		this.results = results;
	}

}
