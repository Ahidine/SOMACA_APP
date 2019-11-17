package org.Sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class users  implements Serializable{
	@Id
   @Column(name = "username", unique = true)
   private String username;
   @Column(name = "password")
   private String password;
   @OneToOne(mappedBy = "user")







public boolean isBlocked() {
	return isBlocked;
}



public void setBlocked(boolean isBlocked) {
	this.isBlocked = isBlocked;
}



private boolean isBlocked =false;


@ManyToOne
@JoinColumn(name="user_id")
   private roles roles;



   public String getUsername() {
       return username;
   }



   public void setUsername(String username) {
       this.username = username;
   }



   public String getPassword() {
       return password;
   }



   public void setPassword(String password) {
       this.password = password;
   }



   public roles getRoles() {
       return roles;
   }



   public void setRoles(roles  roles) {
       this.roles = roles;
   }



   public users(String username, String password, roles  roles) {
      
       this.username = username;
       this.password = password;
       this.roles = roles;
   }



   public users() {
       super();
   }
}