package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

/**
 * 种子背包信息
 */
@Entity
@Table(name="T_SeedBag")
@SuppressWarnings("serial")
public class SeedBag extends EntityID
{
	/**
	 * 种子背包用户的用户名
	 */
	private String userName;
	
	/**
	 * 种子id
	 */
	private int cId;
	
	/**
	 * 种子数量
	 */
	private int seedNum;
	
	/**
	 * 获取种子背包用户的用户名
	 * @return String
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * 设置种子背包用户的用户名
	 * @param userName String类型的用户名
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * 获取种子id
	 * @return int
	 */
	public int getcId()
	{
		return cId;
	}

	/**
	 * 设置种子背包用户的用户名
	 * @param cId int类型的种子id
	 */
	public void setcId(int cId)
	{
		this.cId = cId;
	}

	/**
	 * 获取用户种子背包中的种子数量
	 * @return int
	 */
	public int getSeedNum()
	{
		return seedNum;
	}
	
	/**
	 * 设置用户种子背包中的种子数量
	 * @param seedNum int类型的种子数量
	 */
	public void setSeedNum(int seedNum)
	{
		this.seedNum = seedNum;
	}
}