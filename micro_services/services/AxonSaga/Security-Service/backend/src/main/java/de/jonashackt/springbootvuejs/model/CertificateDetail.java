package de.jonashackt.springbootvuejs.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDetail extends AbstractBaseEntity{

    private String givenName;

    private String surname;

    @Column(unique = true)
    private String email;

    private String country;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startAt;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date endAt;

    private String organisation;

    private String organisationUnit;

    private String extension;

    private boolean isCA;

    private String issuerEmail;

    public String getCommonName(){
        return this.givenName + " " + this.surname;
    }

    private boolean isActive;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "issuer_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private CertificateDetail issuedBy;

  /*  @OneToMany(mappedBy = "issuer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<CertificateDetail> subjects;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "certificate_detail_id", nullable = false)
    private Cert*/



//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "issuer")
//    private List<CertificateRelationship> issuer;
//
//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "subject")
//    private CertificateRelationship subject;

}
