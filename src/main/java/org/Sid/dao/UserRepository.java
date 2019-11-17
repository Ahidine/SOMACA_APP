package org.Sid.dao;

import org.Sid.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<users, String>  {
	public users findByUsername(String username);
}
