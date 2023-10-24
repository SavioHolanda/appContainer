package modulos.agendamento;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import telas.AgendamentoTela;
import telas.BemVindoTela;
import telas.LoginTela;
import telas.ReceitaTela;

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
        AgendamentoTela agendamentoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoAgendamento()
                .selecaoTipoAgendamento("CHECK-UP")
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
