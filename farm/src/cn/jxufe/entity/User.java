package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

/** 用户类
 * 定义用户的属性。
 *@version V1.0
 */
@Entity
@Table(name="T_User")
@SuppressWarnings("serial")
public class User extends EntityID
{
	/**
   头像
*/
	private String headImg;
	/**
    用户名
*/
	private String name;
	/**
    昵称
*/
	private String nickName;
	/**
    经验值
*/
	private int exp;
	/**
    积分
*/
	private int score;
	/**
    金币
*/
	private int goldCoin;
	/**
    获取头像
@return 返回String类型
*/
	public String getHeadImg()
	{
		return headImg;
	}
	/**
    设置头像
@param headImg 用于接收一个String类型的值
*/
	public void setHeadImg(String headImg)
	{
		this.headImg = headImg;
	}
	/**
    获取用户名
@return 返回String类型
*/
	public String getName()
	{
		return name;
	}
	/**
    设置用户名
@param name 用于接收一个String类型的值
*/
	public void setName(String name)
	{
		this.name = name;
	}
	/**
    获取昵称
@return 返回String类型
*/
	public String getNickName()
	{
		return nickName;
	}
	/**
    设置昵称
@param nickName 用于接收一个String类型的值
*/
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	/**
    获取经验值
@return 返回int类型
*/
	public int getExp()
	{
		return exp;
	}
	/**
    设置经验值
@param exp 用于接收一个int类型的值
*/
	public void setExp(int exp)
	{
		this.exp = exp;
	}
	/**
    获取积分
@return 返回int类型
*/
	public int getScore()
	{
		return score;
	}
	/**
    设置积分
@param score 用于接收一个int类型的值
*/
	public void setScore(int score)
	{
		this.score = score;
	}
	/**
    获取金币
@return 返回int类型
*/
	public int getGoldCoin()
	{
		return goldCoin;
	}
	/**
    设置金币
@param goldCoin 用于接收一个int类型的值
*/
	public void setGoldCoin(int goldCoin)
	{
		this.goldCoin = goldCoin;
	}
}