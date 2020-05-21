package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.CertificateDetail;

import java.util.List;
import java.util.UUID;

public interface ICertificateDetailService {

    CertificateDetail createCertificateDetail(CertificateDetail certificateDetail);
    List<CertificateDetail> getAll();
    CertificateDetail getOneById(UUID id);
    CertificateDetail getOneByEmail(String email);
}
