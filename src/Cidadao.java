public class Cidadao extends Pessoa{
    private String dtPrimeiraDose;
    private String dtSegundaDose;
    private String dtTerceiraDose;
    private String dtQuartaDose;

    public Cidadao() {
    }

    public String getDtPrimeiraDose() {
        return dtPrimeiraDose;
    }

    public void setDtPrimeiraDose(String dtPrimeiraDose) {
        this.dtPrimeiraDose = dtPrimeiraDose;
    }

    public String getDtSegundaDose() {
        return dtSegundaDose;
    }

    public void setDtSegundaDose(String dtSegundaDose) {
        this.dtSegundaDose = dtSegundaDose;
    }

    public String getDtTerceiraDose() {
        return dtTerceiraDose;
    }

    public void setDtTerceiraDose(String dtTerceiraDose) {
        this.dtTerceiraDose = dtTerceiraDose;
    }

    public String getDtQuartaDose() {
        return dtQuartaDose;
    }

    public void setDtQuartaDose(String dtQuartaDose) {
        this.dtQuartaDose = dtQuartaDose;
    }
    
    public void imprimirDados(){
        System.out.println("Nome: "+getNome());
        System.out.println("Cpf: "+getCpf());        
        System.out.println("1ª dose: "+getDtPrimeiraDose());
        System.out.println("2ª dose: "+getDtSegundaDose());
        System.out.println("3ª dose: "+getDtTerceiraDose());
        System.out.println("4ª dose: "+getDtQuartaDose());
    }
}
