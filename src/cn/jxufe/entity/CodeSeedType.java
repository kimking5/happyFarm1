package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

@Entity
@Table(name="T_CodeSeedType")
@SuppressWarnings("serial")
public class CodeSeedType extends EntityID
{
	private int code;
	private String caption;
	
	public int getCode()
	{
		return code;
	}
	
	public void setCode(int code)
	{
		this.code = code;
	}
	
	public String getCaption()
	{
		return caption;
	}
	
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
}