package br.ufpb.genilson.exercicio3;

public class TestaSistemaAmigo {
    public void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        // a) cadastrar amigos
        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");

        // b) configurar amigo secreto
        try {
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");
        } catch (Exception e) {
            System.out.println("Erro ao configurar amigo secreto: " + e.getMessage());
        }

        // c) enviar msg anônima de Maria para José
        sistema.enviarMensagemParaAlguem("Oi José",
                                        "maria@email.com",
                                        "jose@email.com",
                                        true);

        // d) enviar msg anônima de Maria para todos
        sistema.enviarMensagemParaTodos("Boa sorte no amigo secreto!",
                                        "maria@email.com",
                                        true);

        // e) imprimir mensagens anônimas
        System.out.println("Mensagens anônimas:");
        for(Mensagem m : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(m.getTextoCompletoAExibir());
        }

        // f) verificar amigo secreto de José
        try {
            String amigoJose = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if(amigoJose.equals("maria@email.com")) {
                System.out.println("Ok - Amigo secreto de José é Maria.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
