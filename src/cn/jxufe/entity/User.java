package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

@Entity
@Table(name="T_User")
@SuppressWarnings("serial")
public class User extends EntityID
{
	private String headImg;
	private String name;
	private String nickName;
	private int exp;
	private int score;
	private int goldCoin;
	
	public String getHeadImg()
	{
		return headImg;
	}

	public void setHeadImg(String headImg)
	{
		this.headImg = headImg;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getNickName()
	{
		return nickName;
	}
	
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public void setExp(int exp)
	{
		this.exp = exp;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	public int getGoldCoin()
	{
		return goldCoin;
	}
	
	public void setGoldCoin(int goldCoin)
	{
		this.goldCoin = goldCoin;
	}
}