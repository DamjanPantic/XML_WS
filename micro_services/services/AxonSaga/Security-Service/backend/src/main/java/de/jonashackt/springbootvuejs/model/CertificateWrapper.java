package de.jonashackt.springbootvuejs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificateWrapper {

    private PrivateKey privateKey;
    private X509Certificate certificate;
}
