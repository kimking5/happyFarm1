package cn.jxufe.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import cn.jxufe.bean.Message;
import cn.jxufe.entity.CropsGrow;

public interface CropsGrowService
{
	public List<CropsGrow> findSome(int cId, Sort sort);
	public Message save(CropsGrow cropsGrow);
	public Message delete(CropsGrow cropsGrow);
}