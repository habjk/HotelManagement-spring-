package com.KKHHH.eHotels.domains;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 	
	    private String firstName;
	 	private String middleName;
	    private String lastName;
	    private String email;
	    private String password;
	    
	    private String idno;
	    
	    private String city;
	    
	    private String subCity;
	    
	    private String state;
	    
	    private String accno;
	    @ManyToOne
	    @JoinColumn(name="hotelId",nullable=true)
	    private Hotel hotel;
	    /*
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(
	                    name = "user_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "role_id", referencedColumnName = "id"))*/
	    @javax.persistence.OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
	    private Role role;
	   // private Collection<Role> roles;

	public User() {
	    }

	    public User(String firstName, String lastName, String email, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	    }

	  

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	   /* public Hotel getHotel() {
	    	return this.hotel;
	    }
	    public Role getRole() { return role;}*/


	    @Override
	    public String toString() {
	        return "Manager{" +
	                "id=" + id +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", password='" + "*********" + '\'' +
	                ", roles=" +
	                '}';
	    }

	    @Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return Arrays.asList(new org.springframework.security.core.authority.SimpleGrantedAuthority(role.getRole()));
		}
}
