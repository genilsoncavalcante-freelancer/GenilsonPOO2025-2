package br.ufpb.genilson.exercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;     // chave = email
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    // ----------------------------------------------------------------------
    // CADASTRO E PESQUISA
    // ----------------------------------------------------------------------
    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        if (amigos.containsKey(email)) {
            throw new AmigoJaExisteException("Já existe amigo com esse e-mail.");
        }
        amigos.put(email, new Amigo(nome, email));
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Amigo a = amigos.get(email);
        if (a == null) {
            throw new AmigoInexistenteException("Amigo não encontrado.");
        }
        return a;
    }

    // ----------------------------------------------------------------------
    // CONFIGURAÇÃO DO AMIGO SECRETO
    // ----------------------------------------------------------------------
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigo)
            throws AmigoInexistenteException {

        Amigo pessoa = amigos.get(emailDaPessoa);
        if (pessoa == null) {
            throw new AmigoInexistenteException("Pessoa não encontrada.");
        }

        pessoa.setEmailAmigoSorteado(emailAmigo);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {

        Amigo pessoa = amigos.get(emailDaPessoa);
        if (pessoa == null) {
            throw new AmigoInexistenteException("Pessoa não cadastrada.");
        }

        if (pessoa.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("O amigo secreto ainda não foi sorteado.");
        }

        return pessoa.getEmailAmigoSorteado();
    }

    // ----------------------------------------------------------------------
    // MENSAGENS
    // ----------------------------------------------------------------------
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(
            String texto, String emailRemetente, String emailDestinatario, boolean anonima) {

        MensagemParaAlguem msg =
                new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(msg);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> resultado = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }
}
