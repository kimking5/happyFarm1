package cn.jxufe.bean;

/**
 * 消息实体类
 */
public class Message
{
	/**
	 * 消息代码
	 */
	private int code;
	
	/**
	 * 消息信息
	 */
	private String msg;
	
	/**
	 * 获取消息代码
	 * @return int
	 */
	public int getCode()
	{
		return code;
	}
	
	/**
	 * 设置消息代码
	 * @param code int
	 */
	public void setCode(int code)
	{
		this.code = code;
	}
	
	/**
	 * 获取消息信息
	 * @return String
	 */
	public String getMsg()
	{
		return msg;
	}
	
	/**
	 * 设置消息信息
	 * @param msg String
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}