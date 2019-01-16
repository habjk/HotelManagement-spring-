package com.KKHHH.eHotels.repository;

//import org.springframework.data.jpa.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.KKHHH.eHotels.domains.NewAdmin;

@Repository("NewAdminRepository")
public interface NewAdminRepository extends CrudRepository<NewAdmin, Long> {
	 NewAdmin findByEmail(String email);
     NewAdmin findByConfirmationToken(String confirmationToken);
}