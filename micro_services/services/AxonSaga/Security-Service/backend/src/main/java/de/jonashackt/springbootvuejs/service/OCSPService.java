package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.certificates.storage.CRLLoadSave;
import de.jonashackt.springbootvuejs.certificates.storage.Reader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Service
public class OCSPService implements IOCSPService {

    @Override
    public boolean verify(String email) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException {
        Reader reader = new Reader();
        X509Certificate subject = ( reader.readCertificate("keystore/intermediate.jks",email,"password".toCharArray(),"milutin".toCharArray())).getCertificate();
        String issuerAlias = subject.getIssuerDN().getName().split(",")[1].split("=")[1].trim();
        System.out.println(issuerAlias);
        X509Certificate issuer = (X509Certificate) (new Reader()).readX509Certificate("keystore/root.jks","password",issuerAlias);
        if(issuer == null){
            issuer = (X509Certificate) (new Reader()).readX509Certificate("keystore/intermediate.jks","password",issuerAlias);
        }
        try {
            subject.verify(issuer.getPublicKey());
            return true;
        } catch (SignatureException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isRevoked(String email) throws CertificateException, CRLException, IOException {
        Reader reader = new Reader();
        X509Certificate certificate = (X509Certificate) reader.readX509Certificate("keystore/intermediate.jks","password",email);
        if(certificate == null){
            certificate = (X509Certificate) reader.readX509Certificate("keystore/endentity.jks","password",email);
        }
        if(certificate == null){
            certificate = (X509Certificate) reader.readX509Certificate("keystore/root.jks","password",email);
        }
        X509CRL crl = CRLLoadSave.loadCRL();
        X509CRLEntry revoked = crl.getRevokedCertificate(certificate);
        if(revoked == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean hasExpired(String email) {
        Reader reader = new Reader();
        X509Certificate certificate = (X509Certificate) reader.readX509Certificate("keystore/intermediate.jks","password",email);
        if(certificate == null){
            certificate = (X509Certificate) reader.readX509Certificate("keystore/endentity.jks","password",email);
        }
        if(certificate == null){
            certificate = (X509Certificate) reader.readX509Certificate("keystore/root.jks","password",email);
        }
        if(new Date().getTime() > certificate.getNotAfter().getTime()){
            return true;
        }
        return false;
    }


}
