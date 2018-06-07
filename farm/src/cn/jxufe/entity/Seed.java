package cn.jxufe.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.jxufe.bean.EntityID;


/** 种子类
 * 定义种子的属性。
 *@version V1.0
 */
@Entity
@Table(name="T_Seed")
@SuppressWarnings("serial")
public class Seed extends EntityID
{
	/**
    种子Id
*/
	private int cId;
	/**
    种子名称
*/
	private String caption;
	/**
    成熟季数
*/
	private int harvestNum;
	/**
    种子等级
*/
	private int cropLevel;
	/**
    种子类型
*/
	private int type;
	/**
    可获经验
*/
	private int exp;
	/**
    成熟时间
	*/
	private int matureTime;
	/**
   每季产量
	*/
	private int output;
	/**
	  采购价
	*/
	private int price;
	/**
	  果实售卖单价
	*/
	private int price4UnitSale;
	/**
	  土地需求
	*/
	private int landRequirement;
	/**
	  种子积分
	*/
	private int score;
	/**
	  种子说明
	*/
	private String tip;
	/**
    获取种子Id
@return 返回int类型
*/
	public int getcId()
	{
		return cId;
	}
	/**
    设置种子Id
@param cId 用于接收一个int类型的值
*/
	public void setcId(int cId)
	{
		this.cId = cId;
	}
	/**
    获取种子名称
@return 返回String类型
*/
	public String getCaption()
	{
		return caption;
	}
	/**
    设置种子名称
@param caption 用于接收一个String类型的值
*/
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	/**
    获取成熟季数
@return 返回intharvestNum类型
*/
	public int getHarvestNum()
	{
		return harvestNum;
	}
	/**
    设置成熟季数
@param harvestNum 用于接收一个int类型的值
*/
	public void setHarvestNum(int harvestNum)
	{
		this.harvestNum = harvestNum;
	}
	/**
    获取种子等级
@return 返回int类型
*/
	public int getCropLevel()
	{
		return cropLevel;
	}
	/**
    设置种子等级
@param cropLevel 用于接收一个int类型的值
*/
	public void setCropLevel(int cropLevel)
	{
		this.cropLevel = cropLevel;
	}
	/**
    获取种子类型
@return 返回int类型
*/
	public int getType()
	{
		return type;
	}
	/**
    设置种子类型
@param type 用于接收一个int类型的值
*/
	public void setType(int type)
	{
		this.type = type;
	}
	/**
    获取种子经验值
@return 返回int类型
*/
	public int getExp()
	{
		return exp;
	}
	/**
    设置种子经验值
@param exp 用于接收一个int类型的值
*/
	public void setExp(int exp)
	{
		this.exp = exp;
	}
	/**
    获取种子成熟时间
@return 返回int类型
*/
	public int getMatureTime()
	{
		return matureTime;
	}
	/**
    设置种子成熟时间
@param matureTime 用于接收一个int类型的值
*/
	public void setMatureTime(int matureTime)
	{
		this.matureTime = matureTime;
	}
	/**
    获取产量
@return 返回int类型
*/
	public int getOutput()
	{
		return output;
	}
	/**
    设置产量
@param output 用于接收一个int类型的值
*/
	public void setOutput(int output)
	{
		this.output = output;
	}
	/**
    获取种子采购价
@return 返回int类型
*/
	public int getPrice()
	{
		return price;
	}
	/**
    设置种子采购价
@param price 用于接收一个int类型的值
*/
	public void setPrice(int price)
	{
		this.price = price;
	}
	/**
    获取种子售卖单价
@return 返回int类型
*/
	public int getPrice4UnitSale()
	{
		return price4UnitSale;
	}
	/**
    设置种子售卖单价
@param price4UnitSale 用于接收一个int类型的值
*/
	public void setPrice4UnitSale(int price4UnitSale)
	{
		this.price4UnitSale = price4UnitSale;
	}
	/**
    获取种子土地需求代号
@return 返回int类型
*/
	public int getLandRequirement()
	{
		return landRequirement;
	}
	/**
    设置种子土地需求代号
@param landRequirement 用于接收一个int类型的值
*/
	public void setLandRequirement(int landRequirement)
	{
		this.landRequirement = landRequirement;
	}
	/**
    获取种子积分
@return 返回int类型
*/
	public int getScore()
	{
		return score;
	}
	/**
    设置种子积分
@param score 用于接收一个int类型的值
*/
	public void setScore(int score)
	{
		this.score = score;
	}
	/**
    获取种子说明
@return 返回String类型
*/
	public String getTip()
	{
		return tip;
	}
	/**
    设置种子说明
@param tip 用于接收一个String类型的值
*/
	public void setTip(String tip)
	{
		this.tip = tip;
	}
}