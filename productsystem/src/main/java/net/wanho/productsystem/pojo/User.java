package net.wanho.productsystem.pojo;

public class User {
    private String phone;
    private String name;
    private String pas;
    private Integer status;

    public User(){}
    public User(String phone, String name, String pas, Integer status) {
        this.phone = phone;
        this.name = name;
        this.pas = pas;
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String password) {
        this.pas = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
