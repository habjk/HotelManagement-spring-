<<<<<<< HEAD
package com.KKHHH.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;


import com.KKHHH.eHotels.domains.User;

public interface UserRepository extends CrudRepository<User,String>{

=======
package com.KKHHH.eHotels.repository;


import com.KKHHH.eHotels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
}
