package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;

/**
 * 种子成长阶段实体类
 */
@Entity
@Table(name="T_CropsGrow")
@SuppressWarnings("serial")
public class CropsGrow extends EntityID
{
	/**
	 * 种子id
	 */
	private int cId;
	
	/**
	 * 种子阶段成长时间
	 */
	private int growTime;
	
	/**
	 * 种子成长阶段
	 */
	private int growStep;
	
	/**
	 * 种子成长阶段标题
	 */
	private String growCaption;
	
	/**
	 * 生虫概率
	 */
	private float insect;
	
	/**
	 * 宽度
	 */
	private int width;
	
	/**
	 * 高度
	 */
	private int height;
	
	/**
	 * offsetX
	 */
	private int offsetX;
	
	/**
	 * offsetY
	 */
	private int offsetY;
	
	/**
	 * 作物状态
	 */
	private int status;
	
	/**
	 * 获取种子ID
	 * @return int
	 */
	public int getcId()
	{
		return cId;
	}
	
	/**
	 * 设置种子id
	 * @param cId 新的种子id
	 */
	public void setcId(int cId)
	{
		this.cId = cId;
	}
	
	/**
	 * 获取种子阶段成长时间
	 * @return int
	 */
	public int getGrowTime()
	{
		return growTime;
	}
	
	/**
	 * 设置种子阶段成长时间
	 * @param growTime 新的种子阶段成长时间
	 */
	public void setGrowTime(int growTime)
	{
		this.growTime = growTime;
	}
	
	/**
	 * 获取种子成长阶段
	 * @return int
	 */
	public int getGrowStep()
	{
		return growStep;
	}
	
	/**
	 * 设置种子成长阶段
	 * @param growStep 新的种子成长阶段
	 */
	public void setGrowStep(int growStep)
	{
		this.growStep = growStep;
	}
	
	/**
	 * 获取种子成长阶段标题
	 * @return String
	 */
	public String getGrowCaption()
	{
		return growCaption;
	}
	
	/**
	 * 设置种子成长阶段标题
	 * @param growCaption 新的种子成长阶段标题
	 */
	public void setGrowCaption(String growCaption)
	{
		this.growCaption = growCaption;
	}
	
	/**
	 * 获取生虫概率
	 * @return float
	 */
	public float getInsect()
	{
		return insect;
	}
	
	/**
	 * 设置种子生虫概率
	 * @param insect 新的生虫概率
	 */
	public void setInsect(float insect)
	{
		this.insect = insect;
	}
	
	/**
	 * 获取宽度
	 * @return int
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * 设置宽度
	 * @param width 新的宽度
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * 获取高度
	 * @return int
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * 设置高度
	 * @param height 新的宽度
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * 获取offsetX
	 * @return int
	 */
	public int getOffsetX()
	{
		return offsetX;
	}
	
	/**
	 * 设置offsetX
	 * @param offsetX 新的offsetX
	 */
	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}
	
	/**
	 * 获取offsetY
	 * @return int
	 */
	public int getOffsetY()
	{
		return offsetY;
	}
	
	/**
	 * 设置offsetY
	 * @param offsetY 新的offsetY
	 */
	public void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}
	
	/**
	 * 获取作物状态
	 * @return int
	 */
	public int getStatus()
	{
		return status;
	}
	
	/**
	 * 设置作物状态
	 * @param status 新的status
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
}