package modulos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import config.AndroidDriverProvider;
import config.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.FormPrimeiroAcessoTela;
import telas.LoginTela;

import java.util.concurrent.TimeUnit;

public class BemVindoTest {
    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComCpfCadastradoEmMaisDeUmaEntidadeEClicarEmAvancar() {
        test = extent.createTest("Realizar o preenchimento do campo CPF com CPF cadastrado  em mais de uma entidade e clicar em avançar");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971008312")
                .btnAvancar()
                .selecionarEmpresabem()
                .btnEmpresaAvancar();

        if(loginTela.msnEntrarCuidar().equals(loginTela.textoCPF())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnEntrarCuidar(), loginTela.textoCPF());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComCpfCadastradoEmApenasUmaEntidadeEClicarEmAvancar() {
        test = extent.createTest("Realizar o preenchimento do campo CPF com CPF cadastrado em apenas uma entidade e clicar em avançar");
        LoginTela loginTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples();

        if(loginTela.msnEntrarCuidar().equals(loginTela.textoCPF())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(loginTela.msnEntrarCuidar(), loginTela.textoCPF());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComUmCpfNaoCadastradoEClicarEmAvancar() {
        test = extent.createTest("Realizar o preenchimento do campo CPF com um Cpf não cadastrado e clicar em avançar");
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("02971000000")
                .btnAvancar();

        if(bemVindoTela.msnErro().equals(bemVindoTela.mensagemErro()) && bemVindoTela.msnDadosNaoEncontrados().equals(bemVindoTela.mensagemDadosNaoEncontrados())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(bemVindoTela.msnErro(), bemVindoTela.mensagemErro());
        Assertions.assertEquals(bemVindoTela.msnDadosNaoEncontrados(), bemVindoTela.mensagemDadosNaoEncontrados());
    }

    @Test
    public void testRealizarONaoPreenchimentoDoCampoCpfEClicarEmAvancar() {
        test = extent.createTest("Realizar o não preenchimento do campo CPF e clicar em avançar");
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("")
                .btnAvancar();

        if(bemVindoTela.msnCpf().equals(bemVindoTela.mensagemCpfCampo())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(bemVindoTela.msnCpf(), bemVindoTela.mensagemCpfCampo());
    }

    @Test
    public void testRealizarONaoPreenchimentoDoCampoCpfComCaracteresEspeciaisEClicarEmAvancar() {
        test = extent.createTest("Realizar o preenchimento do campo CPF com caracteres especiais e clicar em avançar");
        BemVindoTela bemVindoTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf(",.-")
                .btnAvancar();

        if(bemVindoTela.msnCpf().equals(bemVindoTela.mensagemCpfCampo())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(bemVindoTela.msnCpf(), bemVindoTela.mensagemCpfCampo());
    }
    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComUmCPFCadastradoEAceitarODocumentoDePrivacidade(){
        test = extent.createTest("Realizar o preenchimento do campo CPF com um CPF cadastrado e aceitar o documento de privacidade.");
        FormPrimeiroAcessoTela formPrimeiroAcessoTela = new BemVindoTela(app)
                .limparPrimeiroAcesso()
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("75598710030")
                .btnAvancar()
                .FormPrimeiroAcessoTela()
                .btnAceiteDoc();

        if(formPrimeiroAcessoTela.txtalertaSucessoAceite().equals(formPrimeiroAcessoTela.alertaSucessoAceite()) && formPrimeiroAcessoTela.txtmsnSucessoAceite().equals(formPrimeiroAcessoTela.msnSucessoAceite())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(formPrimeiroAcessoTela.txtalertaSucessoAceite(),formPrimeiroAcessoTela.alertaSucessoAceite());
        Assertions.assertEquals(formPrimeiroAcessoTela.txtmsnSucessoAceite(),formPrimeiroAcessoTela.msnSucessoAceite());
    }
    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}
