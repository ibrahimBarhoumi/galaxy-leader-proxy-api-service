package fr.lovotech.galaxy.leader.proxy.api.authentification.repository;


import com.lovotech.fr.gxld.core.bean.cra.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByUserName(String username);

    Optional<AuthUser> findByUserNameOrEmail(String username, String email);
}
