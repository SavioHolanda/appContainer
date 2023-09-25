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
    @DisplayName("Teste para validar digitar um CPF valido cadastrado no campo Digite seu CPF e envia-lo.")
    public void testParaAlterarSenhaEsquecidaComCPFValido() {
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
    @DisplayName("Teste para validar digitar um CPF não cadastrado no campo Digite seu CPF e envia-lo.")
    public void testParaAlterarSenhaEsquecidaComCPFInvalido() {
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
    @DisplayName("Teste para alterar senha esquecida com CPF preenchido com letras e caracteres especiais")
    public void testParaAlterarSenhaEsquecidaComCPFPreenchidoComLetrasECaracteresEspeciais() {
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
    @DisplayName("Teste para alterar senha esquecida com CPF com o campo vazio")
    public void testParaAlterarSenhaEsquecidaComCPFComOCampoVazio() {
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
    @DisplayName("Teste para validar digitar um CPF incompleto no campo Digite seu CPF.")
    public void testParaValidarCpfIncompleto() {
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