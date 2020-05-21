package de.jonashackt.springbootvuejs.certificates.util;

import de.jonashackt.springbootvuejs.model.CertificateDetail;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

import java.security.*;


public class CertificateCreation {
    public static X500Name generateX500Name(CertificateDetail certificateDetail){
        System.out.println(certificateDetail);
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
        builder.addRDN(BCStyle.CN, certificateDetail.getCommonName());
        builder.addRDN(BCStyle.SURNAME, certificateDetail.getSurname());
        builder.addRDN(BCStyle.GIVENNAME, certificateDetail.getGivenName());
        builder.addRDN(BCStyle.O, certificateDetail.getOrganisation());
        builder.addRDN(BCStyle.OU, certificateDetail.getOrganisationUnit());
        builder.addRDN(BCStyle.C, certificateDetail.getCountry());
        builder.addRDN(BCStyle.E, certificateDetail.getEmail());
        builder.addRDN(BCStyle.UID, certificateDetail.getId().toString());
        return builder.build();
    }

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(2048, random);
            return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }


}
