package br.ufpb.genilson.exercicio3;

public abstract class Mensagem {
    protected String texto;
    protected String emailRemetente;
    protected boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima() {
        return anonima;
    }

    //MÉTODO ABSTRATO DO DIAGRAMA
    public abstract String getTextoCompletoAExibir();

}
