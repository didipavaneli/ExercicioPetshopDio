public class MaquinaDeBanho {
    //Capacidades maximas
    private static final int cap_max_agua = 30; //litros
    private static final int cap_max_shampoo = 30; //litros


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
        if(litros <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
        int novoNivel = Math.min(cap_max_agua, nivelAgua + litros);
        System.out.printf("Abastecendo água: %d → %d litros.%n", nivelAgua, novoNivel);
        nivelAgua = novoNivel;
    }

    public void abastecerShampoo(int litros) {
        if(litros <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
        int novoNivel = Math.min(cap_max_shampoo, nivelShampoo + litros);
        System.out.printf("Abastecendo shampoo: %d → %d litros.%n", nivelShampoo, novoNivel);
        nivelShampoo = novoNivel;
    }

    /* ---------- Consultas de nível ---------- */

    public int getNivelAgua() {
        System.out.println("Nível de água: " + nivelAgua + " litros.");
        return nivelAgua;
    }

    public int getNivelShampoo() {
        System.out.println("Nível de shampoo: " + nivelShampoo + " litros.");
        return nivelShampoo;
    }

    /* ---------- Controle de pet ---------- */
    public boolean temPetNoBanho() {
        boolean tem = petNaMaquina != null;
        System.out.println("Tem pet na máquina? " + tem);
        return tem;
    }

    public void colocarPet(String nomePet) {
        if (nomePet == null || nomePet.isBlank())
            throw new IllegalArgumentException("Nome do pet não pode ser vazio.");
        if (petNaMaquina != null)
            throw new IllegalStateException("Já há um pet na máquina. Retire-o antes de colocar outro.");
        petNaMaquina = nomePet;
        petLimpo = false; // novo pet ainda não está limpo
        System.out.println("Pet '" + nomePet + "' colocado na máquina.");
    }

    public void retirarPet() {
        if(petNaMaquina ==null)
            throw new IllegalStateException("Nenhum pet está na máquina para ser retirado.");
        System.out.printf("Retirando pet '" + petNaMaquina + "'.");
        if(!petLimpo){
            System.out.println("Aviso: o pet não foi limpo – a máquina precisará ser limpa antes de aceitar outro pet.");
        }
        petNaMaquina = null;
        petLimpo = false;
    }

    /* ---------- Banho e limpeza ---------- */
    public void darBanho() {
        if (petNaMaquina == null)
            throw new IllegalStateException("Não há pet na máquina para dar banho.");
        if (petLimpo)
            throw new IllegalStateException("O pet já está limpo. Retire-o antes de iniciar outro banho.");
        if(nivelAgua < consumo_agua_banho || nivelShampoo < consumo_shampoo_banho){
            throw new IllegalStateException("Recursos insuficientes para o banho. Abasteça água e/ou shampoo.");
        }
        nivelAgua -= consumo_agua_banho;
        nivelShampoo -= consumo_shampoo_banho;
        petLimpo = true;
        System.out.println("Banho concluído para '" + petNaMaquina + "'. Consumo: "
                + consumo_agua_banho + " L água, " + consumo_shampoo_banho + " L shampoo.");
    }

    public void limparMaquina() {
        if(nivelAgua < consumo_agua_limpeza || nivelShampoo < consumo_shampoo_limpeza){
            throw new IllegalStateException("Recursos insuficientes para a limpeza. Abasteça água e/ou shampoo.");
        }
        nivelAgua -= consumo_agua_limpeza;
        nivelShampoo -= consumo_shampoo_limpeza;
        System.out.println("Máquina limpa. Consumo: "
                + consumo_agua_limpeza + " L água, " +  consumo_shampoo_limpeza + " L shampoo.");
    }

    @Override
    public String toString() {
        return String.format(
                "<Máquina água=%dL, shampoo=%dL, pet=%s, limpo=%b>",
                nivelAgua, nivelShampoo,
                (petNaMaquina == null ? "vazio" : petNaMaquina),
                petLimpo);
    }


}

