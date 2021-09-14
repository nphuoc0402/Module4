import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;


package com.codegym.cms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salaries")
public class Salary {

    @EmbeddedId
    private EmpIdFromDatePK empId;

    @Column(name = "to_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name = "salary")
    private Long salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @MapsId("empId")
    @JoinColumns({@JoinColumn(foreignKey = @ForeignKey(name = "salaries_ibfk_1"), name = "emp_no", referencedColumnName = "emp_no")})
    private Employee employee;

    public Salary() {
        super();
    }

    //...
}