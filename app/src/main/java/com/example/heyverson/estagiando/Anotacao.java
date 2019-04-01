package com.example.heyverson.estagiandodiario;

public class Relatorio {
    String data, setor, comentario,chave;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    Boolean cheio = false;

    public Boolean getCheio() {
        return cheio;
    }

    public void setCheio(Boolean cheio) {
        this.cheio = cheio;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Relatorio "+ data  +
                ", setor: " + setor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
