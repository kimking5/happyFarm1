package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

/** 作物状态解释类
 * 定义一个用于通过代号获取作物状态的类。
 * 比如：1对应种子阶段。
 *@version V1.0
 */
@Entity
@Table(name="T_CodeCropStatus")
@SuppressWarnings("serial")
public class CodeCropStatus extends EntityID
{
	/**
    作物状态代号
*/
	private int code;
	/**
    作物状态描述
*/
	private String caption;
	/**
    获取作物状态代号
@return 返回int值
*/
	public int getCode()
	{
		return code;
	}
	/**
    设置作物状态代号
@param code 用于接收一个int类型的值
*/
	public void setCode(int code)
	{
		this.code = code;
	}
	/**
    获取作物状态描述
@return 返回String值
*/
	public String getCaption()
	{
		return caption;
	}
	/**
    设置作物状态描述
@param caption 用于接收一个int类型的值
*/
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
}