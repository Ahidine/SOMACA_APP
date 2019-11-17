package org.Sid.dao;

import org.Sid.entities.roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<roles, String> {

}
