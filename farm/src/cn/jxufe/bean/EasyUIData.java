package cn.jxufe.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Easyui数据类
 * @param <T>
 */
public class EasyUIData<T>
{
	/**
	 * 数据总量
	 */
	private long total = 0L;
	
	/**
	 * 数据集合
	 */
	private List<T> rows = new ArrayList<T>();
	
	/**
	 * 获取数据总量
	 * @return long
	 */
	public long getTotal()
	{
		return total;
	}
	
	/**
	 * 设置数据总量
	 * @param total 数据总量
	 */
	public void setTotal(long total)
	{
		this.total = total;
	}
	
	/**
	 * 获取数据集合
	 * @return List
	 */
	public List<T> getRows()
	{
		return rows;
	}
	
	/**
	 * 设置数据集合
	 * @param rows 数据集合
	 */
	public void setRows(List<T> rows)
	{
		this.rows = rows;
	}
}