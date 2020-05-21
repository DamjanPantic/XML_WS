package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.CertificateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateDetailRepository extends JpaRepository<CertificateDetail, UUID> {

    CertificateDetail findOneById(UUID id);
    CertificateDetail findOneByEmail(String email);

}
