package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

/**
 * 种子类型实体类
 */
@Entity
@Table(name="T_CodeSeedType")
@SuppressWarnings("serial")
public class CodeSeedType extends EntityID
{
	/**
	 * 种子类型ID
	 */
	private int code;
	
	/**
	 * 种子类型名称
	 */
	private String caption;
	
	/**
	 * 获取种子类型ID
	 * @return int
	 */
	public int getCode()
	{
		return code;
	}
	
	/**
	 * 设置获取种子类型ID
	 * @param code 新的种子ID
	 */
	public void setCode(int code)
	{
		this.code = code;
	}
	
	/**
	 * 获取种子类型名称
	 * @return String
	 */
	public String getCaption()
	{
		return caption;
	}
	
	/**
	 * 设置种子类型名称
	 * @param caption 新的种子名称
	 */
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
}