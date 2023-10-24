package modulos.login;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class EsqueciSenhaTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Digitar um CPF cadastrado no campo Digite seu CPF e envia-lo.")
    public void testDigitarUmCpfCadastradoNoCampoDigiteSeuCpfEEnvialo() {
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("30480525005")
                .esqueciSenhaEnviar();
        String mensagemSucesso = loginTela.mensagemSucesso();
        String mensagemSenhaAlterada = loginTela.mensagemSenhaAlterada();

        Assertions.assertEquals("Sucesso!", mensagemSucesso);
        Assertions.assertEquals("Sua senha foi atualizada com sucesso!\n" +
                "\n" +
                "[ATENÇÃO] Você receberá uma Senha Provisória!\n" +
                "\n" +
                "O Envio da Senha Provisória é feita por: \n" +
                "- SMS (mensagem no seu celular)\n" +
                "- E-mail (seu e-mail cadastro no aplicativo", mensagemSenhaAlterada);
    }

    @Test
    @DisplayName("Digitar um CPF não cadastrado no campo Digite seu CPF e envia-lo.")
    public void testDigitarUmCPFNaoCadastradoNoCampoDigiteSeuCPFEEnvialo() {
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("12345217412")
                .esqueciSenhaEnviar();

        String mensagemAtencao = loginTela.mensagemAtencao();
        String mensagemUsuarioNaoEncontrado = loginTela.mensagemUsuarioNaoEncontrado();

        Assertions.assertEquals("Atenção!", mensagemAtencao);
        Assertions.assertEquals("Usuário não encontrado.", mensagemUsuarioNaoEncontrado);
    }

    @Test
    @DisplayName("Digitar caracteres especiais no campo digite seu CPF.")
    public void testDigitarCaracteresEspeciaisNoCampoDigiteSeuCPF() {
        String mensagemApresentada = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF(",.-")
                .esqueciSenhaEnviar()
                .cpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemApresentada);
    }

    @Test
    @DisplayName("Deixar o campo Digite seu CPF em branco.")
    public void testDeixaOCampoDigiteSeuCPFEmBranco() {
        String mensagemCpfObrigatorio = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("")
                .esqueciSenhaEnviar()
                .cpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemCpfObrigatorio);
    }

    @Test
    @DisplayName("Digitar um CPF incompleto no campo Digite seu CPF.")
    public void testDigitarUmCPFIncompletoNoCampoDigiteSeuCPF() {
        String mensagemCpfCompleto = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .esqueciSenha()
                .esqueciSenhaCPF("123")
                .esqueciSenhaEnviar()
                .cpfCompleto();

        Assertions.assertEquals("Digite o CPF completo", mensagemCpfCompleto);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}