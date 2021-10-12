package fr.lovotech.galaxy.leader.proxy.api.authentification.service;



import com.lovotech.fr.gxld.core.bean.cra.domain.AuthUser;
import com.lovotech.fr.gxld.core.bean.cra.exception.TechnicalException;
import com.lovotech.fr.gxld.core.bean.cra.exception.UserNotFoundException;
import fr.lovotech.galaxy.leader.proxy.api.authentification.repository.AuthUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AuthUserRepository userRepository;

    public UserDetailsServiceImpl(AuthUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) {
        Optional<AuthUser> optUser = userRepository.findByUserNameOrEmail(userName,userName);
        if (optUser.isPresent()) {
            AuthUser user = optUser.get();
            List<GrantedAuthority> authorities = user.getRoles()
                    .stream().map(roles -> new SimpleGrantedAuthority(roles.getName()))
                    .collect(Collectors.toList());
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
        throw new UserNotFoundException("User with username "+userName+ "Not found");
    }
}
