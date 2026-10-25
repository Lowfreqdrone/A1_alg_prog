import java.util.ArrayList;
import java.util.List;

public class Gerir {
    private List<Colab> cols = new ArrayList<>();

    public boolean add(Colab c) {
        if (buscar(c.getMat()) != null) {
            System.out.println("Já existe um colaborador com essa matrícula!");
            return false;
        }
        cols.add(c);
        System.out.println("Colaborador cadastrado!");
        return true;
    }

    public void listar() {
        if (cols.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Colaboradores ---");
        for (Colab c : cols) {
            System.out.println(c);
        }
    }

    public Colab buscar(String mat) {
        for (Colab c : cols) {
            if (c.getMat().equals(mat)) return c;
        }
        return null;
    }

    public boolean atual(String mat, String nm, Double vend, Double perc,
                         Integer qtd, Double vlr) {
        Colab c = buscar(mat);
        if (c == null) {
            System.out.println("Colaborador não encontrado.");
            return false;
        }
        if (nm != null && !nm.isBlank()) c.setNm(nm);

        if (c instanceof Comm cm) {
            if (vend != null) cm.setVend(vend);
            if (perc != null) cm.setPerc(perc);
        } else if (c instanceof Prod pr) {
            if (qtd != null) pr.setQtd(qtd);
            if (vlr != null) pr.setVlr(vlr);
        }
        System.out.println("Colaborador atualizado!");
        return true;
    }

    public boolean rem(String mat) {
        Colab c = buscar(mat);
        if (c == null) {
            System.out.println("Colaborador não encontrado.");
            return false;
        }
        cols.remove(c);
        System.out.println("Colaborador removido!");
        return true;
    }

    public void folha(String mat) {
        Colab c = buscar(mat);
        if (c == null) {
            System.out.println("Colaborador não encontrado.");
            return;
        }
        System.out.println("\n--- Folha de Pagamento ---");
        System.out.println(c);
    }

    public void folhaTodos() {
        if (cols.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("\n=== FOLHA DE PAGAMENTO GERAL ===");
        double tot = 0;
        for (Colab c : cols) {
            System.out.println(c);
            tot += c.calcPag();
        }
        System.out.printf("------------------------------%n");
        System.out.printf("TOTAL DA FOLHA: R$ %.2f%n", tot);
    }
}
