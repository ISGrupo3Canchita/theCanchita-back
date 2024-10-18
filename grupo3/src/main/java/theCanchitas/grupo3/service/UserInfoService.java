package theCanchitas.grupo3.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.repository.UserInfoRepository;
import theCanchitas.grupo3.security.UserInfoDetails;

@Service
public class UserInfoService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> userDetail = repository.findByEmail(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	}
	
	public String addUser(Usuario userInfo) {
        // Encode password before saving the user
        userInfo.setContraseña_Usuario(encoder.encode(userInfo.getContraseña_Usuario()));
        String uuid = UUID.randomUUID().toString();
        userInfo.setId(uuid);
        repository.save(userInfo);
        return "User Added Successfully";
    }
	
}
