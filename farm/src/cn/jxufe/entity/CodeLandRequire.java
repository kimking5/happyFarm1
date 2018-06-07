package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;


/** 土地类型解释类
 * 定义一个用于通过代号获取土地类型名称的类。
 * 比如：1对应金土地。
 *@version V1.0
 */
@Entity
@Table(name="T_CodeLandRequire")
@SuppressWarnings("serial")
public class CodeLandRequire extends EntityID
{
	/**
	     土地类型代号
	*/
	private int code;
	/**
	     土地类型名称
    */
	private String caption;
	/**
            获取土地类型代号
    @return int 返回土地类型代号。
	*/
	public int getCode()
	{
		return code;
	}
	/**
            设置土地类型代号
    @param code 用于接收一个int类型的数。
    */
	public void setCode(int code)
	{
		this.code = code;
	}
	/**
           获取土地类型名称
    @return String 返回土地类型名称
    */
	public String getCaption()
	{
		return caption;
	}
	/**
           设置土地类型名称
    @param caption 用于接收一个String类型的值。
    */
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
}