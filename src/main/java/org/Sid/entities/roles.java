package org.Sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class roles implements Serializable{


	public Collection<users> getUser() {
		return user;
	}

	public void setUser(Collection<users> user) {
		this.user = user;
	}

	@Id
   private String role;
	@OneToMany(mappedBy = "roles")
	Collection<users> user;

   public String getRole() {
       return role;
   }

   public void setRole(String role) {
       this.role = role;
   }

   public roles() {
   }

   public roles(String role) {
       this.role = role;
   }

}