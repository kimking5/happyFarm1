package cn.jxufe.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import cn.jxufe.entity.CodeCropStatus;

/** 作物状态数据库接口类
 *@version V1.0
 */
public interface CodeCropStatusDAO  extends PagingAndSortingRepository<CodeCropStatus, Long>
{
	
}