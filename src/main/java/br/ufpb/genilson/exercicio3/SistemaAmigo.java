package br.ufpb.genilson.exercicio3;
import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Amigo> amigos = new ArrayList<>();

    public void cadastraAmigo(String nome, String email) {
        amigos.add(new Amigo(nome, email));
    }

    public Amigo pesquisaAmigo(String email) {
        for(Amigo a : amigos) {
            if(a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima));
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        mensagens.add(new MensagemParaTodos(texto, emailRemetente, anonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> listaMensagensAnonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                listaMensagensAnonimas.add(m);
            }
        }
        return listaMensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Email não cadastrado.");
        }
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);

        if(amigo == null) {
            throw new AmigoInexistenteException("Email não cadastrado.");
        }

        if(amigo.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto não definido.");
        }

        return amigo.getEmailAmigoSorteado();
    }
}
