package karol.appdemo.user;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "active")
    @NotNull
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Transient
    private int nrRoli;

    @Transient
    private String newPassword;

    @Column(name = "activation_code")
    private String activationCode;



    // pola stworzone dla profesora
    @Column(name = "konsultacje")
    @NotNull
    private String konsultacje;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "title_prof")
    @NotNull
    private String titleP;

    @Column(name = "my_page")
    @NotNull
    private String myPage;

    @Column(name = "info_student")
    @NotNull
    private String infoStudent;

    @Column(name = "room")
    @NotNull
    private String room;

    //pola stworzone dla usera
    @Column(name = "kierunek")
    @NotNull
    private String kierunek;

    @Column(name = "group_lab")
    @NotNull
    private String groupLab;




    // add photo img
    @Transient
    private MultipartFile photo;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @Column(name = "file_name")
    @NotNull
    private String fileName;

    @Column(name = "file_type")
    @NotNull
    private String fileType;





    // Gettery i settery
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getActive() {
        return active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getNrRoli() {
        return nrRoli;
    }

    public void setNrRoli(int nrRoli) {
        this.nrRoli = nrRoli;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getKonsultacje() {
        return konsultacje;
    }

    public void setKonsultacje(String konsultacje) {
        this.konsultacje = konsultacje;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitleP() {
        return titleP;
    }

    public void setTitleP(String titleP) {
        this.titleP = titleP;
    }

    public String getMyPage() {
        return myPage;
    }

    public void setMyPage(String myPage) {
        this.myPage = myPage;
    }

    public String getInfoStudent() {
        return infoStudent;
    }

    public void setInfoStudent(String infoStudent) {
        this.infoStudent = infoStudent;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getGroupLab() {
        return groupLab;
    }

    public void setGroupLab(String groupLab) {
        this.groupLab = groupLab;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return name+" "+lastName;
    }
}

