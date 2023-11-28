package modulos.exame;

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
import telas.ExameTela;

import java.util.concurrent.TimeUnit;

public class ExameTest {

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
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexoUmaImagemDaGaleriaDeImagensESalvar(){
        test = extent.createTest("Realizar o cadastro de um exame selecionando uma categoria e anexando uma imagem da galeria de imagens e salvar.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoGaleria() //aqui
                .botaoSalvar();

        if(exameTela.mensagemTudoCerto().equals(exameTela.validarExameCadastrado()) && exameTela.mensagemSucesso().equals(exameTela.validarExameCadastrado2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), exameTela.validarExameCadastrado());
        Assertions.assertEquals(exameTela.mensagemSucesso(), exameTela.validarExameCadastrado2());
    }
    @Test
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexandoUmaFotoDaCameraESalvar(){
        test = extent.createTest("Realizar o cadastro de um exame selecionando uma categoria e anexando uma foto da câmera e salvar.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoCamera()
                .botaoSalvar();

        if(exameTela.mensagemTudoCerto().equals(exameTela.validarExameCadastrado()) && exameTela.mensagemSucesso().equals(exameTela.validarExameCadastrado2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), exameTela.validarExameCadastrado());
        Assertions.assertEquals(exameTela.mensagemSucesso(), exameTela.validarExameCadastrado2());
    }
    @Test
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexandoUmDocumentoESalvar(){
        test = extent.createTest("Realizar o cadastro de um exame selecionando uma categoria e anexando um documento e salvar.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoDocumento()
                .botaoSalvar();

        if(exameTela.mensagemTudoCerto().equals(exameTela.validarExameCadastrado()) && exameTela.mensagemSucesso().equals(exameTela.validarExameCadastrado2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), exameTela.validarExameCadastrado());
        Assertions.assertEquals(exameTela.mensagemSucesso(), exameTela.validarExameCadastrado2());
    }
    @Test
    public void testRealizarAExclusaoDeUmExameCadastrado(){
        test = extent.createTest("Realizar a exclusão de um exame cadastrado.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .excluirExame();

        if(exameTela.mensagemTudoCerto().equals(exameTela.validarExameExcluido()) && exameTela.mensagemExcluido().equals(exameTela.validarExameExcluido2())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), exameTela.validarExameExcluido());
        Assertions.assertEquals(exameTela.mensagemExcluido(), exameTela.validarExameExcluido2());
    }
    @Test
    public void testRealizarOCadastroDeUmExameSemSelecionarUmaCategoriaESemAnexarUmExame(){
        test = extent.createTest("Realizar o cadastro de um exame sem selecionar uma categoria e sem anexar um Exame.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoSalvar();

        if(exameTela.mensagemNovo().equals(exameTela.validarExamebtnSalvarDisable())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemNovo(), exameTela.validarExamebtnSalvarDisable());
    }

    @Test
    public void testRealizarCliqueNoBotaoAnexarExameENaOpcaoCancelar(){
        test = extent.createTest("Realizar clique no botão Anexar exame e na opção Cancelar.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoAnexarExame()
                .clicarBtnCancelarAnexar();

        if(exameTela.mensagemNovo().equals(exameTela.validarExamebtnSalvarDisable())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemNovo(), exameTela.validarExamebtnSalvarDisable());
    }
    @Test
    public void testRealizarCliqueNoCampoSelecioneACategoriaENaOpcaoCancelar(){
        test = extent.createTest("Realizar clique no campo Selecione a categoria e na opção Cancelar.");
        ExameTela exameTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                //.botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .btnCategoria()
                .clicarBtnCancelarCategoria();

        if(exameTela.mensagemNovo().equals(exameTela.validarExamebtnSalvarDisable())){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(exameTela.mensagemNovo(), exameTela.validarExamebtnSalvarDisable());
    }

    @After
    public void fecharDriver(){
        app.quit();
        extent.flush();
    }
}