package br.senac.pi.lavanderia.util;

/**
 * Utilitario simples para tratamento e validacao basica de CPF.
 * Regra utilizada em autenticacao (CPF + Matricula) sem depender de banco.
 *
 * Observacao: esta validacao e propositalmente simples (formato e digitos iguais),
 * para servir como exemplo de teste unitario na disciplina.
 */
public final class CpfUtils {

    private CpfUtils() {}

    /** Remove pontos, tracos e qualquer caractere nao numerico. */
    public static String normalizar(String cpf) {
        if (cpf == null) return null;
        return cpf.replaceAll("\\D", "");
    }

    /**
     * Validacao basica:
     * - nao pode ser nulo
     * - deve ter 11 digitos
     * - nao pode ter todos os digitos iguais (ex: 00000000000)
     */
    public static boolean isValidoBasico(String cpf) {
        String n = normalizar(cpf);
        if (n == null) return false;
        if (n.length() != 11) return false;

        // Verifica se todos os caracteres sao iguais
        char first = n.charAt(0);
        boolean allEqual = true;
        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) != first) {
                allEqual = false;
                break;
            }
        }
        return !allEqual;
    }
}
