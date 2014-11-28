package com.poshbike.persistance;

public interface UserMapper {

	User findByGuid(String guid);

	void saveUser(User user);

	void updateUser(User user);

	User findByUsername(String username);

}
