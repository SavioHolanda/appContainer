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
    @DisplayName("Teste para realizar validação de envio de uma mensagem corretamente")
    public void testParaRealizarValidacaoDeEnvioDeUmaMensagemCorretamente() {
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
    @DisplayName("Teste para realizar validação dos campos obrigatórios")
    public void testParaRealizarValidacaoDosCamposObrigatorios() {
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
    @DisplayName("Teste para verificar digitar caracteres especiais ou letras no campo Telefone.")
    public void testParaVerificarUsarCaracteresEspeciaisOuLetrasNoCampoTelefone() {
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
    @DisplayName("Teste para realizar o cancelamento do envio de mensagem")
    public void testParaRealizarOCancelamentoDoEnvioDeMensagem() {
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