package ftn.uns.eObrazovanje.model.request;

import javax.persistence.Column;

public class UpdateUserRequest {

    private Integer id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private String address;

    private String jmbg;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(Integer id, String name, String surname, String username, String address, String jmbg) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.address = address;
        this.jmbg = jmbg;
    }

    public UpdateUserRequest(String name, String surname, String username, String address, String jmbg) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.address = address;
        this.jmbg = jmbg;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
