package acceler.ocdl.dao;

import acceler.ocdl.entity.Suffix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SuffixDao extends JpaRepository<Suffix, Long>, JpaSpecificationExecutor<Suffix> {
}
