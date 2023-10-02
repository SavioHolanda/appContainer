package modulos.login;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class RelatarProblemaTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    @DisplayName("Relatar um problema técnico corretamente preenchendo os campos Nome, Telefone, Mensagem e Enviando.")
    public void testRelatarUmProblemaTecnicoCorretamentePreenchendoOsCampoNomeTelefoneMensagemEEnviando() {
        LoginTela loginTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .relatarProblema()
                .digitarNomeRelatarProblema("Fulano da Silva")
                .digitarTelefoneRelatarProblema("85999999999")
                .digitarMensagemRelatarProblema("Mensagem testes para enviar um problema a ser reportado.")
                .botaoEnviarRelatarProblema();

        String mensagemSucessoRelatarproblema1 = loginTela.mensagemSucessoRelatarproblema1();
        String mensagemSucessoRelatarproblema2 = loginTela.mensagemSucessoRelatarproblema2();

        Assertions.assertEquals("Sucesso", mensagemSucessoRelatarproblema1);
        Assertions.assertEquals("Recebemos sua notificação e entraremos em contato em breve. Nosso horário de atendimento é de segunda a sexta, das 9h às 19h.", mensagemSucessoRelatarproblema2);
    }
    @Test
    @DisplayName("Relatar um problema técnico invalido não preenchendo os campos Nome, Telefone, Mensagem e Enviando.")
    public void testRelatarUmProblemaTecnicoInvalidoNaoPreenchendoOsCamposNomeTelefoneMensagemEEnviando() {
        LoginTela loginTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .relatarProblema()
                .botaoEnviarRelatarProblema();

        String mensagemNomeObrigatorio = loginTela.mensagemNomeObrigatorio();
        String mensagemTelefoneObrigatorio = loginTela.mensagemTelefoneObrigatorio();
        String mensagemObrigatorio = loginTela.mensagemObrigatorio();

        Assertions.assertEquals("Informe o seu nome", mensagemNomeObrigatorio);
        Assertions.assertEquals("Informe o seu telefone", mensagemTelefoneObrigatorio);
        Assertions.assertEquals("Informe o problema", mensagemObrigatorio);
    }
    @Test
    @DisplayName("Digitar caracteres especiais ou letras no campo Telefone.")
    public void testDigitarCaracteresEspeciaisOuLetrasNoCampoTelefone() {
        LoginTela loginTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .relatarProblema()
                .digitarTelefoneRelatarProblema("%./@!test,")
                .botaoEnviarRelatarProblema();

        String mensagemTelefoneObrigatorio = loginTela.telefoneMensagem();

        Assertions.assertEquals("Telefone Celular", mensagemTelefoneObrigatorio);
    }
    @Test
    @DisplayName("Clicar na funcionalidade botão cancelar.")
    public void testClicarNaFuncionalidadeBotaoCancelar() {
        String textoRelatarproblema = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .relatarProblema()
                .botaoCancelarRelatarProblema()
                .textoRelatarproblema();

        Assertions.assertEquals("Relatar Problema Técnico", textoRelatarproblema);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}