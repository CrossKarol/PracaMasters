package karol.appdemo.deanGroup;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deangroup")
public class
DeanGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "groupdean_id")
    private int id;

    @Column(name = "department")
    @NotNull
    private String department;

    @Column(name = "field_of_study")
    @NotNull
    private String fieldOfStudy;

    @Column(name = "group_lab")
    @NotNull
    private String group;

    @Column(name = "specialization")
    @NotNull
    private String specialization;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
