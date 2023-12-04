package telas;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PerfilTela {
    private AndroidDriver app;

    public PerfilTela(AndroidDriver app) {
        this.app = app;
    }

    public PerfilTela txtNome(String txtNome){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).sendKeys(txtNome);
        return this;
    }
    public PerfilTela txtSobreNome(String txtSobreNome){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText")).sendKeys(txtSobreNome);
        app.hideKeyboard();
        return this;
    }
    public PerfilTela txtGrupoSanguineo(String txtGrupoSanguineo){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.EditText")).click();
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.EditText")).sendKeys(txtGrupoSanguineo);
        app.hideKeyboard();
        return this;
    }
    public PerfilTela txtTelefone(String txtTelefone){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.EditText")).sendKeys(txtTelefone);
        app.hideKeyboard();
        return this;
    }
    public PerfilTela txtCep(String txtCep){
        app.findElement(By.xpath("//android.widget.EditText[@text=\"61.932-600\"]")).sendKeys(txtCep);
        app.hideKeyboard();
        return this;
    }

    public PerfilTela btnSalvar(){
        app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]")).click();
        return this;
    }
    public String msnEndereco(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.EditText")).getText();
    }
    public String msnEstado(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]/android.view.ViewGroup/android.widget.EditText")).getText();
    }
    public String msnCidade(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[10]/android.view.ViewGroup/android.widget.EditText")).getText();
    }
    public String msnBairro(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[11]/android.view.ViewGroup/android.widget.EditText")).getText();
    }
    public String msnTelefone(){
        return app.findElement(By.xpath("//android.widget.EditText[@text=\"Telefone\"]")).getText();
    }
    public String alertaSucesso(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }
    public String msnSucesso(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }
    public String alertaFalho(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
    }
    public String msnFalho(){
        return app.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
    }
    public String msnCEP(){
        return app.findElement(By.xpath("//android.widget.EditText[@text=\"CEP\"]")).getText();
    }

    public PerfilTela btnAlterarSenha(){
        app.findElement(By.xpath("//android.widget.TextView[@text=\"ALTERAR SENHA\"]")).click();
        return this;
    }
    public PerfilTela txtNovaSenha(String novaSenha){
        app.findElement(By.xpath("//android.widget.EditText[@text=\"Nova Senha\"]")).sendKeys(novaSenha);
        return this;
    }
    public PerfilTela txtConfirmarSenha(String ConfirmarSenha){
        app.findElement(By.xpath("//android.widget.EditText[@text=\"Confirmar senha\"]")).sendKeys(ConfirmarSenha);
        return this;
    }
    public PerfilTela btnSalvarSenha(){
        app.findElement(By.xpath("//android.widget.TextView[@text=\"SALVAR\"]")).click();
        return this;
    }
    public String alertaTudoCerto(){
        return app.findElement(By.xpath("//android.widget.TextView[@text=\"Tudo certo!\"]")).getText();
    }
    public String mensagemTudoCerto(){
        return app.findElement(By.xpath("//android.widget.TextView[@text=\"Senha Alterada com acesso. Utilize-a no próximo acesso.\"]")).getText();
    }
    public String mensagemCampoObrigatorioNovaSenha(){
        return app.findElement(By.xpath("(//android.widget.TextView[@text=\"Campo obrigatório\"])[1]")).getText();
    }
    public String mensagemCampoObrigatorioConfirmSenha(){
        return app.findElement(By.xpath("(//android.widget.TextView[@text=\"Campo obrigatório\"])[2]")).getText();
    }
    public PerfilTela clear(){
        //mudar o xpath dos dois
        app.findElement(By.xpath("//android.widget.EditText[@text=\"Nova Senha\"]")).clear();
        app.findElement(By.xpath("//android.widget.EditText[@text=\"Confirmar senha\"]")).clear();
        return this;
    }

    /*** Mensagens de retorno ***/
    public String mensagemAlertaSucesso(){
        return "Tudo certo!";
    }
    public String mensagemSucesso(){
        return "Cadastro atualizado com sucessso.";
    }
    public String mensagemAlertaFalho(){
        return "O processo falhou.";
    }
    public String mensagemFalho(){
        return "Por favor, revise seus dados e tente novamente.";
    }
    public String mensagemTelefone(){
        return "Telefone";
    }
    public String mensagemCEP(){
        return "CEP";
    }
    public String mensagemSucessoSenha(){
        return "Senha Alterada com acesso. Utilize-a no próximo acesso.";
    }
    public String mensagemCamposSenha(){
        return "Campo obrigatório";
    }
}