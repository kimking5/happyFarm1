package cn.jxufe.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 实体类Id
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class EntityID implements Serializable
{
	/**
	 * 实体类id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false,columnDefinition="long default 0")
	private long id;

	/**
	 * 获取id
	 * @return long
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * 设置id
	 * @param id long
	 */
	public void setId(long id)
	{
		this.id = id;
	}
}