package cc.guoxingnan.mixinan.dao;

import java.util.Map;

import cc.guoxingnan.mixinan.entity.User;

public interface UserDao {
	public void regist(User user);
	public User check(Map map);
	public User getUserById(int id);
	//���name�Ƿ�ռ��
	public int checkNameUsed(String name);
}
