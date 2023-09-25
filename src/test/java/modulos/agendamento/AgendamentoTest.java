package modulos.agendamento;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class AgendamentoTest {

    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Cadastrar uma alergia corretamente")
    public void testCadastrarUmExame(){
        //String mensagemApresentada =
         new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("03907590902")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoLocalizacao()
                .botaoAgendamento()
                .selecaoTipoAgendamento("VACINA")
                .botaoOk()
                .botaoTitular()
                .botaoAgendar()
                .selecionarDataDisponivel()
                 .botaoOk();

        // String validarExameCadastrado = alergiaTela.validarExameCadastrado();
        // String validarExameCadastrado2 = alergiaTela.validarExameCadastrado2();

        //  Assertions.assertEquals("Tudo certo!", validarExameCadastrado);
        // Assertions.assertEquals("Exame enviado com sucesso!", validarExameCadastrado2);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}
