package theCanchitas.grupo3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Usuarios;
	
@Repository
public interface UserInfoRepository extends JpaRepository<Usuarios,Integer>{
	Optional<Usuarios> findByEmail(String email);
}
