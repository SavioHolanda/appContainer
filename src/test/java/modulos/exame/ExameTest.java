package modulos.exame;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
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

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar o cadastro de um exame selecionando uma categoria e anexando uma imagem da galeria de imagens e salvar.")
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexoUmaImagemDaGaleriaDeImagensESalvar(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoGaleria() //aqui
                .botaoSalvar();

        String validarExameCadastrado = exameTela.validarExameCadastrado();
        String validarExameCadastrado2 = exameTela.validarExameCadastrado2();

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), validarExameCadastrado);
        Assertions.assertEquals(exameTela.mensagemSucesso(), validarExameCadastrado2);
    }
    @Test
    @DisplayName("Realizar o cadastro de um exame selecionando uma categoria e anexando uma foto da câmera e salvar.")
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexandoUmaFotoDaCameraESalvar(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoCamera()
                .botaoSalvar();

        String validarExameCadastrado = exameTela.validarExameCadastrado();
        String validarExameCadastrado2 = exameTela.validarExameCadastrado2();

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), validarExameCadastrado);
        Assertions.assertEquals(exameTela.mensagemSucesso(), validarExameCadastrado2);
    }
    @Test
    @DisplayName("Realizar o cadastro de um exame selecionando uma categoria e anexando um documento e salvar.")
    public void testRealizarOCadastroDeUmExameSelecionandoUmaCategoriaEAnexandoUmDocumentoESalvar(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoDocumento()
                .botaoSalvar();

        String validarExameCadastrado = exameTela.validarExameCadastrado();
        String validarExameCadastrado2 = exameTela.validarExameCadastrado2();

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), validarExameCadastrado);
        Assertions.assertEquals(exameTela.mensagemSucesso(), validarExameCadastrado2);
    }
    @Test
    @DisplayName("Realizar a exclusão de um exame cadastrado.")
    public void testRealizarAExclusaoDeUmExameCadastrado(){
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
                .botaoAcessoFotoEVideos()
                .excluirExame();

        String validarExameExcluido = exameTela.validarExameExcluido();
        String validarExameExcluido2 = exameTela.validarExameExcluido2();

        Assertions.assertEquals(exameTela.mensagemTudoCerto(), validarExameExcluido);
        Assertions.assertEquals(exameTela.mensagemExcluido(), validarExameExcluido2);
    }
    @Test
    @DisplayName("Realizar o cadastro de um exame sem selecionar uma categoria e sem anexar um Exame.")
    public void testRealizarOCadastroDeUmExameSemSelecionarUmaCategoriaESemAnexarUmExame(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoSalvar();

        String btnDesabilitado = exameTela.validarExamebtnSalvarDisable();

        Assertions.assertEquals(exameTela.mensagemNovo(), btnDesabilitado);
    }

    @Test
    @DisplayName("Realizar clique no botão Anexar exame e na opção Cancelar.")
    public void testRealizarCliqueNoBotaoAnexarExameENaOpcaoCancelar(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoAnexarExame()
                .clicarBtnCancelarAnexar();

        String btnDesabilitado = exameTela.validarExamebtnSalvarDisable();

        Assertions.assertEquals(exameTela.mensagemNovo(), btnDesabilitado);
    }
    @Test
    @DisplayName("Realizar clique no campo Selecione a categoria e na opção Cancelar.")
    public void testRealizarCliqueNoCampoSelecioneACategoriaENaOpcaoCancelar(){
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
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .btnCategoria()
                .clicarBtnCancelarCategoria();

        String btnDesabilitado = exameTela.validarExamebtnSalvarDisable();

        Assertions.assertEquals(exameTela.mensagemNovo(), btnDesabilitado);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}