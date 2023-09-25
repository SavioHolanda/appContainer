package modulos.exame;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.ExameTela;
import telas.LoginTela;

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
    @DisplayName("Cadastrar um exame corretamente por Galeria")
    public void testCadastrarUmExameCorretamentePorGaleria(){
        ExameTela exameTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .campoSelecioneCategoria("Raio-X")
                .botaoAnexarExame()
                .botaoGaleria()
                .botaoSalvar();

        String validarExameCadastrado = exameTela.validarExameCadastrado();
        String validarExameCadastrado2 = exameTela.validarExameCadastrado2();

        Assertions.assertEquals("Tudo certo!", validarExameCadastrado);
        Assertions.assertEquals("Exame enviado com sucesso!", validarExameCadastrado2);
    }
    @Test
    @DisplayName("Cadastrar um exame corretamente por Câmera")
    public void testCadastrarUmExameCorretamentePorCamera(){
        ExameTela exameTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals("Tudo certo!", validarExameCadastrado);
        Assertions.assertEquals("Exame enviado com sucesso!", validarExameCadastrado2);
    }
    @Test
    @DisplayName("Cadastrar um exame corretamente por Documento")
    public void testCadastrarUmExameCorretamentePorDocumento(){
        ExameTela exameTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
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

        Assertions.assertEquals("Tudo certo!", validarExameCadastrado);
        Assertions.assertEquals("Exame enviado com sucesso!", validarExameCadastrado2);
    }
    @Test
    @DisplayName("Excluir um exame")
    public void testExcluirUmExame(){
        ExameTela exameTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .excluirExame();

        String validarExameExcluido = exameTela.validarExameExcluido();
        String validarExameExcluido2 = exameTela.validarExameExcluido2();

        Assertions.assertEquals("Tudo certo!", validarExameExcluido);
        Assertions.assertEquals("Exame excluído com sucesso!", validarExameExcluido2);
    }
    @Test
    @DisplayName("Cadastrar um exame sem categoria e anexo")
    public void testCadastrarUmExameSemCategoriaEAnexo(){
         String mensagemRetorno = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoSalvar()
                .validarExamebtnSalvarDisable();

        Assertions.assertEquals("Adicionar novo", mensagemRetorno);
    }
    @Test
    @DisplayName("Validar os dados de um exame cadastrado")
    public void testParaValidarOsDadosDeUmExameCadastrado(){
        ExameTela exameTela = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .clicarSobreExame();

        String campoTipoExame = exameTela.CampoTipoExame();
        String CampoData = exameTela.CampoData();
        String ExameAnexados = exameTela.campoExamesAnexados();

        Assertions.assertEquals("Tipo de Exame:", campoTipoExame);
        Assertions.assertEquals("Data", CampoData);
        Assertions.assertEquals("Exames Anexados", ExameAnexados);
    }
    @Test
    @DisplayName("Validar o botão cancelar em anexar")
    public void testParaValidarOBotaoCancelarEmAnexar(){
        String mensagemRetorno = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .botaoAnexarExame()
                .clicarBtnCancelarAnexar()
                .validarExamebtnSalvarDisable();

        Assertions.assertEquals("Adicionar novo", mensagemRetorno);
    }
    @Test
    @DisplayName("Validar o botão cancelar em categoria")
    public void testParaValidarOBotaoCancelarEmCategoria(){
        String mensagemRetorno = new LoginTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .escreverCPF("02971008312")
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .scroll(0.5,0.90,0.5,0.04)
                .selecionarEmpresa("DIMENSA S.A. 149")
                .enviarEmpresa()
                .botaoExame()
                .botaoPermitirFotoEVideos()
                .botaoAcessoFotoEVideos()
                .botaoAdicionarNovo()
                .btnCategoria()
                .clicarBtnCancelarCategoria()
                .validarExamebtnSalvarDisable();

        Assertions.assertEquals("Adicionar novo", mensagemRetorno);
    }

    @After
    public void fecharDriver(){
        app.quit();
    }
}