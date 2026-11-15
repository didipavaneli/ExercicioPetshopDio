public class Principal {
    public static void main(String[] args) {
        MaquinaDeBanho m = new MaquinaDeBanho();
        // 1️⃣ Abastecer recursos (máximo permitido)
        m.abastecerAgua(30);
        m.abastecerShampoo(10);
        // ------------------------------
        // Primeiro pet
        // ------------------------------
        m.colocarPet("Bud");
        m.darBanho();      // consome 10 L água + 2 L shampoo
        m.retirarPet();    // bud já está limpo → pode remover livremente
        // ------------------------------
        // Segundo pet
        // ------------------------------
        m.colocarPet("Mia");
        m.darBanho();      // consome mais 10 L água + 2 L shampoo
        m.retirarPet();    // retire antes de tentar outro banho
        // ------------------------------
        // Se precisar limpar a máquina (por exemplo, após remover um pet sujo)
        // ------------------------------
        m.limparMaquina(); // consome 3 L água + 1 L shampoo
        // ------------------------------
        // Reabastecer o que foi consumido na limpeza
        // ------------------------------
        m.abastecerAgua(5);
        m.abastecerShampoo(2);
        // ------------------------------
        // Terceiro pet (ou o mesmo novamente)
        // ------------------------------
        m.colocarPet("Luna");
        m.darBanho();
        m.retirarPet();
        // Estado final da máquina
        System.out.println(m);
    }
}