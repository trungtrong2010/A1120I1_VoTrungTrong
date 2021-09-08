package com.codegym.furama.model.entity.employee;

import com.codegym.furama.model.entity.contract.Contract;
import com.codegym.furama.model.entity.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Not empty !")
    @Column(length = 45)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Not null !")
    @PastOrPresent(message = "Day of birth fail ! ")
    private LocalDate dayOfBirth;

    @Column(length = 10)
    private String idCard;

    private Double salary;

    @Column(length = 11)
    private String phone;

    @Column(length = 45)
    @Email(message = "Wrong email format !")
    @NotBlank(message = "Not blank")
    private String email;

    @Column(length = 100)
    private String address;

    @ManyToOne(targetEntity = Division.class)
    private Division division;

    @ManyToOne(targetEntity = EducationDegree.class)
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Position.class)
    private Position position;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Employee() {
    }

    public Employee(int id, @NotEmpty(message = "Not empty !") String name, @NotNull(message = "Not blank !") @PastOrPresent(message = "Day of birth fail ! ") LocalDate dayOfBirth, String idCard, Double salary, String phone, @Email(message = "Wrong email format !") String email, String address, Division division, EducationDegree educationDegree, Position position) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (!employee.phone.matches("(090||091)+[0-9]{7}+")) {
            errors.rejectValue("phone",null,"Format error: 090/091 xxxx xxx");
        }
        if (!employee.idCard.matches("[0-9]{9,10}")) {
            errors.rejectValue("idCard",null,"Format error: 9/10 number");
        }
        if (!(employee.salary instanceof Double)) {
            errors.rejectValue("salary",null,"Format error: salary is a number");
        }
        if (employee.salary % 1 != 0) {
            errors.rejectValue("salary",null,"chữ");
        }
    }
}
