package cn.jxufe.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import cn.jxufe.entity.CodeSeedType;

/** 种子类型数据库接口类
 *@version V1.0
 */
public interface CodeSeedTypeDAO extends PagingAndSortingRepository<CodeSeedType, Long>
{

}