package tese.pojo;
public class Producto {
    int Id;
    String titulo;
    String descripcion;
    String urlimage;
    double precio;

    public Producto() {
    }

    public Producto(int Id, String titulo, String descripion, String urlImage, double precio) {
        this.Id = Id;
        this.titulo = titulo;
        this.descripcion = descripion;
        this.urlimage = urlImage;
        this.precio = precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "Id=" + Id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", urlImage=" + urlimage + ", precio=" + precio + '}';
    }
    
    

  
    
    
}
