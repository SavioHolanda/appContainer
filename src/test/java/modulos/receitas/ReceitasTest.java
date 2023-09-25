package modulos.receitas;

import io.appium.java_client.android.AndroidDriver;
import modulos.driver.AndroidDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.LoginTela;
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
    @DisplayName("Cadastrar uma receita corretamente por camera")
    public void testCadastrarUmaReceitaPorCamera() {
        ReceitaTela receitaTela = new LoginTela(app)
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

        Assertions.assertEquals("Tudo certo!", validarReceitaCadastrado);
        Assertions.assertEquals("Receita salva com sucesso!", validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Cadastrar uma receita corretamente por galeria")
    public void testCadastrarUmaReceitaPorGaleria() {
        ReceitaTela receitaTela = new LoginTela(app)
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

        Assertions.assertEquals("Tudo certo!", validarReceitaCadastrado);
        Assertions.assertEquals("Receita salva com sucesso!", validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Cadastrar uma receita corretamente por documento")
    public void testCadastrarUmaReceitaPorDocumento() {
        ReceitaTela receitaTela = new LoginTela(app)
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

        Assertions.assertEquals("Tudo certo!", validarReceitaCadastrado);
        Assertions.assertEquals("Receita salva com sucesso!", validarReceitaCadastrado2);
    }
    @Test
    @DisplayName("Cadastrar uma receita sem os campos obrigatórios")
    public void testCadastrarSemPreencherOsCamposObrigatórios() {
        String receitaTela = new LoginTela(app)
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
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .campoNomeMedico("")
                .campoCRM("")
                .botaoSalvar()
                .validarCamposObrigatório();

        Assertions.assertEquals("Cadastro de Receitas", receitaTela);
    }
    @Test
    @DisplayName("Clicar no botão cancelar ao entrar na opção anexo")
    public void testClicarNoBotaoCancelar() {
        String receitaTela = new LoginTela(app)
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
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .botaoCadastrarReceita()
                .btnAnexar()
                .btnCancelar()
                .validarCamposObrigatório();

        Assertions.assertEquals("Cadastro de Receitas", receitaTela);
    }
    @Test
    @DisplayName("Clicar sobre receita cadastrada")
    public void testClicarSobreReceitaCadastrada() {
        ReceitaTela receitaTela = new LoginTela(app)
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
                .scroll(0.9,0.35,0.3,0.35)
                .botaoReceita()
                .botaoPermitir()
                .botaoPermitir1()
                .cliqueSobreReceita();

        String validarReceitaCadastrado = receitaTela.dataCadastro();
        String validarReceitaCadastrado2 = receitaTela.Receitas();

        Assertions.assertEquals("Data de Cadastro", validarReceitaCadastrado);
        Assertions.assertEquals("Receitas", validarReceitaCadastrado2);
    }
    @After
    public void fecharDriver(){
        app.quit();
    }
}