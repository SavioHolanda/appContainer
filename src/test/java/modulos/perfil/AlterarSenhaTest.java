package modulos.perfil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driver.AndroidDriverProvider;
import driver.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import telas.BemVindoTela;
import telas.PerfilTela;

import java.util.concurrent.TimeUnit;

public class AlterarSenhaTest {
    private AndroidDriver app;
    private ExtentReports extent = TestBase.getInstance();
    private ExtentTest test;

    @Before
    @DisplayName("Metodo de abertura do driver")
    public void abrirDriver() {
        this.app = AndroidDriverProvider.getDriver();
        this.app.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void RealizarOPreenchimentoDosDoisCamposComAMenmaSenhaCorretamenteDigitandoNoMinimo8CaracteresSendoLetraMaiusculaLetraMinusculaNumeroECaractereEspecial(){
        test = extent.createTest("Realizar o preenchimento dos dois campos com a mesma senha corretamente, digitando no mínimo 8 caracteres sendo letra maiúscula, letra minúscula, numero e caractere especial.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .btnAlterarSenha()
                .txtNovaSenha("Fale1234@")
                .txtConfirmarSenha("Fale1234@")
                .btnSalvarSenha();

        if(perfilTela.alertaTudoCerto().equals(perfilTela.mensagemAlertaSucesso()) && perfilTela.mensagemTudoCerto().equals(perfilTela.mensagemSucessoSenha()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(perfilTela.alertaTudoCerto(), perfilTela.mensagemAlertaSucesso());
        Assertions.assertEquals(perfilTela.mensagemTudoCerto(), perfilTela.mensagemSucessoSenha());
    }

    @Test
    public void RealizarOPreenchimentoEPreenchimentoEApagarNosCamposNovaSenhaEConfirmarSenha(){
        test = extent.createTest("Realizar o preenchimento e apagar nos campos Nova senha e Confirmar senha.");
        PerfilTela perfilTela = new BemVindoTela(app)
                .botaoAvancar()
                .botaoAvancar()
                .botaoAvancar()
                .txtCpf("48135484070")
                .btnAvancarSimples()
                .escreverSenha("Fale1234@")
                .botaoEntrar()
                .botaoHome()
                .btnMeuPerfil()
                .btnAlterarSenha()
                .txtNovaSenha("a")
                .txtConfirmarSenha("a")
                .clear();

        if(perfilTela.mensagemCampoObrigatorioNovaSenha().equals(perfilTela.mensagemCamposSenha()) && perfilTela.mensagemCampoObrigatorioConfirmSenha().equals(perfilTela.mensagemCamposSenha()) ){
            test.pass("Teste Aprovado");
        }else{
            test.fail("Teste Reprovado");
        }

        Assertions.assertEquals(perfilTela.mensagemCampoObrigatorioNovaSenha(), perfilTela.mensagemCamposSenha());
        Assertions.assertEquals(perfilTela.mensagemCampoObrigatorioConfirmSenha(), perfilTela.mensagemCamposSenha());
    }
}
