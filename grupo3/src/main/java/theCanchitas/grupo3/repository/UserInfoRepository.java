package theCanchitas.grupo3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.UserInfo;
	
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>{
	Optional<UserInfo> findByEmail(String email);
}
