import java.util.Scanner;
import java.util.List;

public class Bibliotecario extends Pessoa  {
    private String searchString;

    public Bibliotecario(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.searchString = "";
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        if (!searchString.isEmpty()) {
            this.searchString = searchString;
        }
    }

    public boolean verificarBibliotecario(int id, String senha) {
        return this.id == id && this.senha.equals(senha);
    }

    public String search() {
        if (searchString.isEmpty()) {
            return "Search string está vazia!";
        }
        return "Resultados da busca para: " + searchString;
    }

    public void adicionarUsuario(List<Usuario> usuarios, Scanner scanner, Validador validador) {
        System.out.println("\n--- Adicionar Novo Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        String cpf;
        do {
            System.out.print("CPF: ");
            cpf = scanner.nextLine();
            if (!validador.validarCpf(cpf)) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!validador.validarCpf(cpf));

        Usuario novoUsuario = new Usuario(usuarios.size() + 1, nome, email, senha, telefone, cpf);
        usuarios.add(novoUsuario);

        System.out.println("\nUsuário adicionado com sucesso! Dados do novo usuário:");
        System.out.println(novoUsuario);
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
    public void emprestarLivroParaUsuario(Usuario usuario, String titulo, String cpf) {
        if (usuario != null && cpf.equals(usuario.getCpf())) {
            usuario.emprestarLivro(titulo);
            System.out.println("Livro \"" + titulo + "\" emprestado com sucesso para o usuário:");
            System.out.println(usuario.toString());
        } else {
            System.out.println("Usuário não encontrado ou CPF inválido.");
        }
    }


    @Override
    public void entradaDados(Scanner sc) {
        super.entradaDados(sc);
        System.out.print("Search: ");
        setSearchString(sc.nextLine());
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Search: " + getSearchString());
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }



}



