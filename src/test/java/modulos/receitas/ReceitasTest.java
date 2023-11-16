package modulos.receitas;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import driver.AndroidDriverProvider;
import driver.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.ReceitaTela;

import java.util.concurrent.TimeUnit;

public class ReceitasTest {
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
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoCameraESalvar() {
        test = extent.createTest("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo câmera e salvar.");
        ReceitaTela receitaTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .campoNomeMedico("teste")
                .campoCRM("teste")
                .botaoSalvar()
                .btnAnexar()
                .botaoAnexarReceita()
                .botaoSalvar();

        if(receitaTela.mensagemTudoCerto().equals(receitaTela.mensagemDeSucesso()) && receitaTela.mensagemSucesso().equals(receitaTela.mensagemDeSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), receitaTela.mensagemDeSucesso());
        Assertions.assertEquals(receitaTela.mensagemSucesso(), receitaTela.mensagemDeSucesso2());
    }
    @Test
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoGaleriaDeImagensESalvar() {
        test = extent.createTest("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo galeria de imagens e salvar.");
        ReceitaTela receitaTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .campoNomeMedico("teste")
                .campoCRM("teste")
                .botaoSalvar()
                .btnAnexar()
                .btnGaleria()
                .botaoSalvar();

        if(receitaTela.mensagemTudoCerto().equals(receitaTela.mensagemDeSucesso()) && receitaTela.mensagemSucesso().equals(receitaTela.mensagemDeSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), receitaTela.mensagemDeSucesso());
        Assertions.assertEquals(receitaTela.mensagemSucesso(), receitaTela.mensagemDeSucesso2());
    }
    @Test
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoDocumentosESalvar() {
        test = extent.createTest("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo Documentos e salvar.");
        ReceitaTela receitaTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .campoNomeMedico("teste")
                .campoCRM("teste")
                .botaoSalvar()
                .btnAnexar()
                .btnDocumento()
                .botaoSalvar();

        if(receitaTela.mensagemTudoCerto().equals(receitaTela.mensagemDeSucesso()) && receitaTela.mensagemSucesso().equals(receitaTela.mensagemDeSucesso2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), receitaTela.mensagemDeSucesso());
        Assertions.assertEquals(receitaTela.mensagemSucesso(), receitaTela.mensagemDeSucesso2());
    }
    @Test
    public void testRealizarOCadastroDeUmaReceitaSemPreencherONomeDoMedicoCrmDoMedicoESemAnexoDeReceitaEClicarEmSalvar() {
        test = extent.createTest("Realizar o cadastro de uma receita sem preencher o nome do medico, CRM do médico e sem anexo de receita e clicar em salvar.");
        ReceitaTela receitaTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .campoNomeMedico("")
                .campoCRM("")
                .botaoSalvar();

        if(receitaTela.mensagemBtnDesabilitado().equals(receitaTela.validarCamposObrigatório())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(receitaTela.mensagemBtnDesabilitado(), receitaTela.validarCamposObrigatório());
    }
    @Test
    public void testRealizarOCliqueNoBotaoAnexarReceitaENaOpcaoCancelar() {
        test = extent.createTest("Realizar o clique no botão Anexar Receita e na opção Cancelar.");
        ReceitaTela receitaTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .btnAnexar()
                .btnCancelar();

        if(receitaTela.mensagemBtnDesabilitado().equals(receitaTela.validarCamposObrigatório())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(receitaTela.mensagemBtnDesabilitado(), receitaTela.validarCamposObrigatório());
    }
    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}