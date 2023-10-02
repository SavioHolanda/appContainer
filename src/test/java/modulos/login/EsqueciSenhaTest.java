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
    public void testDgitarUmCPFCadastradoNoCampoDigiteSeuCPFEEnvialo() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .esqueciSenha()
                .esqueciSenhaCPF("30480525005")
                .esqueciSenhaEnviar()
                .mensagem();

        Assertions.assertEquals("Sua senha foi atualizada com sucesso!\n" +
                "\n" +
                "[ATENÇÃO] Você receberá uma Senha Provisória!\n" +
                "\n" +
                "O Envio da Senha Provisória é feita por: \n" +
                "- SMS (mensagem no seu celular)\n" +
                "- E-mail (seu e-mail cadastro no aplicativo", mensagemApresentada);
    }

    @Test
    @DisplayName("Digitar um CPF não cadastrado no campo Digite seu CPF e envia-lo.")
    public void testDigitarUmCPFNaoCadastradoNoCampoDigiteSeuCPFEEnvialo() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .esqueciSenha()
                .esqueciSenhaCPF("10994803028")
                .esqueciSenhaEnviar()
                .mensagem();

        Assertions.assertEquals("Usuário não encontrado.", mensagemApresentada);
    }

    @Test
    @DisplayName("Digitar letras e caracteres especiais no campo digite seu CPF.")
    public void testDigitarLetrasECaracteresEspeciaisNoCampoDigiteSeuCPF() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .esqueciSenha()
                .esqueciSenhaCPF("Teste@!*%")
                .esqueciSenhaEnviar()
                .cpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemApresentada);
    }

    @Test
    @DisplayName("Deixar o campo Digite seu CPF em branco.")
    public void testDeixaOCampoDigiteSeuCPFEmBranco() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .esqueciSenha()
                .esqueciSenhaCPF("")
                .esqueciSenhaEnviar()
                .cpfObrigatorio();

        Assertions.assertEquals("CPF obrigatório", mensagemApresentada);
    }

    @Test
    @DisplayName("Digitar um CPF incompleto no campo Digite seu CPF.")
    public void testDigitarUmCPFIncompletoNoCampoDigiteSeuCPF() {
        String mensagemApresentada = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .esqueciSenha()
                .esqueciSenhaCPF("029")
                .esqueciSenhaEnviar()
                .cpfCompleto();

        Assertions.assertEquals("Digite o CPF completo", mensagemApresentada);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}