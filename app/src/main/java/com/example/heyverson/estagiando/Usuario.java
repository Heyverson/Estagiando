package com.example.heyverson.estagiando;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String academico, curso, orientador, coordenador, bloco, periodo, matricula;

    private Boolean cheio = false;

    private @ServerTimestamp
    Date cadastro;

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Boolean getCheio() {
        return cheio;
    }

    public void setCheio(Boolean cheio) {
        this.cheio = cheio;
    }

    public String getAcademico() {
        return academico;
    }

    public void setAcademico(String academico) {
        this.academico = academico;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String supervisor) {
        this.coordenador = supervisor;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public Map<String, Object> toMapUser() {

        HashMap<String, Object> result = new HashMap<>();
        if (!academico.isEmpty()) {
            result.put("academico", academico);
        }
        if (!curso.isEmpty()) {
            result.put("curso", curso);
        }
        if (!orientador.isEmpty()) {
            result.put("orientador", orientador);
        }
        if (!coordenador.isEmpty()) {
            result.put("coordenador", coordenador);
        }
        if (!bloco.isEmpty()) {
            result.put("bloco", bloco);
        }
        if (!periodo.isEmpty()) {
            result.put("periodo", periodo);
        }
        if (!matricula.isEmpty()) {
            result.put("matricula", matricula);
        }


        return result;
    }
}
