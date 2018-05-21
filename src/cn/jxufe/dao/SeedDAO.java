package cn.jxufe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.jxufe.entity.Seed;

public interface SeedDAO extends PagingAndSortingRepository<Seed, Long>
{
	public Page<Seed> findByCaptionContaining(Pageable pageable, String caption);
}