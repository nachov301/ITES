package app.iggy.ites;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String TAG = "Item";
    private String remitente;
    private String email;
    private String asunto;
    private String contenido;
    private String color;

    public Item(String remitente, String asunto, String contenido, String color) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.color = color;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getEmail() {
        return email;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getColor() {
        return color;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
