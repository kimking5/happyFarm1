package cn.jxufe.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.Message;
import cn.jxufe.entity.User;

@Service
public interface UserService
{
	public EasyUIData<User> findSome(Pageable pageable, String name);
	public Message save(User user);
	public Message delete(User user);
}