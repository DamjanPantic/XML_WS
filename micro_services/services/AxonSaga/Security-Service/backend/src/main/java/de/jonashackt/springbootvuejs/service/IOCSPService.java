package de.jonashackt.springbootvuejs.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;

public interface IOCSPService {

    boolean verify(String email) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException;
    boolean isRevoked(String email) throws CertificateException, CRLException, IOException;
    boolean hasExpired(String email);
}
