import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import br.ufpb.genilson.exercicio3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                () -> sistema.pesquisaAmigo("ayla@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        assertThrows(AmigoInexistenteException.class,
                () -> sistema.pesquisaAmigo("ayla@teste.com"));

        try {
            sistema.cadastraAmigo("ayla", "ayla@teste.com");
            Amigo a = sistema.pesquisaAmigo("ayla@teste.com");
            assertEquals("ayla", a.getNome());
            assertEquals("ayla@teste.com", a.getEmail());
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaTodos("texto", "ayla@dcx.ufpb.br", true);
        List<Mensagem> msgs = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, msgs.size());
        assertEquals("ayla@dcx.ufpb.br", msgs.get(0).getEmailRemetente());
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        sistema.enviarMensagemParaAlguem("texto", "ayla@dcx.ufpb.br",
                "rodrigo@dcx.ufpb.br", true);

        List<Mensagem> msgs = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, msgs.size());
        assertTrue(msgs.get(0) instanceof MensagemParaAlguem);
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        sistema.enviarMensagemParaAlguem("texto 1", "a", "b", false);
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());

        sistema.enviarMensagemParaAlguem("texto 2", "a", "b", true);
        assertEquals(1, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        sistema.enviarMensagemParaAlguem("m1", "a", "b", false);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
        sistema.enviarMensagemParaAlguem("m2", "a", "b", true);
        assertEquals(2, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                () -> sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));

        try {
            sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
            sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");

            sistema.configuraAmigoSecretoDe("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "ayla@dcx.ufpb.br");

            assertEquals("ana@dcx.ufpb.br",
                    sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));

            assertEquals("ayla@dcx.ufpb.br",
                    sistema.pesquisaAmigoSecretoDe("ana@dcx.ufpb.br"));

        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
    }
}
