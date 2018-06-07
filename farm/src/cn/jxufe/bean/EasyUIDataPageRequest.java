package cn.jxufe.bean;

/**
 * Easyui数据分页请求
 */
public class EasyUIDataPageRequest
{
	/**
	 * 页数
	 */
	private int page = 1;
	
	/**
	 * 数据行数
	 */
	private int rows = 1;
	
	/**
	 * 数据排序依据，默认为id
	 */
	private String sort = "id";
	
	/**
	 * 排序顺序，asc: 升序，desc：降序，默认为asc
	 */
	private String order ="asc";
	
	/**
	 * 获取数据页数
	 * @return int
	 */
	public int getPage()
	{
		return page;
	}
	
	/**
	 * 设置数据页数
	 * @param page int
	 */
	public void setPage(int page)
	{
		this.page = page;
	}
	
	/**
	 * 获取数据行数
	 * @return int
	 */
	public int getRows()
	{
		return rows;
	}
	
	/**
	 * 设置数据行数
	 * @param rows int
	 */
	public void setRows(int rows)
	{
		this.rows = rows;
	}
	
	/**
	 * 获取排序依据
	 * @return String
	 */
	public String getSort()
	{
		return sort;
	}
	
	/**
	 * 设置数据排序依据
	 * @param sort String
	 */
	public void setSort(String sort)
	{
		this.sort = sort;
	}
	
	/**
	 * 获取排序顺序
	 * @return String
	 */
	public String getOrder()
	{
		return order;
	}
	
	/**
	 * 设置数据排序顺序
	 * @param sort String
	 */
	public void setOrder(String order)
	{
		this.order = order;
	}
}