package acceler.ocdl.dao;

import acceler.ocdl.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
