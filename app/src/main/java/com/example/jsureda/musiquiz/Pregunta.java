package com.example.jsureda.musiquiz;

public class Pregunta {
    private String  enunciado, refAudio, respuestaA, respuestaB, respuestaC, respuestaD, correcta;
    private Integer id, nivel;

    public Pregunta()
    {
        super();
    }

    public Pregunta(String enunciado, String refAudio, String respuestaA, String respuestaB, String respuestaC, String respuestaD, String correcta, Integer nivel)
    {
        this.enunciado=enunciado;
        this.refAudio=refAudio;
        this.respuestaA=respuestaA;
        this.respuestaB=respuestaB;
        this.respuestaC=respuestaC;
        this.respuestaD=respuestaD;
        this.correcta=correcta;
        this.nivel=nivel;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRefAudio() {
        return refAudio;
    }

    public void setRefAudio(String refAudio) {
        this.refAudio = refAudio;
    }

    public String getRespuestaA() {
        return respuestaA;
    }

    public void setRespuestaA(String respuestaA) {
        this.respuestaA = respuestaA;
    }

    public String getRespuestaB() {
        return respuestaB;
    }

    public void setRespuestaB(String respuestaB) {
        this.respuestaB = respuestaB;
    }

    public String getRespuestaC() {
        return respuestaC;
    }

    public void setRespuestaC(String respuestaC) {
        this.respuestaC = respuestaC;
    }

    public String getRespuestaD() {
        return respuestaD;
    }

    public void setRespuestaD(String respuestaD) {
        this.respuestaD = respuestaD;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
