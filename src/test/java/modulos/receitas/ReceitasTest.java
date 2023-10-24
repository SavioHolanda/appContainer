package modulos.receitas;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
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

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo câmera e salvar.")
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoCameraESalvar() {
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

        String validarReceitaCadastrado = receitaTela.mensagemDeSucesso();
        String validarReceitaCadastrado2 = receitaTela.mensagemDeSucesso2();

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), validarReceitaCadastrado);
        Assertions.assertEquals(receitaTela.mensagemSucesso(), validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo galeria de imagens e salvar.")
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoGaleriaDeImagensESalvar() {
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

        String validarReceitaCadastrado = receitaTela.mensagemDeSucesso();
        String validarReceitaCadastrado2 = receitaTela.mensagemDeSucesso2();

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), validarReceitaCadastrado);
        Assertions.assertEquals(receitaTela.mensagemSucesso(), validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Realizar o cadastro de uma receita com nome do medico, CRM do medico e anexar o exame do tipo Documentos e salvar.")
    public void testRealizarOCadastroDeUmaReceitaComNomeDoMedicoCrmDoMedicoEAnexarOExameDoTipoDocumentosESalvar() {
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

        String validarReceitaCadastrado = receitaTela.mensagemDeSucesso();
        String validarReceitaCadastrado2 = receitaTela.mensagemDeSucesso2();

        Assertions.assertEquals(receitaTela.mensagemTudoCerto(), validarReceitaCadastrado);
        Assertions.assertEquals(receitaTela.mensagemSucesso(), validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Realizar o cadastro de uma receita sem preencher o nome do medico, CRM do médico e sem anexo de receita e clicar em salvar.")
    public void testRealizarOCadastroDeUmaReceitaSemPreencherONomeDoMedicoCrmDoMedicoESemAnexoDeReceitaEClicarEmSalvar() {
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

        String validarReceitaCadastrado = receitaTela.validarCamposObrigatório();

        Assertions.assertEquals(receitaTela.mensagemBtnDesabilitado(), validarReceitaCadastrado);
    }
    @Test
    @DisplayName("Realizar o clique no botão Anexar Receita e na opção Cancelar.")
    public void testRealizarOCliqueNoBotaoAnexarReceitaENaOpcaoCancelar() {
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

        String validarReceitaCadastrado = receitaTela.validarCamposObrigatório();

        Assertions.assertEquals(receitaTela.mensagemBtnDesabilitado(), validarReceitaCadastrado);
    }
    @After
    public void fecharDriver(){
        app.quit();
    }
}