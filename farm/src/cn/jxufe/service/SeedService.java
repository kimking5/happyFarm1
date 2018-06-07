package cn.jxufe.service;

import org.springframework.data.domain.Pageable;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.Message;
import cn.jxufe.entity.Seed;

/**
 * 种子的业务逻辑处理接口
 */
public interface SeedService
{
	/**
	 * @param pageable 分页
	 * @param caption 种子名称
	 * @return Seed实体
	 */
	public EasyUIData<Seed> findSome(Pageable pageable, String caption);
	
	/**
	 * @param seed 需要保存的种子实体
	 * @return Message
	 */
    public Message save(Seed seed);
    
    /**
	 * @param seed 需要删除的种子实体
	 * @return Message
	 */
    public Message delete(Seed seed);
}