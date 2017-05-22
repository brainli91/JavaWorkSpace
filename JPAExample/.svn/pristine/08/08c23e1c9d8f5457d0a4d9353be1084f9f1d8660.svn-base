package com.fdmgroup.model;
//Always import from javax.persistence
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;






import com.fdmgroup.util.IDGenerator;

@Entity
@Table(name = "JPA_USER")
@NamedQueries({
	@NamedQuery(name = "user.findAll", query ="SELECT u FROM User u"),
	@NamedQuery(name = "user.findByUsername", query ="SELECT u FROM User u WHERE u.userName = :uname"),
	
})

public class User {

		@Column
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		private long id ;
		@Column(length = 30,nullable = false)//(name = "user_name")
		private String userName;
		
		@Column(length = 30,nullable = false)
		private String password;
		
		@Embedded
		private Profile profile;
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Set<Role> roles;
		
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private Company company;
		
		//Using annotation transient to Ignore the column
		//@Transient
		//private String temp;

		


		public Set<Role> getRoles() {
			return roles;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}

		public User() {
			super();
		}

		public User(String userName, String password) {
			super();
			this.id = IDGenerator.generate();
			
			this.userName = userName;
			this.password = password;
		}
		
		
		
		public User(String userName, String password, Profile profile) {
			super();
			this.id = IDGenerator.generate();
			this.userName = userName;
			this.password = password;
			this.profile = profile;
		}

		public User(String userName, String password, Profile profile,
				Set<Role> roles, Company company) {
			super();
			this.id  = IDGenerator.generate();
			this.userName = userName;
			this.password = password;
			this.profile = profile;
			this.roles = roles;
			this.company = company;
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}




		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", password="
					+ password + ", profile=" + profile + ", roles=" + roles
					+ ", company=" + company + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (id != other.id)
				return false;
			return true;
		}


		
		
		
		
		
}
