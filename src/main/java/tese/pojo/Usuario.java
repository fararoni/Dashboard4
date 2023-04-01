package tese.pojo;
public class Usuario {
    Integer id;
    String email;
    String password;
    String password2;
    String telefono;
    public Usuario(){
    }
    public Usuario(String email, String password, String password2, String telefono) {
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + ", password2=" + password2 + ", telefono=" + telefono + '}';
    }

    
    
    
}
