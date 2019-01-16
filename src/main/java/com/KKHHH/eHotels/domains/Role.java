package com.KKHHH.eHotels.domains;

import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @JsonIgnore
	@javax.persistence.OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
	private User user;
    
    public Role() {
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



	public Stream<Role> stream() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getRole() {
		return name;
	}
   
}
