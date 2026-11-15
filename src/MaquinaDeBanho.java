public class MaquinaDeBanho {
    //Capacidades maximas
    private static final int cap_max_agua = 30; //litros
    private static final int cap_min_agua = 30; //litros


    //consumos
    private static final int consumo_agua_banho = 10;   // litros por banho
    private static final int consumo_shampoo_banho = 2; // litros por banho
    private static final int consumo_agua_limpeza = 3;  // litros por limpeza
    private static final int consumo_shampoo_limpeza = 1; // litros por limpeza


    // Estado interno
    private int nivelAgua;      // litros disponíveis
    private int nivelShampoo;   // litros disponíveis
    private String petNaMaquina; // nome do pet (null se vazio)
    private boolean petLimpo;   // true se o banho já foi concluído

    public MaquinaDeBanho() {
        this.nivelAgua = 0;
        this.nivelShampoo = 0;
        this.petNaMaquina = null;
        this.petLimpo = false;
        System.out.println("Máquina criada – vazio e sem recursos.");
    }

    /* ---------- Operações de abastecimento ---------- */
    public void abastecerAgua(int litros) {

    }

    public void abastecerShampoo(int litros) {

    }

    /* ---------- Consultas de nível ---------- */

    public int getNivelAgua() {

    }

    public int getNivelShampoo() {

    }

    /* ---------- Controle de pet ---------- */
    public boolean temPetNoBanho() {

    }

    public void colocarPet(String nomePet) {

    }

    public void retirarPet() {


    }

    /* ---------- Banho e limpeza ---------- */
    public void darBanho() {


    }

    public void limparMaquina() {

    }


}

