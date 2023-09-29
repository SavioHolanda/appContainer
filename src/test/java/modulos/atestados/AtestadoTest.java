package modulos.atestados;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.AtestadoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class AtestadoTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Teste para validar realizar o cadastro de um atestado")
    public void testRealizarCadastroDeAtestado() {
        AtestadoTela atestadoTela  = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoHome()
                .btnAtestado()
                .btnPermissao()
                .btnCadastrarAtestado()
                .selecionarDataInicio()
                .btnConfirmarDataEHora()
                .selecionarHoraInicio()
                .btnConfirmarDataEHora()
                .selecionarDataFim()
                .scroll(0.5,0.56,0.5,0.52)
                .btnConfirmarDataEHora()
                .selecionarHoraFim()
                .btnConfirmarDataEHora()
                .txtNomeMedico("Dr João Silva")
                .txtCRM("123456")
                .txtCID("654321")
                .txtObs("Obs")
                .btnAnexarAtestadoGaleria()
                .checkBoxConfirmacao()
                .btnSalvar();

        Assertions.assertEquals("Tudo certo!",atestadoTela.mensagemCadastroPositivo());
        Assertions.assertEquals("Recebemos o seu atestado e está em análise. Em até 2 dias úteis você receberá a confirmação de aceite, fique atento.\n" +
                " IMPORTANTE: Não descarte seu atestado original, ele é um documento legal, e pode ser necessário apresentá-lo pessoalmente.",atestadoTela.mensagemCadastroPositivoComplemento());
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}