package com.mozore.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Revues")
public class Revue {
    @Id
    private String _id;

    @JsonProperty("titre_film") // Correspondance explicite avec MongoDB
    private String titre_film;

    @JsonProperty("image_film")
    private String image_film;

    @JsonProperty("contenu_revue")
    private String contenu_revue;

    @JsonProperty("note")
    private float note;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitre_Film() {
        return titre_film;
    }

    public void setTitre_Film(String titre_Film) {
        titre_film = titre_Film;
    }

    public String getImage_Film() {
        return image_film;
    }

    public void setImage_Film(String image_Film) {
        image_film = image_Film;
    }

    public String getContenu_Revue() {
        return contenu_revue;
    }

    public void setContenu_Revue(String contenu_Revue) {
        contenu_revue = contenu_Revue;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
