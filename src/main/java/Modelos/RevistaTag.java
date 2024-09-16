/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class RevistaTag {
       private long idRevistaTag; // PRIMARY KEY
    private long idRevista; // FOREIGN KEY a Revista
    private long idTag; // FOREIGN KEY a Tag

    public long getIdRevistaTag() {
        return idRevistaTag;
    }

    public void setIdRevistaTag(long idRevistaTag) {
        this.idRevistaTag = idRevistaTag;
    }

    public long getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(long idRevista) {
        this.idRevista = idRevista;
    }

    public long getIdTag() {
        return idTag;
    }

    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }

    public RevistaTag() {
    }

    public RevistaTag(long idRevistaTag, long idRevista, long idTag) {
        this.idRevistaTag = idRevistaTag;
        this.idRevista = idRevista;
        this.idTag = idTag;
    }
    
    
}
