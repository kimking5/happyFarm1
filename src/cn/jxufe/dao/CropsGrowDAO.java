package cn.jxufe.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.jxufe.entity.CropsGrow;

public interface CropsGrowDAO extends JpaRepository<CropsGrow, Long>
{
	public List<CropsGrow> findByCId(int cId, Sort sort);
}