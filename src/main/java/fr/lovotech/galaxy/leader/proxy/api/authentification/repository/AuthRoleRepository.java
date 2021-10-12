package fr.lovotech.galaxy.leader.proxy.api.authentification.repository;


import com.lovotech.fr.gxld.core.bean.cra.domain.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole,Long> {
   AuthRole findByNameContaining(String roleName);
}
