package modulos.login;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;

import java.util.concurrent.TimeUnit;

public class BemVindoTest {
    private AndroidDriver app;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar o preenchimento do campo CPF com CPF cadastrado  em mais de uma entidade e clicar em avançar")
    public void testRealizarOPreenchimentoDoCampoCpfComCpfCadastradoEmMaisDeUmaEntidadeEClicarEmAvancar() {
        String textoTelaLogin = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar()
                .textoCPF();

        Assertions.assertEquals("Entrar no Cuid@r ", textoTelaLogin);
    }

    @Test
    @DisplayName("Realizar o preenchimento do campo CPF com CPF cadastrado em apenas uma entidade e clicar em avançar")
    public void testRealizarOPreenchimentoDoCampoCpfComCpfCadastradoEmApenasUmaEntidadeEClicarEmAvancar() {
        String textoTelaLogin = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .textoCPF();

        Assertions.assertEquals("Entrar no Cuid@r ", textoTelaLogin);
    }

    @Test
    @DisplayName("Realizar o preenchimento do campo CPF com um Cpf não cadastrado e clicar em avançar")
    public void testRealizarOPreenchimentoDoCampoCpfComUmCpfNaoCadastradoEClicarEmAvancar() {
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971000000")
                .btnAvancar();

        String mensagemErro = bemVindoTela.mensagemErro();
        String mensagemDadosNaoEncontrados = bemVindoTela.mensagemDadosNaoEncontrados();

        Assertions.assertEquals("Error", mensagemErro);
        Assertions.assertEquals("Dados não encontrados", mensagemDadosNaoEncontrados);
    }

    @Test
    @DisplayName("Realizar o não preenchimento do campo CPF e clicar em avançar")
    public void testRealizarONaoPreenchimentoDoCampoCpfEClicarEmAvancar() {
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("")
                .btnAvancar();

        String mensagemCpfCampo = bemVindoTela.mensagemCpfCampo();

        Assertions.assertEquals("CPF", mensagemCpfCampo);
    }

    @Test
    @DisplayName("Realizar o preenchimento do campo CPF com caracteres especiais e clicar em avançar")
    public void testRealizarONaoPreenchimentoDoCampoCpfComCaracteresEspeciaisEClicarEmAvancar() {
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf(",.-")
                .btnAvancar();

        String mensagemCpfCampo = bemVindoTela.mensagemCpfCampo();

        Assertions.assertEquals("CPF", mensagemCpfCampo);
    }
    @After
    public void fecharDriver(){
        app.quit();
    }
}
